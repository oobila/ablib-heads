package com.github.oobila.bukkit.heads.model;

import lombok.Builder;
import lombok.Getter;
import org.bukkit.inventory.ItemStack;

import java.util.List;

import static com.github.oobila.bukkit.itemstack.ItemStackProxy.skull;

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

    public ItemStack toItemStack() {
        return skull(texture).getItemStack();
    }

    public static class HeadBuilder {
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
