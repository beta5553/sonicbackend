package com.sonictradre.sonicbackend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "track", schema = "public")
public class Track {

    @Id
    private Integer trackId;
    private Integer userId;
    private Integer postId;
    private Integer reproductions;
    private Double price;
    private String location;
    private String format;
    private String description;
    private Integer likes;
    private Date createdDate;

}
