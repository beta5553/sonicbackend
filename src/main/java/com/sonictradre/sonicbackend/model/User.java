package com.sonictradre.sonicbackend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "user", schema="public")
public class User {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer userId;
    private String userName;
    private String firstName;
    private String lastName;
    private String biography;
    private String password;
    private String email;
    private LocalDate createdDate;
    private LocalDate lastModifiedDate;

}
