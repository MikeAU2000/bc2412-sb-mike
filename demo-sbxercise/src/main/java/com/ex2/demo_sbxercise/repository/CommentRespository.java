package com.ex2.demo_sbxercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ex2.demo_sbxercise.entity.CommentEntity;
import jakarta.transaction.Transactional;

@Repository
public interface CommentRespository extends JpaRepository<CommentEntity,Long>{
  @Transactional
  void deleteByPostEntity_Id(Long id);

}
