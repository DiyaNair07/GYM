package com.gymmanagement.gymmanagement.repository;

import com.gymmanagement.gymmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    User findByEmailId(String userName);
}
