package com.github.oobila.bukkit.heads.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class Head {

    private final String name;
    private final String texture;
    private final List<String> tags;
    private final boolean isChar;
    private final char c;
    private final Symbol s;
    private final HeadCollection collection;

    public class HeadBuilder {
        private boolean isChar = false;
        private char c = 0;

        private HeadBuilder isChar(){
            return this;
        }

        public HeadBuilder c(char c) {
            this.c = c;
            this.isChar = true;
            return this;
        }
    }

}
