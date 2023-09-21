package com.example.exercise_usstock.model.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.exercise_usstock.model.Profile;
import com.example.exercise_usstock.model.ProfileDTO;
import com.example.exercise_usstock.model.Quote;
import com.example.exercise_usstock.model.Stock;

//@Component // so that this would appear in context, no need to create a new and ensure di
public class StockMapper {

  @Autowired
  private ModelMapper modelMapper;

  public  static Stock map(Quote quote, ProfileDTO profile){
    return Stock.builder()
                .currentPrice(quote.getCurrentPrice())
                .dayHigh(quote.getHighPrice())
                .dayLow(quote.getLowPrice())
                .dayOpen(quote.getOpenPrice())
                .prevDayClose(quote.getPreviousClose())
                //.companyProfile(modelMapper.map(profile, ProfileDTO.class))
                .companyProfile(profile)
                .build();

  }

}
