package com.icapitanu.generics;

import javax.swing.text.AbstractDocument;

import sun.tools.jconsole.Tab;

/*
* @author ionutcapitanu on 2020-01-14 
*/
public class Main {

    public static void main(String[] args) {
        //create league
        League<Team<Football>> footBallLeague = new League<>("Football League");

        //add teams
        Team<Football> team1 = new Team<>("FotbalTeam1", Football.class);
        Team<Football> team2 = new Team<>("FotbalTeam2", Football.class);
        Team<Football> team3 = new Team<>("FotbalTeam3", Football.class);
        footBallLeague.addTeam(team1);
        footBallLeague.addTeam(team2);
        footBallLeague.addTeam(team3);

        //plays some Matches
        team1.playMatch(team3);
        team2.playMatch(team1);
        team3.playMatch(team1);

        //print league
        footBallLeague.printLeague();

        League<Team<TableTennis>> tennisLeague = new League<>( "Tenis League");
        Team<TableTennis> tTeam1 = new Team<>("TTeam1", TableTennis.class);
        Team<TableTennis> tTeam2 = new Team<>("TTeam2", TableTennis.class);
        Team<TableTennis> tTeam3 = new Team<>("TTeam3", TableTennis.class);
        tennisLeague.addTeam( tTeam1 );
        tennisLeague.addTeam( tTeam2 );
        tennisLeague.addTeam( tTeam3 );
        tTeam1.playMatch(tTeam3);
        tTeam2.playMatch(tTeam1);
        tTeam3.playMatch(tTeam1);
        tennisLeague.printLeague();
    }
}

