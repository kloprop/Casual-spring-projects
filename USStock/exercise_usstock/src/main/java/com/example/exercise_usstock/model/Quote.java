package com.example.exercise_usstock.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Quote {
  @JsonProperty("c")
  private double currentPrice;
  @JsonProperty("d")
  private double change;
  @JsonProperty("dp")
  private double percentChange;
  @JsonProperty("h")
  private double highPrice;
  @JsonProperty("l")
  private double lowPrice;
  @JsonProperty("o")
  private double openPrice;
  @JsonProperty("pc")
  private double previousClose;
}
