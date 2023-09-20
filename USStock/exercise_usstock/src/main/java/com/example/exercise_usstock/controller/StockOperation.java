package com.example.exercise_usstock.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.example.exercise_usstock.exception.FinnException;
import com.example.exercise_usstock.framework.ApiResponse;
import com.example.exercise_usstock.model.Quote;
import com.example.exercise_usstock.model.Stock;

public interface StockOperation {
  
   @GetMapping(value = "/stock/{symbol}")
   @ResponseStatus(value = HttpStatus.OK)
    ApiResponse<Stock> findStock(@PathVariable String symbol) throws FinnException;
}
