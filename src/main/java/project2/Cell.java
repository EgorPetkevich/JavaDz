package project2;

public record Cell(int row, int col, Type type) {
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
    public enum Type { WALL, PASSAGE }

}
