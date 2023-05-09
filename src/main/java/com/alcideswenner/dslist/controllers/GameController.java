package com.alcideswenner.dslist.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.alcideswenner.dslist.GameService;
import com.alcideswenner.dslist.annotations.LogExecution;
import com.alcideswenner.dslist.dto.GameDto;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/games")
@RequiredArgsConstructor
@LogExecution
public class GameController {

    private final GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameDto>> findAllGames(@RequestParam String teste) {
        Optional<List<GameDto>> optGames = gameService.findAllGames();
        return optGames
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }
}
