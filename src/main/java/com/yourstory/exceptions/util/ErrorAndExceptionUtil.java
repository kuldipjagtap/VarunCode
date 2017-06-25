package com.yourstory.exceptions.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.Errors;

public class ErrorAndExceptionUtil {
	public static Map<String,String> getErrors(Errors errors) {
		if(errors.hasErrors()){
			Map<String, String> errorsInFields = new HashMap<>();
			errors.getFieldErrors().stream().map(x -> errorsInFields.put(x.getField(),x.getDefaultMessage()));
			return errorsInFields;
		}
		return null;
	}
	
	public static boolean isEmpty(String value){
		return (value == null || value.isEmpty()) ? true : false; 
	}
}
