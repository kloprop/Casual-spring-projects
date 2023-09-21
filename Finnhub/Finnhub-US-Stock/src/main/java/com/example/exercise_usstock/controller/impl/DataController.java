package com.example.exercise_usstock.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.exercise_usstock.controller.DataOperation;
import com.example.exercise_usstock.enity.ProfileE;
import com.example.exercise_usstock.model.Profile;
import com.example.exercise_usstock.service.ProfileService;

@RestController
@RequestMapping(value = "/api/v1")
public class DataController implements DataOperation {

  @Autowired
  private ProfileService profileService;

  @Override
  public List<ProfileE> findAll() {
    return profileService.findAll();
  }

  @Override
  public ProfileE save(ProfileE stock) {
    return profileService.save(stock);
  }

  @Override
  public void deleteById(String id) {
    profileService.deleteById(vaildateId(id));
  }

  @Override
  public void updateById(String id, ProfileE stock) {
    profileService.update(vaildateId(id), stock);
  }

  private Long vaildateId(String id) {
    try {
      return Long.valueOf(id);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("Only integer is allowed");
    }
  }
}
