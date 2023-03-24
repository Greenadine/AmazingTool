package dev.greenadine.amazingtool.gladesolver;

import dev.greenadine.amazingtool.utils.Colors;

import java.awt.*;
import java.util.stream.IntStream;

public enum TileType {

    NORMAL(Colors.GLADE_TILE_NORMAL, 'C',0, 1, 2, 3, 4, 5, 6, 7, 8),
    BOMB(Colors.GLADE_TILE_BOMB, 'B',0, 1, 2, 3, 4, 5, 6, 7, 8),
    BONUS(Colors.GLADE_TILE_BONUS, 'E',1, 2, 3, 4, 5, 6, 7, 8, 9),
    OBSTACLE(Colors.GLADE_TILE_OBSTACLE, 'O',0, 1, 2, 3),
    TURN(Colors.GLADE_TILE_TURN, 'R',0, 1, 2, 3),
    START(Colors.GLADE_TILE_START, 'S',0, 1, 2, 3),
    GOAL(Colors.GLADE_TILE_GOAL, 'D',1, 2, 3, 4, 5, 6, 7, 8, 9);

    final Color color;
    final char character;
    final int[] values;

    TileType(final Color color, final char character, int... values) {
        this.color = color;
        this.character = character;
        this.values = values;
    }

    public Color getColor() {
        return color;
    }

    public char getCharacter() {
        return character;
    }

    public int getDefaultValue() {
        return values[0];
    }

    public int getNextValue(final int currentValue) {
        if (IntStream.of(values).anyMatch(value -> value == currentValue + 1)) {
            return currentValue + 1;
        } else {
            return getDefaultValue();
        }
    }

    public static TileType getNext(final TileType other) {
        int currentIndex = 0;

        for (int i = 0; i < values().length; i++) {
            final TileType type = values()[i];

            if (type == other) {
                currentIndex = i;
            }
        }

        if (currentIndex == values().length - 1) {
            return values()[0];
        } else {
            return values()[currentIndex + 1];
        }
    }
}
