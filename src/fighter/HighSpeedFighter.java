package fighter;

public class HighSpeedFighter extends Fighter {

    private String name;
    private int health;
    private int speed;
    private int power;
    private String winningMotto;

    public HighSpeedFighter(String name, String winningMotto) {
        this.name = name;
        this.health = 100;
        this.speed = (int)(Math.random()*200)+100;
        this.power = 100;
        this.winningMotto = winningMotto;
        super.roster.addFighter(this);

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getSpeed() {
        return this.speed;
    }

    @Override
    public int getPower() {
        return this.power;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String getWinningMotto() {
        return this.winningMotto;
    }
}
