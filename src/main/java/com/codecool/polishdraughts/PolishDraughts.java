package com.codecool.polishdraughts;


public class PolishDraughts {

    public static int getBoardSize() {
        int size = 0;
        while (!((size >= 10) && (size <= 20) && (size % 2 == 0))) {
            String sizeString = Game.getInput("Enter board size:");
            try {
                size = Integer.parseInt(sizeString);
            } catch (NumberFormatException e) {
                return getBoardSize();
            }
        }
        return size;
    }

    public static void main(String[] args) {
        int boardSize = getBoardSize();
        Game game = new Game(boardSize);
        game.start();
    }
}
