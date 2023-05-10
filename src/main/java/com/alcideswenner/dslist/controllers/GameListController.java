package com.alcideswenner.dslist.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.alcideswenner.dslist.annotations.LogExecution;
import com.alcideswenner.dslist.dto.*;
import com.alcideswenner.dslist.services.GameListService;
import com.alcideswenner.dslist.services.GameService;

import lombok.*;

@RestController
@RequestMapping(value = "/lists")
@RequiredArgsConstructor
@LogExecution
public class GameListController {

    private final GameListService gameListService;

    private final GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameListDto>> findAllGames() {
        Optional<List<GameListDto>> optGames = gameListService.findAllGamesList();
        return optGames
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }

    @GetMapping("/{listId}/games")
    public ResponseEntity<List<GameMinDto>> findByList(@NonNull @PathVariable Long listId) {
        Optional<List<GameMinDto>> optGame = gameService.findByList(listId);
        return optGame
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }
}
