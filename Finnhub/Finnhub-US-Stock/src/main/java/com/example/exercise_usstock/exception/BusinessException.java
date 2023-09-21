package com.example.exercise_usstock.exception;

import com.example.exercise_usstock.framework.enums.Code;

public class BusinessException extends Exception {

  private Code code;

  public BusinessException(Code code){
    super(code.getDesc());
    this.code = code;

  }
}
