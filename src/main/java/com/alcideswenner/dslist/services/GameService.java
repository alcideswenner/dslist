package com.alcideswenner.dslist.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.alcideswenner.dslist.dto.*;
import com.alcideswenner.dslist.repositories.GameRepository;
import lombok.*;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

    @Transactional(readOnly = true)
    public Optional<List<GameMinDto>> findAllGames() {
        return Optional
                .ofNullable(this.gameRepository.findAll().stream().map(GameMinDto::new).toList());
    }

    @Transactional(readOnly = true)
    public Optional<GameDto> findByIdGame(Long id) {
        return Optional
                .ofNullable(this.gameRepository.findById(id)
                        .map(GameDto::new)
                        .orElseGet(() -> null));
    }

    @Transactional(readOnly = true)
    public Optional<List<GameMinDto>> findByList(Long idList) {
        return Optional
                .ofNullable(this.gameRepository.searchList(idList).stream().map(GameMinDto::new).toList());
    }

}
