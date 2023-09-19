package com.example.exercise_usstock.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.exercise_usstock.enums.Code;
import com.example.exercise_usstock.framework.ApiResponse;
import com.example.exercise_usstock.model.Quote;

@RestControllerAdvice // ResponseBody + @ControllerAdvice
public class GlobalExceptionHandler {
  
  @ExceptionHandler(value = FinnException.class)
  public ResponseEntity<ApiResponse<Void>> getUserExceptionHandler(){
    

    ApiResponse<Void>response =  ApiResponse.<Void>builder()
                  .status(Code.FINN_NOTFOUND)
                  .data(null)
                  .build();
          return ResponseEntity.badRequest().body(response);

  }
}
