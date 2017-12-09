package com.springwithjersey.rest.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springwithjersey.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

  User findByEmail(String email);
}
