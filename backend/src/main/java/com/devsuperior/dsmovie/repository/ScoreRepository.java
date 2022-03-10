package com.devsuperior.dsmovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsmovie.entity.Score;
import com.devsuperior.dsmovie.entity.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {

	//@Modifying
	//@Query(value = "INSERT INTO tb_score(movie_id, user_id, value) VALUES(:movieId,:userId,:score)", nativeQuery = true)
	//void saveByScore(Long movieId, Long userId, Double score);
}
