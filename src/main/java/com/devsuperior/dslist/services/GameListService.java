package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.repositories.GameListRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
	
	@Transactional(readOnly = true) // Não vai bloquear o banco para escrita
	public List<GameListDTO> findAll() {
		// var result = gameRepository.findAll();
		List<GameList> result = gameListRepository.findAll();
		List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
		return dto;
	}
	
	@Transactional(readOnly = true)
	public GameListDTO findById(Long id) {
		GameList gameList = gameListRepository.findById(id).get();
		GameListDTO dto = new GameListDTO(gameList);
		return dto;
	}
	
}
