package com.example.exercise_usstock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.exercise_usstock.framework.ApiResponse;
import com.example.exercise_usstock.framework.enums.Code;
import com.example.exercise_usstock.model.Quote;
import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice // @ResponseBody + @ControllerAdvice
public class GlobalExceptionHandler {
  
  /* @ExceptionHandler(value = FinnException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ApiResponse<Void> getUserExceptionHandler(){
    ApiResponse<Void>response =  ApiResponse.<Void>builder()
                  .status(Code.FINN_NOTFOUND)
                  .data(null)
                  .build();
          return response;
  } */
  
  @ExceptionHandler(value = Exception.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ApiResponse<Void> exceptionHandler(Exception e){
    ApiResponse<Void>response =  ApiResponse.<Void>builder()
                  .status(findCode(e))
                  .errorMessageIfPresent(e.getMessage())
                  .data(null)
                  .build();
          return response;
  }
  private Code findCode(Exception e){
    if (e instanceof IllegalArgumentException)
      return Code.ILLEGAL_ARGUMENT;
    
    if (e instanceof FinnException)
      return Code.FINN_NOTFOUND;
    
    if (e instanceof EntityNotFoundException)
      return Code.NOTFOUND;
      
    return Code.UnKNOWNERROR;
    }
    // switch 
    
}
