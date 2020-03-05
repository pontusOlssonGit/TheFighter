package fighter;

import java.util.ArrayList;
import java.util.List;

public class Roster {
    private List<Fighter> roster = new ArrayList<>();
    private List<Fighter> quarterFinals = new ArrayList<>();
    private List<Fighter> semiFinals = new ArrayList<>();
    private List<Fighter> winner = new ArrayList<>();

    private static Roster instance;

    public static Roster getInstance(){
        if(instance == null){
            instance = new Roster();
        }
        return instance;
    }

    public void addFighter(Fighter fighter) {
        roster.add(fighter);
    }

    public void addFighterQuarter(Fighter fighter){quarterFinals.add(fighter);}

    public void addFighterSemi(Fighter fighter){semiFinals.add(fighter);}

    public void addWinner(Fighter fighter){winner.add(fighter);}

    public List<Fighter> getRoster() { return this.roster; }

    public List<Fighter> getQuarterFinals(){return this.quarterFinals;}

    public List<Fighter> getSemiFinals(){return this.semiFinals;}

    public List<Fighter> getWinner(){return this.winner;}
}

