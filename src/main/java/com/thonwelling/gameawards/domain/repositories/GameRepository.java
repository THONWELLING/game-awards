package com.thonwelling.gameawards.domain.repositories;

import com.thonwelling.gameawards.domain.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GameRepository extends JpaRepository<Game,Long> {

}
