package com.mikandpost.obstacles;

import com.mikandpost.participants.Runner;

public class Treadmill implements Obstacle{
    protected int length;

    public Treadmill(int length) {
        this.length = length;
    }

    public boolean check(Runner runner){
        if (runner.getMaxLength() >= length){
            System.out.println(runner.getClass().getSimpleName() + " " + runner.getName() + " пробежал " + length);
            return true;
        } else {
            System.out.println(runner.getClass().getSimpleName() + " " + runner.getName() + " не пробежал " + length);
            return false;
        }
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
