package com.icapitanu.generics;

/*
* @author ionutcapitanu on 2020-01-14 
*/

public class Team<T extends Sport> implements Comparable<Team<T>> {

    private Sport sportType;
    private String name;
    private int points;

    public Team(String name, Class<T> type) {
        this.name = name;
        this.sportType = (SportFactory.getInstance(type));
    }

    public int[] playMatch(Team<T> opponent) {
        int[] score = sportType.playMatch();
        int[] points = sportType.computePoints(score);
        this.updatePoints(points[0]);
        opponent.updatePoints(points[1]);
        return score;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    private void updatePoints(int points) {
        this.points += points;
    }

    @Override
    public int compareTo(Team<T> o) {
        if (getPoints() > o.getPoints()) return 1;
            else if (getPoints() < o.getPoints())  return -1;
        return 0;
    }
}

