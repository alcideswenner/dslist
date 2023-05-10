package com.alcideswenner.dslist.dto;

import com.alcideswenner.dslist.entities.Game;
import com.alcideswenner.dslist.projections.GameMinProjection;

public record GameMinDto(
        Long id,
        String title,
        Integer year,
        String imgUrl,
        String shortDescription) {

    public GameMinDto(Game game) {
        this(
                game.getId(),
                game.getTitle(),
                game.getYear(),
                game.getImgUrl(),
                game.getShortDescription());
    }

    public GameMinDto(GameMinProjection projection) {
        this(
                projection.getId(),
                projection.getTitle(),
                projection.getYear(),
                projection.getImgUrl(),
                projection.getShortDescription());
    }
}
