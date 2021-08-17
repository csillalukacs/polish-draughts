package com.codecool.polishdraughts;

public class Move {
    private Pawn pawn;
    private Coordinates coordinates;
    private Pawn attackedPawn;

    public Move(Pawn pawn, Coordinates coordinates) {
        this.pawn = pawn;
    }


    public Pawn getPawn() {
        return pawn;
    }

    public Pawn getAttackedPawn() {
        return attackedPawn;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }


}
