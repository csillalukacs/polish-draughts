package com.codecool.polishdraughts;

public class Coordinates {
    private int x;
    private int y;

    public Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Coordinates topRight(int boardSize){
        if (x < boardSize - 1){
            if (y > 0){
                return new Coordinates(x+1, y-1);
            }
        }
        return null;
    }
    public Coordinates bottomRight(int boardSize){
        if (x < boardSize - 1){
            if (y < boardSize - 1){
                return new Coordinates(x+1, y+1);
            }
        }
        return null;
    }
    public Coordinates topLeft(int boardSize){
        if (x > 0){
            if (y > 0){
                return new Coordinates(x-1, y-1);
            }
        }
        return null;
    }
    public Coordinates bottomLeft(int boardSize){
        if (x > 0){
            if (y < boardSize - 1){
                return new Coordinates(x-1, y+1);
            }
        }
        return null;
    }

    public Coordinates captureTopRight(int boardSize){
        Coordinates topRight = this.topRight(boardSize);
        if (topRight != null){
            return topRight.topRight(boardSize);
        }
        return null;
    }

    public Coordinates captureTopLeft(int boardSize){
        Coordinates topLeft = this.topLeft(boardSize);
        if (topLeft != null){
            return topLeft.topLeft(boardSize);
        }
        return null;
    }

    public Coordinates captureBottomRight(int boardSize){
        Coordinates bottomRight = this.bottomRight(boardSize);
        if (bottomRight != null){
            return bottomRight.bottomRight(boardSize);
        }
        return null;
    }

    public Coordinates captureBottomLeft(int boardSize){
        Coordinates bottomLeft = this.bottomLeft(boardSize);
        if (bottomLeft != null){
            return bottomLeft.bottomLeft(boardSize);
        }
        return null;
    }
}
