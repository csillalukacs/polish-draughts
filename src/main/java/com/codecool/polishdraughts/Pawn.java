package com.codecool.polishdraughts;

import java.util.ArrayList;

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

    public ArrayList<Coordinates> getPossibleMoves() {
        int pawnX = this.position.getX();
        int pawnY = this.position.getY();
        int startX = pawnX - 2;
        int startY = pawnY - 2;
        ArrayList<Coordinates> possibleMoves = new ArrayList<>();
        for (int x = startX; x < startX + 5; x++) {
            for (int y = startY; y < startY + 5; y++) {
                Coordinates move = new Coordinates(x, y);
                try {
                    if (validateMove(move)) {
                        possibleMoves.add(move);
                    }
                } catch (Exception ignored) {}
            }
        }
        return possibleMoves;
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
            return ((this.fields[pawnY - 1][pawnX - 1] != null) &&
                    (this.fields[pawnY - 1][pawnX - 1].getColor() == opponentColor) &&
                    (this.fields[pawnY - 2][pawnX - 2] == null));
        }
        // Top right
        if ((moveY == pawnY - 2) && (moveX == pawnX + 2)) {
            return ((this.fields[pawnY - 1][pawnX + 1] != null) &&
                    (this.fields[pawnY - 1][pawnX + 1].getColor() == opponentColor) &&
                    (this.fields[pawnY - 2][pawnX + 2] == null));
        }
        // Bottom left
        if ((moveY == pawnY + 2) && (moveX == pawnX - 2)) {
            return ((this.fields[pawnY + 1][pawnX - 1] != null) &&
                    (this.fields[pawnY + 1][pawnX - 1].getColor() == opponentColor) &&
                    (this.fields[pawnY + 2][pawnX - 2] == null));
        }
        // Bottom right
        if ((moveY == pawnY + 2) && (moveX == pawnX + 2)) {
            return ((this.fields[pawnY + 1][pawnX + 1] != null) &&
                    (this.fields[pawnY + 1][pawnX + 1].getColor() == opponentColor) &&
                    (this.fields[pawnY + 2][pawnX + 2] == null));
        }
        return false;
    }

    public boolean canMove(){
        Coordinates[] directions = {position.topLeft(fields.length),
                position.topRight(fields.length),
                position.bottomLeft(fields.length),
                position.bottomRight(fields.length),
                position.captureTopLeft(fields.length),
                position.captureTopRight(fields.length),
                position.captureBottomLeft(fields.length),
                position.captureBottomRight(fields.length),
        };
        for (Coordinates direction : directions ){
            if (direction != null && validateMove(direction)){
                return true;
            }
        }
        return false;
    }


    public int getColor() {
        return this.color;
    }
}
