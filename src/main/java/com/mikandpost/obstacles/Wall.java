package com.mikandpost.obstacles;

import com.mikandpost.participants.Runner;

public class Wall implements Obstacle{
    protected int height;

    public Wall(int height) {
        this.height = height;
    }

    public boolean check(Runner runner) {
        if (runner.getMaxHeight() >= height) {
            System.out.println(runner.getClass().getSimpleName() + " " + runner.getName() + " перепрыгнул " + height);
            return true;
        } else {
            System.out.println(runner.getClass().getSimpleName() + " " + runner.getName() + " не перепрыгнул " + height);
            return false;
        }
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Wall{" +
                "height=" + height +
                '}';
    }

}
