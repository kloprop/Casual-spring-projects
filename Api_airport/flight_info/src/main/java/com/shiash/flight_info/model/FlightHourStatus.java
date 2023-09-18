package com.shiash.flight_info.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
public class FlightHourStatus{
  private String time;
  private List<Flight> flight;  
  private String baggage;

  
}
