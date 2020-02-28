package sample;

public class FighterFactory {


    public static Fighter getFighter(String fighterType ,String name, String winningMotto){
        if("HSF".equalsIgnoreCase(fighterType))
            return new HighSpeedFighter(name,winningMotto);

        else if("HPF".equalsIgnoreCase(fighterType))
            return new HighPowerFighter(name,winningMotto);

        else if("HHP".equalsIgnoreCase(fighterType))
            return new HighHpFighter(name,winningMotto);

        return null;
    }
}
