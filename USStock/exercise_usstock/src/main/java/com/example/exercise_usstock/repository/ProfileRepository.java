package com.example.exercise_usstock.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.exercise_usstock.enity.ProfileE;
import com.example.exercise_usstock.model.Stock;

@Repository
public interface ProfileRepository extends JpaRepository<ProfileE, Long>{
  // default method from stocksRespository, save, findByID, findAll
  List<ProfileE> findByCompanyName(String companyName);
}
