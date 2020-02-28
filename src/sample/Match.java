package sample;

public class Match {
    private static Match instance;

    private Match(Roster roster) {
    }

    public static Match getInstance(Roster roster){
        if(instance == null){
            instance = new Match(roster);
        }
        return instance;
    }

    public int firstFighterPunch(Fighter one, Fighter two){
        int punch = (one.getPower()*3 + one.getSpeed()*2)*((int)(Math.random()*3)+1)/50;
        two.setHealth(two.getHealth()-punch);
        return punch;
    }

    public int secondFighterPunch(Fighter one, Fighter two){
        int punch = (two.getPower()*3 + two.getSpeed()*2)*((int)(Math.random()*3)+1)/50;
        one.setHealth(one.getHealth()-punch);
        return punch;
    }

}
