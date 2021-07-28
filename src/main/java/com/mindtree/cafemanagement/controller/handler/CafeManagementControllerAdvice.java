package com.mindtree.cafemanagement.controller.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.mindtree.cafemanagement.exception.ControllerException;

@ControllerAdvice
public class CafeManagementControllerAdvice {

	Map<String, Object> response;

	@ExceptionHandler(ControllerException.class)
	public ResponseEntity<Map<String, Object>> ServiceException(ControllerException controllerException,
			WebRequest request) {
		response = new HashMap<String, Object>();
		response.put("message", controllerException.getMessage());
		response.put("status", HttpStatus.BAD_REQUEST);
		response.put("body", null);
		response.put("error", true);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}
}
