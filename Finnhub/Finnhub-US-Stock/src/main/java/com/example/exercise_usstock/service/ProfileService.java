package com.example.exercise_usstock.service;

import java.util.List;
import com.example.exercise_usstock.enity.ProfileE;
import com.example.exercise_usstock.exception.FinnException;
import com.example.exercise_usstock.model.Profile;
import com.example.exercise_usstock.model.Quote;

public interface ProfileService {
  List<ProfileE> findAll();

  Profile findProfile(String symbol)throws FinnException;

  ProfileE save(ProfileE stock);

  void deleteById (Long id);
  
  void update(Long id, ProfileE stock);
  // throw exception

}
