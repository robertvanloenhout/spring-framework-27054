package com.calitha.spring27054;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<ApiError> handler(IllegalArgumentException exception) {
    ApiError apiError = new ApiError(exception.toString());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
  }
}
