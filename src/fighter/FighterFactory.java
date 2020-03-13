package fighter;

public class FighterFactory {

    private static FighterFactory instance;

    public static FighterFactory getInstance(){
        if(instance == null){
            instance = new FighterFactory();
        }
        return instance;
    }

    public Fighter getFighter(String fighterType ,String name, String winningMotto){
        if("HSF".equalsIgnoreCase(fighterType))
            return new HighSpeedFighter(name,winningMotto);

        else if("HPF".equalsIgnoreCase(fighterType))
            return new HighPowerFighter(name,winningMotto);

        else if("HHP".equalsIgnoreCase(fighterType))
            return new HighHpFighter(name,winningMotto);

        return null;
    }
}
