package com.shiash.flight_info.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.shiash.flight_info.model.Response;


public interface PassengerArrialOperation {

    @GetMapping(value = "/flightinfos/{date}/{fliNum}")
    List<Response> getFlightInfos (@PathVariable String date, @PathVariable String fliNum);
}
