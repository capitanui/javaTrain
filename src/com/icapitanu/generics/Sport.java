package com.icapitanu.generics;

/*
 * @author ionutcapitanu on 2020-01-14
 */

public interface Sport {

    /*
     *  Returns an integer array with 2 elements representing the score (eq: 3 - 1)
     */
    int[] playMatch();

    /*
    *  Returns an array with 2 elements holding the points of each team computed based on the score
    */
    int[] computePoints(int[] score);

}
