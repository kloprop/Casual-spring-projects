package com.example.exercise_usstock.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Stock {
  private ProfileDTO companyProfile;
  private double currentPrice;
  private double dayHigh;
  private double dayLow;
  private double dayOpen;
  private double prevDayClose; 
}
