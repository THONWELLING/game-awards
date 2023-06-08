package com.thonwelling.gameawards.domain.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "GAMES")
public class Game {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  @Column(columnDefinition = "TEXT")
  private String description;
  private String cover;
  private long votes;

  public Game() {}

  public Game(Long id, String name, String description, String cover, long votes) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.cover = cover;
    this.votes = votes;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getCover() {
    return cover;
  }

  public void setCover(String cover) {
    this.cover = cover;
  }

  public long getVotes() {
    return votes;
  }

  public void setVotes(long votes) {
    this.votes = votes;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Game game)) return false;
    return getVotes() == game.getVotes() && Objects.equals(getId(), game.getId()) && Objects.equals(getName(), game.getName()) && Objects.equals(getDescription(), game.getDescription()) && Objects.equals(getCover(), game.getCover());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getName(), getDescription(), getCover(), getVotes());
  }
}
