package com.codecool.polishdraughts;

public class Pawn {
    private int color;
    private Coordinates position;
    private Pawn[][] fields;

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

        if (this.color == 1) {
            System.out.println("x=" + moveX);
            System.out.println("y=" + moveY);
            System.out.println("pawn x=" + pawnX);
            System.out.println("pawn y=" + pawnY);

            if (moveY == pawnY - 1 && (moveX == pawnX + 1 || moveX == pawnX - 1)) {
                return (this.fields[moveY][moveX] == null);
            }
            if ((moveY == pawnY - 1 ) && (moveX == pawnX + 1)) {
                return (this.fields[moveY][moveX].getColor() == 0 && this.fields[moveY-1][moveX+1] == null);
            }
            if ((moveY == pawnY - 1 ) && (moveX == pawnX - 1)) {
                return (this.fields[moveY][moveX].getColor() == 0 && this.fields[moveY-1][moveX-1] == null);
            }
            if ((moveY == pawnY + 1 ) && (moveX == pawnX + 1)) {
                return (this.fields[moveY][moveX].getColor() == 0 && this.fields[moveY+1][moveX+1] == null);
            }
            if ((moveY == pawnY + 1 ) && (moveX == pawnX - 1)) {
                return (this.fields[moveY][moveX].getColor() == 0 && this.fields[moveY+1][moveX-1] == null);
            }
        }
        return false;
    }


    public int getColor() {
        return this.color;
    }
}
