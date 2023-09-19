package com.example.exercise_usstock.mapper;

import com.example.exercise_usstock.model.Profile;
import com.example.exercise_usstock.model.ProfileDTO;

public class ProfileMapper {

  public static ProfileDTO map (Profile profile){

    return ProfileDTO.builder()//
                      .country(profile.getCountry())
                      .companyName(profile.getName())
                      .ipoDate(profile.getIpo())
                      .logo(profile.getLogo())
                      .marketCap(profile.getMarketCapitalization())
                      .currency(profile.getCurrency())
                      .build();
  }
}
