package com.alcideswenner.dslist.dto;

import com.alcideswenner.dslist.entities.GameList;

public record GameListDto(
        Long id,
        String name) {
    public GameListDto(GameList gameList) {
        this(
                gameList.getId(),
                gameList.getName());
    }
}
