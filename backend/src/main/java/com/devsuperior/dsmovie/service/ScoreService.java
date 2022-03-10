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

	private double sum = 0.0;
	
	@Transactional
	public void saveScore(ScoreDto scoreDto) {

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
		/*
		//movie.getScores().forEach(x -> sum += x.getValue());
		for (Score s : movie.getScores()) {
			sum = sum + s.getValue();
		}
		System.out.println("soma das notas: " + sum);
		
		System.out.println("count: " + movie.getScores().size());
		double avg = sum / movie.getScores().size();
		System.out.println("média: " + avg);
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		movie = movieRepository.save(movie);
		
		return new MovieDto(movie);		*/
	}
}
