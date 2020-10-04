package com.mikandpost;

import com.mikandpost.obstacles.Obstacle;
import com.mikandpost.participants.Runner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Competition {
    public List<Runner> jumpOrRun(Collection<Runner> runners, Collection<Obstacle> obstacles) {
        List<Runner> actualResult = new ArrayList<>(runners);

        for (Obstacle obstacle : obstacles) {
            Iterator<Runner> iterator = actualResult.iterator();
            while (iterator.hasNext()) {
                Runner runner = iterator.next();
                boolean isPassed = obstacle.check(runner);
                if (!isPassed) {
                    iterator.remove();
                }
            }
        }

        return actualResult;
    }

}

