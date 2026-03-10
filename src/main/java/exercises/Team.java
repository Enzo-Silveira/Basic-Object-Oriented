package exercises;

public class Team {
    private String name;
    private String baseLocation;
    private String coachName;

    private Player[] players = new Player[18];
    private int numberOfPlayers;

    private Player captain;

    public Team(String name, String baseLocation, String coachName) {
        this.name = name;
        this.baseLocation = baseLocation;
        this.coachName = coachName;
    }

    public String getName() {
        return name;
    }

    public String getBaseLocation() {
        return baseLocation;
    }

    public String getCoachName() {
        return coachName;
    }

    private int findPosition(Player player){
        for(int i = 0; i<numberOfPlayers; i++){
            if(players[i] == player) return i;
        }
        return -1;
    }

    public void addPlayer(Player player){
        if(findPosition(player) == -1 && numberOfPlayers < players.length) {
            players[numberOfPlayers++] = player;
            player.setTeam(this);
        }
    }

    public void removePlayer(Player player){
        int p = findPosition(player);
        if(p != -1){
            for(int i = p;i<numberOfPlayers-1;i++){
                players[i] = players[i+1];
            }
            numberOfPlayers--;
            player.setTeam(null);
        }
    }

    public void substitute(Player substitute, Player starter){
        int pStarter = findPosition(starter);
        int pSubstitute = findPosition(substitute);
        if(pStarter != -1 && pSubstitute == -1) {
            players[pStarter] = substitute;
            substitute.setTeam(this);
            starter.setTeam(null);
        }
    }

    public void setCaptain(Player captain){
        if(findPosition(captain)!= -1) this.captain = captain;
    }

    public Player[] getFieldedPlayers(){
        int count = 0, numberOfFielded = 0;
        for(int i = 0; i < numberOfPlayers; i++){
            if(players[i].getIsFielded()) count++;
        }
        Player[] fielded = new Player[count];

        for(int i = 0; i < numberOfPlayers; i++){
            if(players[i].getIsFielded()){
                fielded[numberOfFielded++] = players[i];
            }
        }
        return fielded;
    }

    public Player[] getOutfieldedPlayers(){
        int count = 0, numberOfOutfielded = 0;
        for(int i = 0; i < numberOfPlayers; i++){
            if(!players[i].getIsFielded()) count++;
        }
        Player[] outfielded = new Player[count];

        for(int i = 0; i < numberOfPlayers; i++){
            if(!players[i].getIsFielded()){
                outfielded[numberOfOutfielded++] = players[i];
            }
        }
        return outfielded;
    }

}
