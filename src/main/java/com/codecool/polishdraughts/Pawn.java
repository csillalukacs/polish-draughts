package com.codecool.polishdraughts;

public class Pawn {
    private int color;
    private Coordinates position;

    public Pawn(int x, int y, int color){
        this.position = new Coordinates(x,y);
        this.color = color;
    }

    public int getColor() {
        return this.color;
    }
}
