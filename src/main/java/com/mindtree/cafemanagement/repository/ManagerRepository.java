package com.mindtree.cafemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.cafemanagement.entity.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {

}
