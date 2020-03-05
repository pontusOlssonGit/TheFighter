package fighter;

public abstract class Fighter {

    public Roster roster = Roster.getInstance();
    public abstract String getName();
    public abstract int getHealth();
    public abstract int getSpeed();
    public abstract int getPower();
    public abstract void setHealth(int health);
    public abstract String getWinningMotto();


    @Override
    public String toString() {
        return "Name: " + this.getName() +", HP: " + this.getHealth() + " Speed: " + this.getSpeed() + ", Strength:  " + this.getPower();
    }
}
