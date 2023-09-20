package com.example.exercise_usstock.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.example.exercise_usstock.exception.FinnException;
import com.example.exercise_usstock.framework.enums.Code;
import com.example.exercise_usstock.framework.enums.Protocol;
import com.example.exercise_usstock.model.Quote;
import com.example.exercise_usstock.service.QuoteService;


@Service
public class QuoteServiceImpl implements QuoteService {
  @Autowired
  private RestTemplate restTemplate; 


  @Value (value = "${api.finnhub.domain}") // get from ylm when starting server
  private String finnDomain; 

  @Value (value = "${api.finnhub.endpoints.quote}")
  private String quoteEndpoint; 

  @Value (value = "${api.finnhub.apiToken}")
  private String apiToken; 
// https://finnhub.io/api/v1/quote?symbol=AAPL&token=ck4fkn9r01qus81pv42gck4fkn9r01qus81pv430

// https://finnhub.io/api/v1/stock/profile2?symbol=AAPL&token=ck4fkn9r01qus81pv42gck4fkn9r01qus81pv430
  @Override
  public Quote findQuote(String symbol) throws FinnException{
    String url = UriComponentsBuilder.newInstance()
                  .scheme(Protocol.HTTPS.name())
                  .host(finnDomain)
                  .path(quoteEndpoint)
                  .queryParam("symbol",symbol)
                  .queryParam("token",apiToken)
                  .toUriString();
    try{
      Quote quote = restTemplate.getForObject(url, Quote.class);
      return quote;
      // return null;
     }catch(RestClientException e){
    throw new FinnException(Code.FINN_NOTFOUND);
     }
    // Invoke API + Deserialization (Json -> Object)
  }


}
