package com.codecool.polishdraughts;

public class Board {



    private Pawn[][] fields;
    private int size;

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

/*    public void movePawn(Pawn pawn, Coordinates coordinates){
        pawn.
    }*/

    public void printBoard(){
        System.out.println("this is a(n) " + fields.length + " by " + fields.length + " board");
        StringBuilder formattedBoard = new StringBuilder();
        StringBuilder firstRow = new StringBuilder();
        for (int i = 1; i <= this.size; i++) {
            firstRow.append((char) (i + 64));
        }
        formattedBoard.append(firstRow).append("\n");
        for (Pawn[] row : fields) {
            StringBuilder formattedRow = new StringBuilder();
            for (Pawn pawn : row) {
                formattedRow.append((pawn != null) ? pawn.getColor() : " ");
            }
            formattedRow.append("\n");
            formattedBoard.append(formattedRow);
        }
        System.out.println(formattedBoard);
    }
}
