package com.sonictradre.sonicbackend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "post", schema = "public")
public class Post {

    @Id
    private Integer postId;
    private Integer userId;
    private String postTitle;
    private String postContent;
    private String trackId;
    private String coverImage;
    private Date createdDate;

}
