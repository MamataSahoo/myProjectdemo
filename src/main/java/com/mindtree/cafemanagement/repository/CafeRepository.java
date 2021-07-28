package com.mindtree.cafemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mindtree.cafemanagement.entity.Cafe;

public interface CafeRepository extends JpaRepository<Cafe, Integer> {

	@Query(value = "SELECT * FROM CAFE WHERE MANAGER_ID=:id",nativeQuery = true)
	List<Cafe> getCafeByManager(int id);

}
