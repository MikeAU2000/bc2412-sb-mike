package com.ex2.demo_sbxercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ex2.demo_sbxercise.entity.PostEntity;

@Repository
public interface PostRespository extends JpaRepository<PostEntity,Long>{
  
}
