package com.ex2.demo_sbxercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ex2.demo_sbxercise.entity.GeoEntity;
import java.util.List;

@Repository
public interface GeoRepository extends JpaRepository<GeoEntity, Long> {
    List<GeoEntity> findByLatAndLng(String lat, String lng);
}
