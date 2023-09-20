package com.shiash.flight_info.controller.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shiash.flight_info.controller.PassengerArrialOperation;
import com.shiash.flight_info.model.Response;
import com.shiash.flight_info.service.PassengerArrialService;

@RestController
@RequestMapping(value = "/api/v1")
public class PassengerArrialController implements PassengerArrialOperation {
 
  @Autowired
  PassengerArrialService passengerArrialService;

  @Override
  public List<Response> getFlightInfos (String date, String fliNum){
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-dd");
    //convert String to LocalDate
    LocalDate localDate = LocalDate.now();
    try{localDate = LocalDate.parse(date, formatter);}
    catch(Exception e){
      return null;
    }
    List<Response> responses = passengerArrialService.getFlightInfos(localDate);
    
    return passengerArrialService.getFlightInfos(localDate);
  }
}
