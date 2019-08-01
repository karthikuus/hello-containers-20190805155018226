package com.baabbee.iframex;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.HttpStatus;


import com.fasterxml.jackson.annotation.JsonFormat;

class ApiError {

	private HttpStatus status;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	private String message;
	private String debugMessgage;
	private List<ApiSubError> subErrors;
	
	private ApiError() {
		timestamp = LocalDateTime.now();
	}
	
	ApiError(HttpStatus status){
		this();
		this.status =status;
	}
	
	ApiError(HttpStatus status, Throwable ex){
		this();
		this.status = status;
		this.message ="Unexpected Error";
		this.debugMessgage = ex.getLocalizedMessage();
		
	}
	
	ApiError(HttpStatus status, String message, Throwable ex){
		this();
		this.status = status;
		this.message = message;
		this.debugMessgage = ex.getLocalizedMessage();
		
	}
	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	 private void addSubError(ApiSubError subError) {
	        if (subErrors == null) {
	            subErrors = new ArrayList<>();
	        }
	        subErrors.add(subError);
	    }
	   private void addValidationError(String object, String field, Object rejectedValue, String message) {
	        addSubError(new ApiValidationError(object, field, rejectedValue, message));
	    }

	   private void addValidationError(ConstraintViolation<?> cv) {
	        this.addValidationError(
	                cv.getRootBeanClass().getSimpleName(),
	                ((PathImpl) cv.getPropertyPath()).getLeafNode().asString(),
	                cv.getInvalidValue(),
	                cv.getMessage());
	    }

	   void addValidationErrors(Set<ConstraintViolation<?>> constraintViolations) {
	        constraintViolations.forEach(this::addValidationError);
	    }


}
