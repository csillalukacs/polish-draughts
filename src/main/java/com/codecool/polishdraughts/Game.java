package com.codecool.polishdraughts;

import java.util.Scanner;

public class Game {
    private Board board;

    public Game(int n){
        board = new Board(n);
    }

    public void play(){
        System.out.println("playing...");
        board.printBoard();
        Scanner sc = new Scanner(System.in);

        System.out.println("Which pawn do you want to move?");
        String pawn = sc.nextLine();

        int col = pawn.toCharArray()[0] - 'a';
        int row = Integer.parseInt(pawn.substring(1)) - 1;

        Pawn pawnToMove = this.board.getFields()[row][col];
        System.out.println(pawnToMove);
        System.out.println(pawnToMove.getColor());


        System.out.println("Where do you want to move?");
        String move = sc.nextLine();

        int moveCol = move.toCharArray()[0] - 'a';
        int moveRow = Integer.parseInt(move.substring(1)) - 1;

        pawnToMove.validateMove(new Coordinates(moveCol, moveRow));




    }
}
