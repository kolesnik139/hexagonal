package com.example.hexagonal.adapter.secondary.repository;

import com.example.hexagonal.adapter.secondary.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJPARepository extends JpaRepository<User, Integer> {
}
