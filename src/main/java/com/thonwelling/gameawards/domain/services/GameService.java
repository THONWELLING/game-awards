package com.thonwelling.gameawards.domain.services;

import com.thonwelling.gameawards.domain.model.Game;

import java.util.List;

public interface GameService {
  List<Game> findAllGames();
  Game findGameById(Long id);
  Game addGame(Game game);
  void updateGame(Long id,  Game game);
  void deleteGame(Long id);

  void vote(Long id);
}
