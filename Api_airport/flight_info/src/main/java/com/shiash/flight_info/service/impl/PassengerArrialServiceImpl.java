package com.shiash.flight_info.service.impl;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import com.shiash.flight_info.model.Response;
import com.shiash.flight_info.service.PassengerArrialService;



@Service
public class PassengerArrialServiceImpl implements PassengerArrialService{
  
  @Autowired
  private RestTemplate restTemplate;

 
 
  @Value(value = "${api.hongkongairport.domain}")
  private String airportDomain;
  
  @Value(value = "${api.hongkongairport.endpoints.flights}")
  private String listEndpoint;
  
  @Override
  public List <Response>  getFlightInfos(LocalDate date){
    String url =  UriComponentsBuilder.newInstance()
                  .scheme("https")
                  .host(airportDomain)
                  .path(listEndpoint)
                  .queryParam("date", date)
                  .queryParam("lang", "en")
                  .queryParam("cargo", "false")
                  .queryParam("arrival", "true")
                  .toUriString();
                  
    
    Response [] infos = restTemplate.getForObject(url,Response[].class);
    return Arrays.asList(infos);
  }


}
