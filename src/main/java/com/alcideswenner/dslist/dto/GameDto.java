package com.alcideswenner.dslist.dto;

import com.alcideswenner.dslist.entities.Game;

public record GameDto(
        Long id,
        String title,
        Integer year,
        String imgUrl,
        String shortDescription) {
    public GameDto(Game game) {
        this(
                game.getId(),
                game.getTitle(),
                game.getYear(),
                game.getImgUrl(),
                game.getShortDescription());
    }
}
