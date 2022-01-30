package com.company.cabBooking.models;

public class Location {
    private int X;
    private int Y;

    public Location(int X, int Y)
    {
        this.X = X;
        this.Y = Y;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }
}

