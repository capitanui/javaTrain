package com.icapitanu.generics;

/*
* @author ionutcapitanu on 2020-01-14 
*/

import java.util.Random;

public class Football implements Sport {

    @Override
     public int[] computePoints(int[] result) {
        int[] points = new int[2];
        int scoreTeam1 = result[0];
        int scoreTeam2 = result[1];
        if (scoreTeam1>scoreTeam2) points[0] = 3;
            else if (scoreTeam1<scoreTeam2) points[1] = 3;
                else {
            points[0] = 1;
            points[1] = 1;
        }
        return points;
    }

    @Override
    public int[] playMatch() {
        int[] finalScore = new int[2];
        Random randomScore = new Random();
        finalScore[0]= randomScore.nextInt(5); // score of team1
        finalScore[1] = randomScore.nextInt(5); // score of team2
        return finalScore;
    }
}
