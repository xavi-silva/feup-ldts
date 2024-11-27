package org.l06gr01.model;

public class Position {
    private final int x;
    private final int y;


    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public Position getRight(){return new Position(x+1,y);}
    public Position getLeft(){return new Position(x-1,y);}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

}

