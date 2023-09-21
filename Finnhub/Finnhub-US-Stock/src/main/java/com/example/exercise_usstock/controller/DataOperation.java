package com.example.exercise_usstock.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.example.exercise_usstock.enity.ProfileE;

public interface DataOperation {
  
  @GetMapping(value = "/data/stocks")
  @ResponseStatus(value = HttpStatus.OK)
  List<ProfileE> findAll ();

  @PostMapping(value = "/data/stocks")
  @ResponseStatus(value = HttpStatus.OK)
  ProfileE save(@RequestBody ProfileE stock );

  @DeleteMapping(value = "/data/stocks/{id}")
  @ResponseStatus(value = HttpStatus.OK)
  void deleteById (@PathVariable String id);


  @PutMapping (value = "/data/stocks/{id}")
  @ResponseStatus(value = HttpStatus.OK)
  void updateById(@PathVariable String id, @RequestBody ProfileE stocks);
}
