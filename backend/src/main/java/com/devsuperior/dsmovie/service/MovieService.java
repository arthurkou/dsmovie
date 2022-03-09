package com.devsuperior.dsmovie.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsmovie.dto.MovieDto;
import com.devsuperior.dsmovie.entity.Movie;
import com.devsuperior.dsmovie.repository.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Transactional(readOnly = true)
	public Page<MovieDto> findAll(Pageable pageable) {
		
		Page<Movie> result = movieRepository.findAll(pageable);
		return result.map(x -> new MovieDto(x));
	}

	@Transactional(readOnly = true)
	public MovieDto findAll(Long id) {
		
		//validar se id existe
		Optional<Movie> result = movieRepository.findById(id);
		return result.map(x -> new MovieDto(x)).get();
	}
}
