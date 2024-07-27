package com.githubIssueTrack.githubIssueTrack.githubPull;

import com.githubIssueTrack.githubIssueTrack.githubComment.GithubComment;
import com.githubIssueTrack.githubIssueTrack.githubComment.GithubCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class GithubPullServices {

    @Value("${github.api.base-url}")
    private String githubApiBaseUrl;

    @Value("${github.auth.token}")
    private String authToken;

    @Value("${spring.codec.max-in-memory-size}")
    private String maxMemorySize;

    @Autowired
    private GithubCommentService githubCommentService;


    public List<GithubPull> getAllRepoPulls(String owner, String repo) {
        WebClient webClient = WebClient.builder()
                .baseUrl(githubApiBaseUrl)
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + authToken)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader("X-GitHub-Api-Version", "2022-11-28")
                .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(1024 * 1024 * 500))
                .build();

        List<GithubPull> allPulls = new ArrayList<>();
        int page = 1;
        boolean hasNextPage = true;

        while (page<3) {
            try {
                List<GithubPull> pulls = webClient.get()
                        .uri("/repos/{owner}/{repo}/pulls?page={page}&per_page=100&state=closed", owner, repo, page)
                        .retrieve()
                        .onStatus(HttpStatus::is4xxClientError, clientResponse ->
                                Mono.error(new RuntimeException("Client error: " + clientResponse.statusCode())))
                        .onStatus(HttpStatus::is5xxServerError, clientResponse ->
                                Mono.error(new RuntimeException("Server error: " + clientResponse.statusCode())))
                        .bodyToFlux(GithubPull.class)
                        .collectList()
                        .block();

                for (GithubPull pull : pulls) {
                    List<GithubComment> comments = githubCommentService.getIssueComments(owner, repo, pull.getNumber());
                    pull.setCommentList(comments);

                }
                allPulls.addAll(pulls);
                page++;

            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
        return allPulls;
    }
}
