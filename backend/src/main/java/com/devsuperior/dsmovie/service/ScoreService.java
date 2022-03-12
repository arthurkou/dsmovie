package com.devsuperior.dsmovie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsmovie.dto.MovieDto;
import com.devsuperior.dsmovie.dto.ScoreDto;
import com.devsuperior.dsmovie.entity.Movie;
import com.devsuperior.dsmovie.entity.Score;
import com.devsuperior.dsmovie.entity.User;
import com.devsuperior.dsmovie.repository.MovieRepository;
import com.devsuperior.dsmovie.repository.ScoreRepository;
import com.devsuperior.dsmovie.repository.UserRepository;

@Service
public class ScoreService {
	
	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ScoreRepository scoreRepository;

	//private double sum = 0.0;
	
	@Transactional
	public MovieDto saveScore(ScoreDto scoreDto) {

		User user = userRepository.findByEmail(scoreDto.getEmail());
		if (user == null) {
			
			user = new User();
			user.setEmail(scoreDto.getEmail());
			userRepository.saveAndFlush(user);						
		} 
		
		Movie movie = movieRepository.findById(scoreDto.getMovieId()).get();
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(scoreDto.getScore());
		
		scoreRepository.saveAndFlush(score);
		
		double sum = 0.0;
		for (Score s : movie.getScores()) {
			sum += s.getValue();
		}		
		
		double avg = sum / movie.getScores().size();
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		movie = movieRepository.save(movie);
		
		return new MovieDto(movie);		
	}
}
