package com.mindtree.cafemanagement.service;

import java.util.List;

import com.mindtree.cafemanagement.dto.CafeDto;
import com.mindtree.cafemanagement.exception.ServiceException;


public interface CafeService {

	public CafeDto insertCafe(CafeDto cafe)  throws ServiceException;

	public List<CafeDto> getCafeDetails()  throws ServiceException ;

	public CafeDto deleteCafe(int id);

	public CafeDto getCafeById(int id)throws ServiceException ;

	public CafeDto updateCafe(int id, CafeDto cafe);

	public List<CafeDto> getCafeByManagerId(int id);

}
