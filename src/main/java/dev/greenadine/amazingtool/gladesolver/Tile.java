package dev.greenadine.amazingtool.gladesolver;

/**
 * Represents a tile on a {@link Glade} board.
 *
 * @author Kevin Zuman
 */
public class Tile {

    private TileType type;
    private int value;

    public Tile(final TileType type, final int value) {
        this.type = type;
        this.value = value;
    }

    /**
     * Gets the {@link TileType}.
     *
     * @return The {@code Tile}'s {@code TileType}.
     */
    public TileType getType() {
        return type;
    }

    /**
     * Gets the value of the {@code Tile}.
     *
     * @return The {@code Tile}'s value.
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets this {@code Tile}.
     *
     * @param type the {@link TileType}.
     * @param value the value.
     */
    public void set(final TileType type, final int value) {
        this.type = type;
        this.value = value;
    }
}
