package com.alcideswenner.dslist.dto;

import com.alcideswenner.dslist.entities.Game;

public record GameDto(
        Long id,
        String title,
        Integer year,
        String imgUrl,
        String shortDescription,
        String longDescription,
        Double score,
        String genre) {
    public GameDto(Game game) {
        this(
                game.getId(),
                game.getTitle(),
                game.getYear(),
                game.getImgUrl(),
                game.getShortDescription(),
                game.getLongDescription(),
                game.getScore(),
                game.getGenre());
    }
}
