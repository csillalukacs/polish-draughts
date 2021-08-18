package com.codecool.polishdraughts;

import java.util.Scanner;
import java.util.Arrays;


public class Game {
    private Board board;

    public Game(int n){
        board = new Board(n);
    }

    public void clearScreen () {
        System.out.print("\033[H\033[2J");
        System.out.flush();
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
        String pawnString = "";

        while (invalidInput(pawnString, board.getSize())
                || (board.getField(toCoordinate(pawnString)) == null)
                || player != board.getField(toCoordinate(pawnString)).getColor()) {
            String location = (player == 1) ? " (bottom)" : " (top)";
            pawnString = getInput("Which pawn do you want to move, player " + player + location + "?");
        }

        Pawn pawn = this.board.getField(toCoordinate(pawnString));
        int moveCount = pawn.getPossibleMoves().size();
        if (moveCount < 1) return getPawn(player);
        return pawn;
    }

    public Coordinates getNewPosition(Pawn pawnToMove) {
        String position = "";

        while (invalidInput(position, board.getSize()) || !pawnToMove.validateMove(toCoordinate(position))) {
            position = getInput("Where do you want to move?");
        }

        return toCoordinate(position);
    }

    public boolean pawnsLeft (int color) {
        for (Pawn[] row : this.board.getFields()) {
            for (Pawn pawn : row) {
                if ((pawn != null) && (pawn.getColor() == color)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean movesLeft (int color) {
        for (Pawn[] row : this.board.getFields()) {
            for (Pawn pawn : row) {
                if ((pawn != null) && (pawn.getColor() == color)) {
                    int moveCount = pawn.getPossibleMoves().size();
                    if (moveCount > 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int checkForWinner(int player) {
        int winner = -1;
        int opponent = (player == 1) ? 0 : 1;
        if (!pawnsLeft(opponent) || !movesLeft(opponent)) {
            winner = player;
        }
        return winner;
    }

    public void printWinner(int winner) {
        switch (winner) {
            case 0:
                System.out.println("Player 0 (top) wins!");
                break;
            case 1:
                System.out.println("Player 1 (bottom) wins!");
                break;
            default:
                System.out.println("No winner!");
        }
    }

    public void start(){
        clearScreen();
        System.out.println(board);
        int winner = -1;
        int player = 1;
        while (winner == -1) {
            playRound(player);
            winner = checkForWinner(player);
            player = (player == 1) ? 0 : 1;
        }
        printWinner(winner);
    }

    private void playRound(int player) {
        Pawn pawnToMove = this.getPawn(player);
        Coordinates newPosition = getNewPosition(pawnToMove);

        board.movePawn(pawnToMove, newPosition);
        clearScreen();
        System.out.println(board);
    }
}
