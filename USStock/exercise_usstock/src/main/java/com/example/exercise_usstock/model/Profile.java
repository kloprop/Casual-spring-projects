package com.example.exercise_usstock.model;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Profile {
 
  private String country;
  private String currency;
  private String estimateCurrency;
  @JsonProperty("finnhubIndustry")
  private String industry;
  private LocalDate ipo;
  private String logo;
  private double marketCapitalization;
  private String name;
  private String phone;
  private double shareOutstanding;
  private String ticker;
  private String weburl;
}



