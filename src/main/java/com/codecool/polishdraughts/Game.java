package com.codecool.polishdraughts;

import java.util.Scanner;
import java.util.Arrays;

public class Game {
    private Board board;

    public Game(int n){
        board = new Board(n);
    }

    public boolean stringIsNumeric (String possibleNumber) {
        return possibleNumber.chars().allMatch( Character::isDigit );
    }

    public boolean validateInput(String input, int boardSize){
        if (input.length() < 2){
            return false;
        } else {
            char[] inputChars = input.toCharArray();
            char firstLetter = inputChars[0];
            String coordinateNumber = new String(Arrays.copyOfRange(inputChars, 1, inputChars.length));
            System.out.println(coordinateNumber);
            System.out.println(stringIsNumeric(coordinateNumber));

            if (!(Character.isLetter(firstLetter)) ||
                    !(stringIsNumeric(coordinateNumber))) {
                return false;
            }
            int firstCoordinate = firstLetter - 'a';
            int secondCoordinate = Integer.parseInt(coordinateNumber) - 1;
            if ((firstCoordinate > boardSize) ||
                    (secondCoordinate > boardSize) ||
                    (firstCoordinate < 0) ||
                    (secondCoordinate < 0)) {
                return false;
            }
        }
        return true;
    }

    public static Coordinates toCoordinate(String input){
        int col = input.toCharArray()[0] - 'a';
        int row = Integer.parseInt(input.substring(1)) - 1;
        return new Coordinates(col, row);
    }

    public Pawn getPawn(int player) {
        Scanner sc = new Scanner(System.in);
        String pawn = "";

        while (!validateInput(pawn, board.getSize())
                || (board.getField(toCoordinate(pawn)) == null)
                || player != board.getField(toCoordinate(pawn)).getColor()) {
            System.out.println("Which pawn do you want to move?");
            pawn = sc.nextLine();
        }

        Pawn pawnToMove = this.board.getField(toCoordinate(pawn));
        return pawnToMove;
    }

    public Coordinates getNewPosition(Pawn pawnToMove) {
        Scanner sc = new Scanner(System.in);
        String input = "";

        while (!validateInput(input, board.getSize()) || !pawnToMove.validateMove(toCoordinate(input))) {
            System.out.println("Where do you want to move?");
            input = sc.nextLine();
        }

        return toCoordinate(input);
    }


    public void start(){
        System.out.println("playing...");
        System.out.println(board);

        int player = 1;
        while (true) {
            player = playRound(player);
        }

    }

    private int playRound(int player) {
        Pawn pawnToMove = this.getPawn(player);
        Coordinates newPosition = getNewPosition(pawnToMove);

        board.movePawn(pawnToMove, newPosition);
        System.out.println(board);

        player = (player == 1) ? 0 : 1;
        return player;
    }
}
