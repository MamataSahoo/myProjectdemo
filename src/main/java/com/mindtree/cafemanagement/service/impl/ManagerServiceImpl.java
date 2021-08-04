package com.mindtree.cafemanagement.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mindtree.cafemanagement.dto.ManagerDto;
import com.mindtree.cafemanagement.entity.Manager;
import com.mindtree.cafemanagement.repository.ManagerRepository;
import com.mindtree.cafemanagement.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	ManagerRepository managerRepo;

	ModelMapper modelMapper = new ModelMapper();

	@Override
	public ManagerDto insertManager(ManagerDto managerdto) {
		Manager managerDetails1 = convertDtoToEntity(managerdto);
		Manager managerDetails2 = managerRepo.save(managerDetails1);
		ManagerDto manager2 = modelMapper.map(managerDetails2, ManagerDto.class);;
		return manager2;
	}

	public Manager convertDtoToEntity(ManagerDto managerdto) {
		return modelMapper.map(managerdto, Manager.class);
	}

	public ManagerDto convertEntityToDto(Manager manager) {
		return modelMapper.map(manager, ManagerDto.class);
	}

}
