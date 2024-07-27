package com.githubIssueTrack.githubIssueTrack.githubPull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/github")
public class GithubPullController {

    @Autowired
    private GithubPullServices githubPullServices;

    @GetMapping("/repos/{owner}/{repo}/pulls")
    public List<GithubPull> getAllRepoIssues(@PathVariable String owner, @PathVariable String repo) {
        return githubPullServices.getAllRepoPulls(owner,repo);
    }

}