package exercises.exer2;

public class Player {
    private String name;
    private int number;
    private String position;
    private boolean isFielded;

    private Team team;

    public Player(String name, int number, String position, boolean isFielded) {
        this.name = name;
        this.number = number;
        this.position = position;
        this.isFielded = isFielded;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public boolean getIsFielded() {
        return isFielded;
    }

    public String getStateAsString(){
        return "nome: "+name+"; number: "+number+"; position: "+position+"; isFielded: "+isFielded;
    }


}
