package com.example.exercise_usstock.service;

import java.util.List;
import com.example.exercise_usstock.exception.FinnException;
import com.example.exercise_usstock.model.Quote;

public interface QuoteService {
  
  Quote findQuote(String symbol)throws FinnException;
}
