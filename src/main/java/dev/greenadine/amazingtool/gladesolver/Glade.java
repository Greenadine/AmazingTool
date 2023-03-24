package dev.greenadine.amazingtool.gladesolver;

public class Glade {

    private final Tile[][] tiles;

    public Glade() {
        this.tiles = new Tile[20][20];
    }

    public void setTile(final int row, final int col, final TileType type, final int value) {
        tiles[row][col].set(type, value);
    }
}
