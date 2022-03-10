package com.devsuperior.dsmovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmovie.entity.Score;
import com.devsuperior.dsmovie.entity.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {

}
