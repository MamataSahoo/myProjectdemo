package com.mindtree.cafemanagement.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.cafemanagement.dto.CafeDto;
import com.mindtree.cafemanagement.entity.Cafe;
import com.mindtree.cafemanagement.exception.ServiceException;
import com.mindtree.cafemanagement.exception.service.InvalidCafeException;
import com.mindtree.cafemanagement.exception.service.NoCafeFoundException;
import com.mindtree.cafemanagement.repository.CafeRepository;
import com.mindtree.cafemanagement.service.CafeService;

@Service
public class CafeServiceImpl implements CafeService {

	@Autowired
	private CafeRepository cafeRepo;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public CafeDto insertCafe(CafeDto cafedto) throws ServiceException {

		try {
			Cafe cafe = convertDtoToEntity(cafedto);
			System.out.println(cafe.getName());
			if (cafe.getName() == null || cafe.getName() == "") {
				throw new InvalidCafeException("Cafe name is Empty");
			}
			Cafe cafe1 = cafeRepo.save(cafe);
			CafeDto cafe2 = convertEntityToDto(cafe1);
			return cafe2;
		} catch (InvalidCafeException e) {
			throw new ServiceException(e.getMessage());
		}

	}

	public Cafe convertDtoToEntity(CafeDto cafedto) {
		return modelMapper.map(cafedto, Cafe.class);
	}

	public CafeDto convertEntityToDto(Cafe cafe) {
		return modelMapper.map(cafe, CafeDto.class);
	}

	@Override
	public List<CafeDto> getCafeDetails() throws ServiceException {
		try {
			List<CafeDto> cafeList = new ArrayList<CafeDto>();
			for (Cafe i : cafeRepo.findAll()) {
				cafeList.add(convertEntityToDto(i));
			}
			if (cafeList.size() == 0) {
				throw new NoCafeFoundException("No Such Cafe Found");
			}
			return cafeList;
		} catch (NoCafeFoundException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public CafeDto deleteCafe(int id) {
		CafeDto cafeDeleted = convertEntityToDto(cafeRepo.getById(id));
		cafeRepo.deleteById(id);
		if (cafeRepo.getById(id) != null) {
			return cafeDeleted;
		}
		return null;
	}

	@Override
	public CafeDto getCafeById(int id) throws ServiceException {
		CafeDto getCafe = null;
		Cafe foundCafe = cafeRepo.findById(id).get();
		if (foundCafe != null) {
			getCafe = convertEntityToDto(cafeRepo.getById(id));
		} else {
			throw new NoCafeFoundException("No Such Cafe Found");
		}
		return getCafe;
	}

	@Override
	public CafeDto updateCafe(int id, CafeDto cafe) {
		CafeDto updatedCafe = convertEntityToDto(cafeRepo.save(convertDtoToEntity(cafe)));
		if (cafeRepo.getById(id) != null) {
			return updatedCafe;
		}
		return null;
	}

	@Override
	public List<CafeDto> getCafeByManagerId(int id) {
		List<Cafe> cafeList = cafeRepo.getCafeByManager(id);
		List<CafeDto> cafeDtoList = new ArrayList<CafeDto>();
		for (Cafe i : cafeList) {
			cafeDtoList.add(convertEntityToDto(i));
		}
		return cafeDtoList;
	}

}
