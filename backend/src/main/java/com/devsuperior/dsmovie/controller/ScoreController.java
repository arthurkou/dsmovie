package com.devsuperior.dsmovie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmovie.dto.MovieDto;
import com.devsuperior.dsmovie.dto.ScoreDto;
import com.devsuperior.dsmovie.service.ScoreService;

@RestController
@RequestMapping(value = "/movies")
public class ScoreController {
	
	@Autowired
	private ScoreService scoreService;
	
	@PostMapping(value = "/scores")
	public void saveScore(@RequestBody ScoreDto scoreDto) {		
		scoreService.saveScore(scoreDto);
	}

}
