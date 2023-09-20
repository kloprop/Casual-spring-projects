package com.example.exercise_usstock.framework;

import com.example.exercise_usstock.framework.enums.Code;

public class ApiResponse<T> {
  // attribute name by default same as JSON field name after serialziation
  private int code;
  private String message;
  private T data;

  public int getCode() {
    return this.code;
  }

  public String getMessage() {
    return this.message;
  }

  public T getData() {
    return this.data;
  }

  private ApiResponse(ApiResponseBuilder<T> builder) {
    this.code = builder.code;
    this.message = builder.message;
    this.data = builder.data;
  }

  public static <T> ApiResponseBuilder<T> builder() {
    return new ApiResponseBuilder<>();
  }

  public static class ApiResponseBuilder<T> {
    private int code;
    private String message;
    private T data;

    public ApiResponseBuilder<T> status(Code code) {
      this.code = code.getCode();
      this.message = code.getDesc();
      return this;
    }

    public ApiResponseBuilder<T> data(T data) {
      this.data = data;
      return this;
    }

    public ApiResponseBuilder<T> errorMessageIfPresent(String message){
        this.message += ": " + message;
        return this;
    }
    public ApiResponseBuilder<T> ok(){
      this.code = Code.OK.getCode();
      this.message = Code.OK.getDesc();
      return this;
    }

    public ApiResponse<T> build() {
      if (this.code == 0 || this.message == null){
        throw new RuntimeException();
      }
      return new ApiResponse<>(this);
    }

  }
}

