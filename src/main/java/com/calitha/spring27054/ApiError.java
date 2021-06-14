package com.calitha.spring27054;

public class ApiError {

  private final String message;

  public ApiError(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
