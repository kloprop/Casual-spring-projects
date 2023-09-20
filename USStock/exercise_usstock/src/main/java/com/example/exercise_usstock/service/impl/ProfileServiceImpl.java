package com.example.exercise_usstock.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.example.exercise_usstock.enity.ProfileE;
import com.example.exercise_usstock.exception.FinnException;
import com.example.exercise_usstock.framework.enums.Code;
import com.example.exercise_usstock.framework.enums.Protocol;
import com.example.exercise_usstock.model.Profile;
import com.example.exercise_usstock.model.Quote;
import com.example.exercise_usstock.repository.ProfileRepository;
import com.example.exercise_usstock.service.ProfileService;
import jakarta.persistence.EntityNotFoundException;
@Service
public class ProfileServiceImpl implements ProfileService{
  @Autowired
  private RestTemplate restTemplate; 
  @Autowired 
  ProfileRepository stocksRepository;

  @Value (value = "${api.finnhub.domain}") // get from ylm when starting server
  private String finnDomain; 

  @Value (value = "${api.finnhub.endpoints.profile}")
  private String profileEndpoint; 
  
  @Value (value = "${api.finnhub.apiToken}")
  private String apiToken; 

  @Override
  public List<ProfileE> findAll(){
    return stocksRepository.findAll();
  }

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
      return restTemplate.getForObject(url, Profile.class);
      // return null;
     }catch(RestClientException e){
    throw new FinnException(Code.FINN_NOTFOUND);
     }
    // Invoke API + Deserialization (Json -> Object)
  }

  @Override // fild name is incorrect
  public ProfileE save(ProfileE stock){
    return stocksRepository.save(stock);
  }

  @Override
  public void deleteById(Long id){
    if (!stocksRepository.existsById(id)){
      throw new EntityNotFoundException("Record with id "+ id + "does not exist");
    }
    stocksRepository.deleteById(id);
  }

  @Override
  public void update(Long id, ProfileE stock){
    if(!stocksRepository.existsById(id)){
     throw new EntityNotFoundException("Record with id "+ id + "does not exist");
    }
    stocksRepository.save(stock);
  }
}
