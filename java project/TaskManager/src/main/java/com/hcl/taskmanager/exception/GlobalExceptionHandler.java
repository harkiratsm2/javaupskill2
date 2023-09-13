package com.hcl.taskmanager.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
 
    @ExceptionHandler(value
                      = NoTaskExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse
    handleException(NoTaskExistsException ex)
    {
        return new ErrorResponse(
            HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgsNotValidException(MethodArgumentNotValidException ex)
    {
    	Map<String, String> resp = new HashMap<>();
    	
    	ex.getBindingResult().getAllErrors().forEach((error) -> {
    		String fieldName = ((FieldError)error).getField();
    		String message = error.getDefaultMessage();
    		resp.put(fieldName, message);
    	});
    	
    	return new ResponseEntity<Map<String,String>>(resp, HttpStatus.BAD_REQUEST);
    }
}
