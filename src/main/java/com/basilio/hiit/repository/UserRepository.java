package com.basilio.hiit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.basilio.hiit.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {

}
