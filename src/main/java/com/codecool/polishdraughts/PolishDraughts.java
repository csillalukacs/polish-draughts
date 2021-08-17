package com.codecool.polishdraughts;

import java.util.Scanner;

public class PolishDraughts {

    public static int getBoardSize() {
        int size = 0;
        Scanner sc = new Scanner(System.in);
        while (! (size >=10 && size <= 20 && size % 2 == 0)) {
            System.out.println("Enter board size: ");
            String sizeString = sc.nextLine();
            try {
                size = Integer.parseInt(sizeString);
            } catch (NumberFormatException e) {
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
