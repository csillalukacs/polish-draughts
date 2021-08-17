package com.codecool.polishdraughts;

public class Game {
    private Board board;

    public Game(int n){
        board = new Board(n);
    }

    public void play(){
        System.out.println("playing...");

        board.printBoard();
    }
}
