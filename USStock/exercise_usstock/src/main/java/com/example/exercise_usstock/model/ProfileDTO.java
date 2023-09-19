package com.example.exercise_usstock.model;

import java.time.LocalDate;
import jakarta.annotation.Generated;
import lombok.Builder;
import lombok.Getter;
@Builder
@Getter
public class ProfileDTO {
  private String country;
  private String companyName;
  private LocalDate ipoDate;
  private String logo;
  private double marketCap;
  private String currency;

}

