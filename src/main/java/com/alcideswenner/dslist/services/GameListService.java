package com.alcideswenner.dslist.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.alcideswenner.dslist.dto.*;
import com.alcideswenner.dslist.repositories.GameListRepository;
import lombok.*;

@Service
@RequiredArgsConstructor
public class GameListService {

    private final GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public Optional<List<GameListDto>> findAllGamesList() {
        return Optional
                .ofNullable(this.gameListRepository.findAll().stream().map(GameListDto::new).toList());
    }

    @Transactional(readOnly = true)
    public Optional<GameListDto> findByIdGameList(Long id) {
        return Optional
                .ofNullable(this.gameListRepository.findById(id)
                        .map(GameListDto::new)
                        .orElseGet(() -> null));
    }
}
