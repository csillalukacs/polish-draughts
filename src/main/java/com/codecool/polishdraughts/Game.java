package com.codecool.polishdraughts;

import java.util.Locale;
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

    public static String getInput (String message) {
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        return sc.nextLine();
    }

    public boolean invalidInput(String input, int boardSize){
        if (input.length() < 2){
            return true;
        } else {
            char[] inputChars = input.toLowerCase().toCharArray();
            char coordinateLetter = inputChars[0];
            String coordinateNumber = new String(Arrays.copyOfRange(inputChars, 1, inputChars.length));
            if (!(Character.isLetter(coordinateLetter)) ||
                    !(stringIsNumeric(coordinateNumber))) {
                return true;
            }
            int firstCoordinate = coordinateLetter - 'a';
            int secondCoordinate = Integer.parseInt(coordinateNumber) - 1;
            return (firstCoordinate >= boardSize) ||
                    (secondCoordinate >= boardSize) ||
                    (firstCoordinate < 0) ||
                    (secondCoordinate < 0);
        }
    }

    public static Coordinates toCoordinate(String input){
        int col = input.toCharArray()[0] - 'a';
        int row = Integer.parseInt(input.substring(1)) - 1;
        return new Coordinates(col, row);
    }

    public Pawn getPawn(int player) {
        String pawn = "";

        while (invalidInput(pawn, board.getSize())
                || (board.getField(toCoordinate(pawn)) == null)
                || player != board.getField(toCoordinate(pawn)).getColor()
                || !board.getField(toCoordinate(pawn)).canMove()) {
            pawn = getInput("Which pawn do you want to move, player " + player + "?");
        }

        return this.board.getField(toCoordinate(pawn));
    }

    public Coordinates getNewPosition(Pawn pawnToMove, int player) {
        String position = "";

        while (invalidInput(position, board.getSize()) || !pawnToMove.validateMove(toCoordinate(position))) {
            position = getInput("Where do you want to move?");
        }

        return toCoordinate(position);
    }


    public void start(){
        System.out.println(board);

        int player = 1;
        while (true) {
            player = playRound(player);
        }

    }

    private int playRound(int player) {
        Pawn pawnToMove = this.getPawn(player);
        Coordinates newPosition = getNewPosition(pawnToMove, player);

        board.movePawn(pawnToMove, newPosition);
        System.out.println(board);

        player = (player == 1) ? 0 : 1;
        return player;
    }
}
