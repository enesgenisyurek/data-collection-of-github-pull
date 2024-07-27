package com.githubIssueTrack.githubIssueTrack.githubUser;

import lombok.*;


@Data
@Getter
@Setter

public class GithubUser {

    private Long id;
    private String login;
    private String type;
    private String url;
    private String html_url;
    private String node_id;
}
