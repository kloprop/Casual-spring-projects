package com.shiash.flight_info.service;

import java.time.LocalDate;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import com.shiash.flight_info.model.Response;

public interface PassengerArrialService {

  List<Response> getFlightInfos (LocalDate date);
}
