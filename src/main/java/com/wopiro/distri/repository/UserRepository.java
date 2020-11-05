package com.wopiro.distri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wopiro.distri.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}