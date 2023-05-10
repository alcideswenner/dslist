package com.alcideswenner.dslist.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.alcideswenner.dslist.GameService;
import com.alcideswenner.dslist.annotations.LogExecution;
import com.alcideswenner.dslist.dto.*;
import lombok.*;

@RestController
@RequestMapping(value = "/games")
@RequiredArgsConstructor
@LogExecution
public class GameController {

    private final GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameMinDto>> findAllGames() {
        Optional<List<GameMinDto>> optGames = gameService.findAllGames();
        return optGames
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameDto> findByIdGame(@NonNull @PathVariable Long id) {
        Optional<GameDto> optGame = gameService.findByIdGame(id);
        return optGame
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }
}
