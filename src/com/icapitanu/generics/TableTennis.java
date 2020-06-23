package com.icapitanu.generics;

import java.util.Random;

/*
* @author ionutcapitanu on 2020-01-14 
*/
public class TableTennis implements Sport {

    @Override
    public int[] computePoints(int[] result) {
        //Sets won mean actual points in table tennis
        return result;
    }

    @Override
    public int[] playMatch() {
        int scoreTeam1 = 0;
        int scoreTeam2 = 0;
        int setResult;
        int[] finalScore = new int[2];

        for (int i=0;i<=4;i++) {
            if (scoreTeam1 < 3 && scoreTeam2 < 3) {
                setResult = playSet();
                if (setResult > 0) scoreTeam1++;
                else scoreTeam2++;
            }
        }

        finalScore[0] = scoreTeam1;
        finalScore[1] = scoreTeam2;
        return finalScore;
     }

    // Play a set and return the score difference
    private int playSet() {
        Random randomScore = new Random();
        int scoreTeam1 = randomScore.nextInt(11);
        int scoreTeam2 = randomScore.nextInt(11);
        // In case of equality, generate another set result
        while (scoreTeam1 == scoreTeam2) {
            scoreTeam1 = randomScore.nextInt(11);
        }
        return scoreTeam1 - scoreTeam2;
     }
}
