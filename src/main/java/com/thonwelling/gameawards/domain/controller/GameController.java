package com.thonwelling.gameawards.domain.controller;

import com.thonwelling.gameawards.domain.model.Game;
import com.thonwelling.gameawards.domain.repositories.GameRepository;
import com.thonwelling.gameawards.domain.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/game")
public class GameController {

  @Autowired
  GameService service;
  @Autowired
  GameRepository repository;

  @PostMapping
  public Game createGame(@RequestBody Game game) {
    return service.addGame(game);
  }

  @GetMapping
  public ResponseEntity<List<Game>> getAllGames() {
    return ResponseEntity.ok(service.findAllGames());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Game> getGameById(@PathVariable Long id){
    return ResponseEntity.ok(service.findGameById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Game> updateGame(@PathVariable Long id, @RequestBody Game game) {
    service.updateGame(id, game);
    return ResponseEntity.ok(game);
  }
  @DeleteMapping("/{id}")
  public ResponseEntity<Game> updateGame(@PathVariable Long id) {
    service.deleteGame(id);
    return ResponseEntity.ok().build();
  }
}
