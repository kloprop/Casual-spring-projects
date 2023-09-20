package com.example.exercise_usstock.framework.enums;

import lombok.Getter;

@Getter
public enum Code {
  OK (20000, "OK"),//
  NOTFOUND(40000, "Resource NOT FOUND"),//
  FINN_NOTFOUND(40001, "Finnlab RestClientException"),//
  

  // Server
  SERVER_TIMEOUT(50000, "Server Timeout"),//

  ILLEGAL_ARGUMENT(60000, "Illegal argrument"),//

  UnKNOWNERROR(90000, "Unknown Error");
  ;

  private int code;
  private String desc;

  private Code(int code, String desc){
    this.code = code;
    this.desc = desc;
  }
}
