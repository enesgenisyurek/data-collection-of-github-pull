package com.githubIssueTrack.githubIssueTrack.githubPull;

import com.githubIssueTrack.githubIssueTrack.githubComment.GithubComment;
import com.githubIssueTrack.githubIssueTrack.githubHead.GithubHead;
import com.githubIssueTrack.githubIssueTrack.githubLabel.GithubLabel;
import com.githubIssueTrack.githubIssueTrack.githubMilestone.GithubMilestone;
import com.githubIssueTrack.githubIssueTrack.githubUser.GithubUser;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
public class GithubPull {

    private Long id; //
    private Long number; //
    private String url; //
    private String html_url; //
    private String node_id; //
    private String issue_url;
    private String commits_url;
    private String diff_url;
    private String patch_url;
    private String statuses_url;
    private String title; //
    private Date merged_at;
    private String body; //
    private String state; //
    private boolean isLocked; //
    private Date created_at; //
    private Date updated_at; //
    private Date closed_at; //

    private GithubUser user; //

    private GithubUser assignee; //
    private List<GithubUser> assignees; //

    private Long comments; //
    private String comments_url; //
    private String review_comments_url;
    private List<GithubComment> commentList; //

    private List<GithubLabel> labels; //
    private GithubMilestone milestone; //

    private GithubHead head;
    private GithubHead base;

}
