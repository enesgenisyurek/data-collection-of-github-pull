package com.githubIssueTrack.githubIssueTrack.githubLabel;

import lombok.*;


@Data
@Getter
@Setter
public class GithubLabel {


    private Long id;
    private String name;
    private String node_id;
    private String url;
    private String color;
    private boolean isDefault;
    private String description;


}


