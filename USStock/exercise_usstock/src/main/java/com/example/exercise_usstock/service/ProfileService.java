package com.example.exercise_usstock.service;

import com.example.exercise_usstock.exception.FinnException;
import com.example.exercise_usstock.model.Profile;
import com.example.exercise_usstock.model.Quote;

public interface ProfileService {
  Profile findProfile(String symbol)throws FinnException;
}
