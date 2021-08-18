package com.codecool.polishdraughts;

public class Pawn {
    private int color;

    public Coordinates getPosition() {
        return position;
    }

    private Coordinates position;
    private Pawn[][] fields;

    public void setPosition(Coordinates position) {
        this.position = position;
    }

    public Pawn(int x, int y, int color, Pawn[][] fields) {
        this.position = new Coordinates(x, y);
        this.color = color;
        this.fields = fields;
    }

    public boolean validateMove(Coordinates move) {
        int pawnX = this.position.getX();
        int pawnY = this.position.getY();

        int moveX = move.getX();
        int moveY = move.getY();

        int playerColor = this.color;
        int opponentColor = (playerColor == 1) ? 0 : 1;
        int diff = (playerColor == 1) ? -1 : +1;

        // Check single step moves
        if ((moveY == pawnY + diff) && ((moveX == pawnX + 1) || (moveX == pawnX - 1))) {
            return (this.fields[moveY][moveX] == null);
        }
        // Check multiple step moves
        // Top left
        if ((moveY == pawnY - 2) && (moveX == pawnX - 2)) {
            return ((this.fields[pawnY - 1][pawnX - 1].getColor() == opponentColor) &&
                    (this.fields[pawnY - 2][pawnX - 2] == null));
        }
        // Top right
        if ((moveY == pawnY - 2) && (moveX == pawnX + 2)) {
            return ((this.fields[pawnY - 1][pawnX + 1].getColor() == opponentColor) &&
                    (this.fields[pawnY - 2][pawnX + 2] == null));
        }
        // Bottom left
        if ((moveY == pawnY + 2) && (moveX == pawnX - 2)) {
            return ((this.fields[pawnY + 1][pawnX - 1].getColor() == opponentColor) &&
                    (this.fields[pawnY + 2][pawnX - 2] == null));
        }
        // Bottom right
        if ((moveY == pawnY + 2) && (moveX == pawnX + 2)) {
            return ((this.fields[pawnY + 1][pawnX + 1].getColor() == opponentColor) &&
                    (this.fields[pawnY + 2][pawnX + 2] == null));
        }
        return false;
    }


    public int getColor() {
        return this.color;
    }
}
