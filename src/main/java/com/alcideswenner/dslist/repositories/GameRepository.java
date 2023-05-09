package com.alcideswenner.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.alcideswenner.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
