package com.github.oobila.bukkit.heads.model;

import com.github.oobila.bukkit.common.utils.model.BlockColor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum HeadCollection {

    BLACK_FONT(BlockColor.BLACK),
    WHITE_FONT(BlockColor.WHITE),
    GRAY_FONT(BlockColor.GRAY),
    YELLOW_FONT(BlockColor.YELLOW),
    LIGHT_BLUE_FONT(BlockColor.LIGHT_BLUE),
    LIME_FONT(BlockColor.LIME);

    private final BlockColor blockColor;

}
