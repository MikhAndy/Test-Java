package com.mikandpost.obstacles;

public class Treadmill {
    protected int length;

    public Treadmill(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "Treadmill{" +
                "length=" + length +
                '}';
    }
}
