package com.alcideswenner.dslist;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.alcideswenner.dslist.dto.GameDto;
import com.alcideswenner.dslist.repositories.GameRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

    public Optional<List<GameDto>> findAllGames() {
        return Optional
                .ofNullable(this.gameRepository.findAll().stream().map(GameDto::new).toList());
    }
}
