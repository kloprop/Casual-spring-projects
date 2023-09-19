package com.example.exercise_usstock.mapper;

import com.example.exercise_usstock.model.Profile;
import com.example.exercise_usstock.model.ProfileDTO;
import com.example.exercise_usstock.model.Quote;
import com.example.exercise_usstock.model.Stock;

public class StockMapper {
  public static Stock map(Quote quote, ProfileDTO profile){
    return Stock.builder()
                .currentPrice(quote.getCurrentPrice())
                .dayHigh(quote.getHighPrice())
                .dayLow(quote.getLowPrice())
                .dayOpen(quote.getOpenPrice())
                .prevDayClose(quote.getPreviousClose())
                .companyProfile(profile)
                .build();

  }

}
