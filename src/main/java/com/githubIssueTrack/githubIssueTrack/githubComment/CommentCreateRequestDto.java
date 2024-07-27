package com.githubIssueTrack.githubIssueTrack.githubComment;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentCreateRequestDto {

    private Long id;
    private String url;
    private Long user;
    private Date created_at;
    private Date updated_at;
    private String authorAssociation;
    private String body;
    private Long reactions;

}
