package test;

import fighter.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class Test {


    private static Fighter hhpFighter;
    private static Fighter hsfFighter;


    @BeforeClass
    public static void setUp() {
        hhpFighter = FighterFactory.getInstance().getFighter("HHP","","");
        hsfFighter = FighterFactory.getInstance().getFighter("HSF","","");
    }

    @org.junit.Test
    public void testFactory(){

        assertSame(hhpFighter.getClass(),
                FighterFactory.getInstance().getFighter("HHP","","").getClass());
        assertNotSame(hsfFighter.getClass(),
                FighterFactory.getInstance().getFighter("HHP","","").getClass());

    }

    @org.junit.Test
    public void rosterNotNull(){
        assertNotNull(Roster.getInstance());
    }
    @org.junit.Test
    public void matchNotNull(){
        assertNotNull(Match.getInstance(Roster.getInstance()));
    }


}