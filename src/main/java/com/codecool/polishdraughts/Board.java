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
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i < 4) || (i >= n - 4)) {
                    boolean isBlack = (i >= n - 4);
                    if (i % 2 == 0) {
                        if (j % 2 == 1) {
                            this.fields[i][j] = new Pawn(j, i, isBlack ? 1 : 0, this.fields);
                        }
                    } else {
                        if (j % 2 == 0) {
                            this.fields[i][j] = new Pawn(j, i, isBlack ? 1 : 0, this.fields);
                        }
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


    public String toString(){
        System.out.println("this is a(n) " + fields.length + " by " + fields.length + " board");
        StringBuilder formattedBoard = new StringBuilder();
        StringBuilder firstRow = new StringBuilder("  ");
        for (int i = 1; i <= this.size; i++) {
            firstRow.append(" " + (char) (i + 64) + " ");
        }
        formattedBoard.append(firstRow).append("\n");
        int rowNumber = 1;
        for (Pawn[] row : fields) {
            StringBuilder formattedRow = new StringBuilder(rowNumber + (rowNumber < 10 ? " " : ""));
            for (Pawn pawn : row) {
                formattedRow.append((pawn != null) ? " " + pawn.getColor() + " " : " . ");
            }
            formattedRow.append("\n");
            formattedBoard.append(formattedRow);
            rowNumber++;
        }

        return formattedBoard.toString();
    }
}
