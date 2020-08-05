package com.sonictradre.sonicbackend.repository;

import com.sonictradre.sonicbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
