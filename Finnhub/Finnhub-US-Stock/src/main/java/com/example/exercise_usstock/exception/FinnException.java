package com.example.exercise_usstock.exception;

import com.example.exercise_usstock.framework.enums.Code;

public class FinnException extends BusinessException{
  
  public FinnException(Code code){
    super(code);
  }
}
