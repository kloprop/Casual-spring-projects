package com.shiash.flight_info.model;

import java.io.Serializable;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Flight {
  private String no;
  private String airline;

  
}
