package com.example.exercise_usstock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.example.exercise_usstock.enums.Code;
import com.example.exercise_usstock.enums.Protocol;
import com.example.exercise_usstock.exception.FinnException;
import com.example.exercise_usstock.model.Profile;
import com.example.exercise_usstock.model.Quote;
import com.example.exercise_usstock.service.ProfileService;
@Service
public class ProfileServiceImpl implements ProfileService{
  @Autowired
  private RestTemplate restTemplate; 


  @Value (value = "${api.finnhub.domain}") // get from ylm when starting server
  private String finnDomain; 

  @Value (value = "${api.finnhub.endpoints.profile}")
  private String profileEndpoint; 

  @Value (value = "${api.finnhub.apiToken}")
  private String apiToken; 
  @Override
  public Profile findProfile(String symbol) throws FinnException{
    String url = UriComponentsBuilder.newInstance()
                  .scheme(Protocol.HTTPS.name())
                  .host(finnDomain)
                  .path(profileEndpoint)
                  .queryParam("symbol",symbol)
                  .queryParam("token",apiToken)
                  .toUriString();
    try{
      Profile profile = restTemplate.getForObject(url, Profile.class);
      return profile;
      // return null;
     }catch(RestClientException e){
    throw new FinnException(Code.FINN_NOTFOUND);
     }
    // Invoke API + Deserialization (Json -> Object)
  }
}
