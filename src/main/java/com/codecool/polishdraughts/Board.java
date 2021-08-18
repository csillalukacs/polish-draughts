package com.codecool.polishdraughts;

public class Board {

    private Pawn[][] fields;
    private int size;

    public int getSize() {
        return size;
    }

    public Board(int n) {
        this.fields = new Pawn[n][n];
        this.size = n;
        for (int rowIndex = 0; rowIndex < n; rowIndex++) {
            for (int colIndex = 0; colIndex < n; colIndex++) {
                if ((rowIndex < 4) || (rowIndex >= n - 4)) {
                    boolean isBlack = (rowIndex >= n - 4);
                    if (((rowIndex % 2 == 0) && ((colIndex % 2 == 1))) ||
                            ((rowIndex % 2 == 1) && ((colIndex % 2 == 0)))) {
                        this.fields[rowIndex][colIndex] = new Pawn(colIndex, rowIndex, isBlack ? 1 : 0, this.fields);
                    }
                }
            }
        }
    }

    public Pawn[][] getFields() {
        return fields;
    }

    public Pawn getField(Coordinates position){
        return fields[position.getY()][position.getX()];
    }

    public void movePawn(Pawn pawn, Coordinates newPosition){
        int oldX = pawn.getPosition().getX();
        int oldY = pawn.getPosition().getY();
        int newX = newPosition.getX();
        int newY = newPosition.getY();

        this.fields[oldY][oldX] = null;
        pawn.setPosition(newPosition);
        this.fields[newY][newX] = pawn;

        removePawn(oldX, oldY, newX, newY);


    }

    private void removePawn(int oldX, int oldY, int newX, int newY) {
        if (Math.abs(newX - oldX) == 2){
            this.fields[(oldY + newY)/2][(oldX + newX)/2] = null;
        }
    }

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public String toString(){
        StringBuilder formattedBoard = new StringBuilder();
        StringBuilder firstRow = new StringBuilder("  ");
        for (int i = 1; i <= this.size; i++) {
            firstRow.append(" " + (char) (i + 64) + " ");
        }
        formattedBoard.append(firstRow).append("\n");
        int rowNumber = 1;
        boolean whiteSquare = true;
        for (Pawn[] row : fields) {

            StringBuilder formattedRow = new StringBuilder(rowNumber + (rowNumber < 10 ? " " : ""));
            for (Pawn pawn : row) {

                if (pawn == null){
                    formattedRow.append( (whiteSquare? ANSI_WHITE_BACKGROUND : ANSI_BLACK_BACKGROUND) + "   " + ANSI_RESET);
                }
                else if (pawn.canMove() && pawn.getColor() == 0){
                    formattedRow.append( (whiteSquare? ANSI_WHITE_BACKGROUND : ANSI_BLACK_BACKGROUND) + ANSI_WHITE + " ● " + ANSI_RESET );
                } else if (pawn.canMove() && pawn.getColor() == 1){
                    formattedRow.append( (whiteSquare? ANSI_WHITE_BACKGROUND : ANSI_BLACK_BACKGROUND) + ANSI_YELLOW + " ● " + ANSI_RESET );
                } else {
                    if (pawn.getColor()==0){
                        formattedRow.append( (whiteSquare? ANSI_WHITE_BACKGROUND : ANSI_BLACK_BACKGROUND) + ANSI_WHITE + " ◐ " + ANSI_RESET);
                    } else {
                        formattedRow.append( (whiteSquare? ANSI_WHITE_BACKGROUND : ANSI_BLACK_BACKGROUND) + ANSI_YELLOW + " ◐ " + ANSI_RESET);
                    }
                }
                whiteSquare = !whiteSquare;
            }
            formattedRow.append("\n");
            formattedBoard.append(formattedRow);
            rowNumber++;
            whiteSquare = !whiteSquare;
        }

        return formattedBoard.toString();
    }
}
