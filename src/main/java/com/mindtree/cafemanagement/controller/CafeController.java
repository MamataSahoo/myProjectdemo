package com.mindtree.cafemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mindtree.cafemanagement.dto.CafeDto;
import com.mindtree.cafemanagement.dto.ManagerDto;
import com.mindtree.cafemanagement.exception.ServiceException;
import com.mindtree.cafemanagement.service.CafeService;
import com.mindtree.cafemanagement.service.ManagerService;

@RestController
public class CafeController {

	@Autowired
	private CafeService cafeService;

	@Autowired
	private ManagerService managerService;

	@PostMapping("/cafe")
	public ResponseEntity<?> insertCafe(@RequestBody CafeDto cafe) throws ServiceException {
		CafeDto addedCafeDto = cafeService.insertCafe(cafe);
		return new ResponseEntity<CafeDto>(addedCafeDto, HttpStatus.CREATED);
	}

	@PostMapping("/manager")
	public ManagerDto insertManger(@RequestBody ManagerDto manager) {
		return this.managerService.insertManager(manager);
	}

	@GetMapping("/cafes")
	public ResponseEntity<?> getCafeDetails() throws ServiceException {
		List<CafeDto> cafeDtoList = cafeService.getCafeDetails();
		return new ResponseEntity<List<CafeDto>>(cafeDtoList, HttpStatus.CREATED);
	}

	@DeleteMapping("/deletecafe/{id}")
	public CafeDto deleteCafe(@PathVariable("id") int id) {
		return cafeService.deleteCafe(id);
	}

	@GetMapping("/getcafebyid/{id}")
	public ResponseEntity<?> getCafeById(@PathVariable("id") int id) throws ServiceException {
		CafeDto foundCafe = cafeService.getCafeById(id);
		return new ResponseEntity<CafeDto>(foundCafe, HttpStatus.CREATED);
	}

	@PutMapping("/updatecafe/{id}")
	public CafeDto updateCafe(@PathVariable("id") int id, @RequestBody CafeDto cafe) {
		return cafeService.updateCafe(id, cafe);
	}

	@GetMapping("/getcafebymanager/{id}")
	public List<CafeDto> getCafeByManagerId(@PathVariable("id") int id) {
		List<CafeDto> cafedato1=cafeService.getCafeByManagerId(id);
		return cafedato1;
	}
}
