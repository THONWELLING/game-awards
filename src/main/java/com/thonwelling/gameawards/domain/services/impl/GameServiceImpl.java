package com.thonwelling.gameawards.domain.services.impl;

import com.thonwelling.gameawards.domain.model.Game;
import com.thonwelling.gameawards.domain.repositories.GameRepository;
import com.thonwelling.gameawards.domain.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class GameServiceImpl implements GameService {

  @Autowired
  private GameRepository gameRepository;

  @Override
  public List<Game> findAllGames() {
    return gameRepository.findAll();
  }

  @Override
  public Game findGameById(Long id) {
    Optional<Game> game = gameRepository.findById(id);
    return game.orElseThrow(() -> new RuntimeException("Could Not Find Game"));
  }

  @Override
  public Game addGame(Game game) {
    if (game.getId() != null) {
      throw new RuntimeException("Game already exists");
    }
    return gameRepository.save(game);
  }

  @Override
  public void updateGame(Long id, Game game) {
    Game persistedGame = findGameById(id);
    if (persistedGame.getId().equals(game.getId())) {
      gameRepository.save(game);
    } else {
      throw new RuntimeException("The Ids To Update Are Differents");
    }
  }

  @Override
  public void deleteGame(Long id) {
    Game persistedGame = findGameById(id);
    gameRepository.delete(persistedGame);
  }
}
