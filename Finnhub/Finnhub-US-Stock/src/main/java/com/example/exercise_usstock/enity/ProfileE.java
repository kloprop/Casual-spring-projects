package com.example.exercise_usstock.enity;

import java.io.Serializable;
import java.time.LocalDate;
import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "finnhub_stocks")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProfileE implements Serializable{
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  //@Column(name = "country")
  private String country;

  @Column(name = "company_name")
  private String companyName;

  @Column(name = "ipo_date")
  private LocalDate ipoDate;
  
  //@Column(name = "logo")
  private String logo;

  @Column (name = "market_cap", columnDefinition = "NUMERIC(15,2)")
  private double marketCap;

  //@Column(name = "currency")
  private String currency;
}
