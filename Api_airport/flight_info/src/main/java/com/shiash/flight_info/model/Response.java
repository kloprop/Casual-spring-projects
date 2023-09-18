package com.shiash.flight_info.model;

import java.time.LocalDate;
import java.util.List;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Response {
  private LocalDate date; 
  
  @JsonProperty("list")
   private List<FlightHourStatus> list;
  
 


}
