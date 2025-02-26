package com.ex2.demo_sbxercise.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ex2.demo_sbxercise.entity.CompanyEntity;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Long>{
  List<CompanyEntity> findByNameAndCatchPhraseAndBs(String name, String catchPhrase, String bs);
}