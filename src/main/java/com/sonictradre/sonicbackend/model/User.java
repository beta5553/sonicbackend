package com.sonictradre.sonicbackend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "user", schema="public")
public class User {

    @Id
    private Integer userId;
    private String userName;
    private String firstName;
    private String lastName;
    private String biography;
    private String password;
    private String email;
    private Date createdDate;

}
