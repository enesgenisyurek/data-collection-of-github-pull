package com.githubIssueTrack.githubIssueTrack.githubMilestone;

import com.githubIssueTrack.githubIssueTrack.githubUser.GithubUser;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class GithubMilestone {


    private Long id;
    private String url;
    private String html_url;
    private String labels_url;
    private Long number;
    private String node_id;
    private String title;
    private String description;
    private GithubUser creator;


}
