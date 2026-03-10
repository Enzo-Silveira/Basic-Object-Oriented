package exercises;

import java.sql.SQLOutput;

public class Main {
    void main(){
        Team team = new Team("time1", "base", "zezinho");
        System.out.println(team.getName());
        System.out.println(team.getBaseLocation());
        System.out.println(team.getCoachName());

        Player player1 = new Player("player1", 1, "position1", true);
        Player player2 = new Player("player2", 2, "position2", false);
        Player player3 = new Player("player3", 3, "position3", true);
        Player player4 = new Player("player4", 4, "position4", false);
        Player player5 = new Player("player5", 5, "position5", true);
        Player player6 = new Player("player6", 6, "position6", false);

        team.addPlayer(player1);
        team.addPlayer(player2);
        team.addPlayer(player3);
        team.addPlayer(player4);
        team.addPlayer(player5);
        team.substitute(player6,player4);
        team.setCaptain(player1);
        Player[] fielded = team.getFieldedPlayers();
        team.removePlayer(player2);

        fielded = team.getFieldedPlayers();
        System.out.println(fielded[0].getStateAsString());
    }
}
