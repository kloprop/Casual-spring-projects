package com.shiash.flight_info.config;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;


@Configuration
public class AppConfig {
  
  @Bean
  RestTemplate restTemplate(){
    RestTemplate restTemplate = new RestTemplate();
    // restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
    return restTemplate;
  }
}
