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

        if (this.color == 1) {
            if (moveY == pawnY - 1 && (moveX == pawnX + 1 || moveX == pawnX - 1)) {
                return (this.fields[moveY][moveX] == null);
            }
            if ((moveY == pawnY - 2 ) && (moveX == pawnX + 2)) {
                return (this.fields[pawnY - 1][pawnX + 1].getColor() == 0 && this.fields[pawnY-2][pawnX+2] == null);
            }
            if ((moveY == pawnY - 2 ) && (moveX == pawnX - 2)) {
                return (this.fields[pawnY - 1][pawnX - 1].getColor() == 0 && this.fields[pawnY-2][pawnX-2] == null);
            }
            if ((moveY == pawnY + 2 ) && (moveX == pawnX + 2)) {
                return (this.fields[pawnY + 1][pawnX + 1].getColor() == 0 && this.fields[pawnY+2][pawnX+2] == null);
            }
            if ((moveY == pawnY + 2 ) && (moveX == pawnX - 2)) {
                return (this.fields[pawnY - 1][pawnX - 1].getColor() == 0 && this.fields[pawnY+2][pawnX-2] == null);
            }
        } else if (this.color == 0){
            if (moveY == pawnY + 1 && (moveX == pawnX + 1 || moveX == pawnX - 1)) {
                return (this.fields[moveY][moveX] == null);
            }
            if ((moveY == pawnY - 2 ) && (moveX == pawnX + 2)) {
                return (this.fields[pawnY - 1][pawnX + 1].getColor() == 1 && this.fields[pawnY-2][pawnX+2] == null);
            }
            if ((moveY == pawnY - 2 ) && (moveX == pawnX - 2)) {
                return (this.fields[pawnY - 1][pawnX - 1].getColor() == 1 && this.fields[pawnY-2][pawnX-2] == null);
            }
            if ((moveY == pawnY + 2 ) && (moveX == pawnX + 2)) {
                return (this.fields[pawnY + 1][pawnX + 1].getColor() == 1 && this.fields[pawnY+2][pawnX+2] == null);
            }
            if ((moveY == pawnY + 2 ) && (moveX == pawnX - 2)) {
                return (this.fields[pawnY + 1 ][pawnX - 1 ].getColor() == 1 && this.fields[pawnY+2][pawnX-2] == null);
            }
        }
        return false;
    }


    public int getColor() {
        return this.color;
    }
}
