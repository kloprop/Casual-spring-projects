package com.example.exercise_usstock.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.exercise_usstock.controller.StockOperation;
import com.example.exercise_usstock.exception.FinnException;
import com.example.exercise_usstock.framework.ApiResponse;
import com.example.exercise_usstock.mapper.ProfileMapper;
import com.example.exercise_usstock.mapper.StockMapper;
import com.example.exercise_usstock.model.Profile;
import com.example.exercise_usstock.model.ProfileDTO;
import com.example.exercise_usstock.model.Quote;
import com.example.exercise_usstock.model.Stock;
import com.example.exercise_usstock.service.ProfileService;
import com.example.exercise_usstock.service.QuoteService;

@RestController
@RequestMapping(value = "/api/v1")
public class StockController implements StockOperation {

  @Autowired
  QuoteService quoteService;
  @Autowired
  ProfileService profileService;


  @Override
  public ResponseEntity<ApiResponse<Stock>> findStock(String symbol) throws FinnException{
    Quote quote = quoteService.findQuote(symbol);
    Profile profile = profileService.findProfile(symbol);

    if (profile.getName() == null){
      throw new RuntimeException("Wrong name");
    }
    ProfileDTO profileDTO = ProfileMapper.map(profile);
    Stock stock = StockMapper.map(quote,profileDTO);
    ApiResponse<Stock> response = ApiResponse.<Stock>builder()
                                  .ok()//
                                  .data(stock)
                                  .build(); 
    return ResponseEntity.ok().body(response);
  }


}
