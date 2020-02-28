package sample;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;

public class Main extends Application implements EventHandler<ActionEvent> {
    private Stage window;
    private Scene startScene;
    private Button buttonBack,buttonFight,buttonBracket,buttonBracketTwo,buttonPunch,buttonPunchTwo,buttonPunchThree, nextFight, nextFightTwo,buttonNextFight;
    private Label fighterOneName,fighterTwoName,hpFighterOne,hpFighterTwo,fighterOneName2,fighterTwoName2,hpFighterOne2,hpFighterTwo2;
    private Scene bracketScene;
    private Scene fightScene;
    private Scene fightSceneTwo;
    private Scene fightSceneThree;
    private Scene fightSceneFour;
    private Scene fightSceneFive;
    private Label firstBracket;
    private Label secondBracket;
    private Label thirdBracket;
    private Label winnerBracket;
    private HBox hboxBracket;
    private Fighter one;
    private Fighter two;
    private int oneHealth;
    private int twoHealth;
    private int fighterOne = 0;
    private int fighterTwo = 1;
    private int match = 1;
    private int matchSeries = 1;
    private int initialHealthOne, initialHealthTwo;
    private AudioClip sound = new AudioClip(new File("punchSound.wav").toURI().toString());

    private final String BUTTON_STYLE = "-fx-background-color: \n" +
            "        #000000,\n" +
            "        linear-gradient(#636363, #838685),\n" +
            "        linear-gradient(#212022, #000000),\n" +
            "        linear-gradient(#4b4a4f, #1a191b);\n" +
            "    -fx-background-insets: 0,1,2,3;\n" +
            "    -fx-background-radius: 3,2,2,2;\n" +
            "    -fx-padding: 12 30 12 30;\n" +
            "    -fx-text-fill: white;\n" +
            "    -fx-font-size: 12px;";

    private final String LABEL_STYLE = "-fx-font-size: 54px;" +
            "-fx-font-family: Times New Roman;";

    private final String IN_GAME_LABEL = "-fx-font-size: 54px;" +
            "-fx-font-family: Times New Roman;" +
            "-fx-text-fill: white";


    @Override
    public void start(Stage stage) throws Exception{
        window = stage;



        stage.setTitle("The Fighter");
        FileInputStream icon = new FileInputStream("FighterImgs\\icon.png");
        stage.getIcons().add(new Image(icon));
        stage.setResizable(false);

        buttonBack = new Button("Back");
        buttonBack.setOnAction(this);
        buttonBack.setStyle(BUTTON_STYLE);

        buttonFight = new Button("Fight");
        buttonFight.setOnAction(this);
        buttonFight.setStyle(BUTTON_STYLE);

        buttonBracket = new Button("Bracket");
        buttonBracket.setOnAction(this);
        buttonBracket.setStyle(BUTTON_STYLE);

        buttonBracketTwo = new Button("Bracket");
        buttonBracketTwo.setOnAction(this);
        buttonBracketTwo.setStyle(BUTTON_STYLE);

        buttonPunch = new Button("Punch");
        buttonPunch.setOnAction(this);
        buttonPunch.setStyle(BUTTON_STYLE);

        buttonPunchTwo = new Button("Punch");
        buttonPunchTwo.setOnAction(this);
        buttonPunchTwo.setStyle(BUTTON_STYLE);

        buttonPunchThree = new Button("Punch");
        buttonPunchThree.setOnAction(this);
        buttonPunchThree.setStyle(BUTTON_STYLE);

        nextFight = new Button("Next Fight");
        nextFight.setOnAction(this);
        nextFight.setStyle(BUTTON_STYLE);

        nextFightTwo = new Button("NextFight");
        nextFightTwo.setOnAction(this);
        nextFightTwo.setStyle(BUTTON_STYLE);

        buttonNextFight = new Button("NextFight");
        buttonNextFight.setOnAction(this);
        buttonNextFight.setStyle(BUTTON_STYLE);

        firstBracket = new Label( Roster.getInstance().getRoster().get(0).getName() + "\n"+
        Roster.getInstance().getRoster().get(1).getName()+"\n"+
        Roster.getInstance().getRoster().get(2).getName()+"\n"+
        Roster.getInstance().getRoster().get(3).getName()+"\n"+
        Roster.getInstance().getRoster().get(4).getName()+"\n"+
        Roster.getInstance().getRoster().get(5).getName()+"\n"+
        Roster.getInstance().getRoster().get(6).getName()+"\n"+
        Roster.getInstance().getRoster().get(7).getName()+"\n");
        firstBracket.setStyle(LABEL_STYLE);

        secondBracket = new Label();

        thirdBracket = new Label();

        winnerBracket = new Label();


        fighterOneName = new Label(Roster.getInstance().getRoster().get(fighterOne).getName() + " " );
        fighterOneName.setStyle(IN_GAME_LABEL);

        fighterTwoName = new Label(Roster.getInstance().getRoster().get(fighterTwo).getName() + " ");
        fighterTwoName.setStyle(IN_GAME_LABEL);

        hpFighterOne = new Label("HP: " + Roster.getInstance().getRoster().get(fighterOne).getHealth());
        hpFighterOne.setStyle(IN_GAME_LABEL);

        hpFighterTwo = new Label("HP: " + Roster.getInstance().getRoster().get(fighterTwo).getHealth());
        hpFighterTwo.setStyle(IN_GAME_LABEL);

        fighterOneName2 = new Label(Roster.getInstance().getRoster().get(fighterOne).getName() + " " );
        fighterOneName2.setStyle(IN_GAME_LABEL);

        fighterTwoName2 = new Label(Roster.getInstance().getRoster().get(fighterTwo).getName() + " ");
        fighterTwoName2.setStyle(IN_GAME_LABEL);

        hpFighterOne2 = new Label("HP: " + Roster.getInstance().getRoster().get(fighterOne).getHealth());
        hpFighterOne2.setStyle(IN_GAME_LABEL);

        hpFighterTwo2 = new Label("HP: " + Roster.getInstance().getRoster().get(fighterTwo).getHealth());
        hpFighterTwo2.setStyle(IN_GAME_LABEL);




        HBox hboxStart = new HBox(buttonFight,buttonBracket);
        HBox hboxFight = new HBox(buttonPunch);
        hboxBracket = new HBox(firstBracket,secondBracket,thirdBracket,winnerBracket);
        HBox hboxFightTwo = new HBox(fighterOneName,hpFighterOne,buttonPunchTwo,fighterTwoName,hpFighterTwo);
        HBox hboxFightThree = new HBox(fighterOneName2,hpFighterOne2,buttonPunchThree,fighterTwoName2,hpFighterTwo2);
        HBox hboxFightFour = new HBox(nextFight);
        HBox hboxFightFive = new HBox(nextFightTwo);
        startScene = new Scene(hboxStart,1280,720);
        bracketScene = new Scene(hboxBracket,1280,720);
        fightScene = new Scene(hboxFight,1280,720);
        fightSceneTwo = new Scene(hboxFightTwo,1280,720);
        fightSceneThree = new Scene(hboxFightThree,1280,720);
        fightSceneFour = new Scene(hboxFightFour,1280,720);
        fightSceneFive = new Scene(hboxFightFive,1280,720);


        hboxStart.setAlignment(Pos.BOTTOM_CENTER);
        hboxFight.setAlignment(Pos.BOTTOM_CENTER);
        hboxFightTwo.setAlignment(Pos.BOTTOM_CENTER);
        hboxFightThree.setAlignment(Pos.BOTTOM_CENTER);
        hboxFightFour.setAlignment(Pos.BOTTOM_CENTER);
        hboxFightFive.setAlignment(Pos.BOTTOM_CENTER);

        HBox.setMargin(buttonFight, new Insets(0, 10, 45, 0));
        HBox.setMargin(buttonBracket, new Insets(0,10,45,0));
        HBox.setMargin(buttonBracketTwo, new Insets(0,10,45,0));
        HBox.setMargin(buttonPunch, new Insets(0,10,45,0));
        HBox.setMargin(buttonPunchTwo, new Insets(0,10,45,0));
        HBox.setMargin(buttonPunchThree, new Insets(0,10,45,0));
        HBox.setMargin(nextFight, new Insets(0,10,45,0));
        HBox.setMargin(nextFightTwo, new Insets(0,10,45,0));
        HBox.setMargin(buttonNextFight, new Insets(0,10,45,0));
        HBox.setMargin(fighterOneName, new Insets(0,0,500,0));
        HBox.setMargin(fighterTwoName, new Insets(0,0,500,0));
        HBox.setMargin(hpFighterOne, new Insets(0,0,500,0));
        HBox.setMargin(hpFighterTwo, new Insets(0,0,500,0));
        HBox.setMargin(fighterOneName2, new Insets(0,0,500,0));
        HBox.setMargin(fighterTwoName2, new Insets(0,0,500,0));
        HBox.setMargin(hpFighterOne2, new Insets(0,0,500,0));
        HBox.setMargin(hpFighterTwo2, new Insets(0,0,500,0));
        HBox.setMargin(firstBracket, new Insets(-5,10,0,40));
        HBox.setMargin(secondBracket, new Insets(-3,10,0,140));
        HBox.setMargin(thirdBracket, new Insets(-10,10,0,140));
        HBox.setMargin(winnerBracket, new Insets(-6,10,0,140));
        HBox.setMargin(buttonBack, new Insets(650,10,0,360));

        fighterOneName.setMinSize(200,300);
        fighterOneName.setMaxSize(200,300);

        fighterTwoName.setMinSize(200,300);
        fighterTwoName.setMaxSize(200,300);

        hpFighterOne.setMinSize(200,300);
        hpFighterOne.setMaxSize(200,300);

        hpFighterTwo.setMinSize(200,300);
        hpFighterTwo.setMaxSize(200,300);

        fighterOneName2.setMinSize(200,300);
        fighterOneName2.setMaxSize(200,300);

        fighterTwoName2.setMinSize(200,300);
        fighterTwoName2.setMaxSize(200,300);

        hpFighterOne2.setMinSize(200,300);
        hpFighterOne2.setMaxSize(200,300);

        hpFighterTwo2.setMinSize(200,300);
        hpFighterTwo2.setMaxSize(200,300);



        firstBracket.setMinSize(200,710);
        firstBracket.setMaxSize(200,710);

        secondBracket.setMinSize(180,710);
        secondBracket.setMaxSize(180,710);

        thirdBracket.setMaxSize(200,710);
        thirdBracket.setMaxSize(200,710);

        winnerBracket.setMaxSize(200,710);
        winnerBracket.setMaxSize(200,710);


        FileInputStream input = new FileInputStream("FighterImgs\\start.png");
        FileInputStream bracket = new FileInputStream("FighterImgs\\bracket.png");
        FileInputStream fightOne = new FileInputStream("FighterImgs\\one.png");
        FileInputStream fightTwo = new FileInputStream("FighterImgs\\two.png");
        FileInputStream fightThree = new FileInputStream("FighterImgs\\three.png");
        FileInputStream fightFour = new FileInputStream("FighterImgs\\four.png");
        FileInputStream fightFive = new FileInputStream("FighterImgs\\five.png");

        Image backG = new Image(input);
        Image bracketImg = new Image(bracket);
        Image fightSeqOne = new Image(fightOne);
        Image fightSeqTwo = new Image(fightTwo);
        Image fightSeqThree = new Image(fightThree);
        Image fightSeqFour = new Image(fightFour);
        Image fightSeqFive = new Image(fightFive);



        BackgroundImage backgroundimage = new BackgroundImage(backG,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background background = new Background(backgroundimage);

        BackgroundImage bracketBgImg = new BackgroundImage(bracketImg,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background bracketBg = new Background(bracketBgImg);

        BackgroundImage firstFight = new BackgroundImage(fightSeqOne,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background fightBgOne = new Background(firstFight);

        BackgroundImage secondFight = new BackgroundImage(fightSeqTwo,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background fightBgTwo = new Background(secondFight);

        BackgroundImage thirdFight = new BackgroundImage(fightSeqThree,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background fightBgThree = new Background(thirdFight);

        BackgroundImage fourthFight = new BackgroundImage(fightSeqFour,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background fightBgFour = new Background(fourthFight);

        BackgroundImage fifthFight = new BackgroundImage(fightSeqFive,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background fightBgFive = new Background(fifthFight);


        hboxStart.setBackground(background);
        hboxBracket.setBackground(bracketBg);
        hboxFight.setBackground(fightBgOne);
        hboxFightTwo.setBackground(fightBgTwo);
        hboxFightThree.setBackground(fightBgThree);
        hboxFightFour.setBackground(fightBgFour);
        hboxFightFive.setBackground(fightBgFive);

        stage.setScene(startScene);

        stage.show();
    }

    @Override
    public void handle(ActionEvent event) {

        if(event.getSource() == buttonBack){
            window.setScene(startScene);
        }

        if(event.getSource() == buttonFight)
            window.setScene(fightScene);

        if(event.getSource() == buttonBracket || event.getSource() == buttonBracketTwo) {

            if(matchSeries == 1) {
                hboxBracket = new HBox(secondBracket, thirdBracket, winnerBracket);
            }
            else if(matchSeries == 2){
                hboxBracket = new HBox(thirdBracket, winnerBracket);
                setSecondBracket();
            }
            else if (matchSeries == 3){
                hboxBracket = new HBox(winnerBracket);
                setSecondBracket();
                setThirdBracket();
            }
            else if(matchSeries == 4){
                setSecondBracket();
                setThirdBracket();
                setFourthBracket();
            }
            window.setScene(bracketScene);
        }

        if(event.getSource() == buttonPunch){
            window.setScene(fightSceneTwo);
            nextFight.setText("Next Fight");
            nextFightTwo.setText("Next Fight");
            getFighters();
            initialHealthOne = one.getHealth();
            initialHealthTwo = two.getHealth();
            Match m = Match.getInstance(Roster.getInstance());
            int punch = m.firstFighterPunch(one,two);
            getFighters();
            hpFighterTwo.setText("\nHP: " + twoHealth + "\n -" + punch);
            hpFighterTwo2.setText("\nHP: " + twoHealth + "\n -" + punch);
            sound.play();
        }

        if (event.getSource() == buttonPunchTwo) {
            window.setScene(fightSceneThree);
            getFighters();
            Match m = Match.getInstance(Roster.getInstance());
            int punch = m.secondFighterPunch(one,two);
            getFighters();
            hpFighterOne.setText("\nHP: " + oneHealth + "\n -" + punch);
            hpFighterOne2.setText("\nHP: " + oneHealth + "\n -" + punch);
            sound.play();
            checkHealth();
        }
        if (event.getSource() == buttonPunchThree) {
            window.setScene(fightSceneTwo);
            getFighters();
            Match m = Match.getInstance(Roster.getInstance());
            int punch = m.firstFighterPunch(one,two);
            getFighters();
            hpFighterTwo.setText("\nHP: " + twoHealth+ "\n -" + punch);
            hpFighterTwo2.setText("\nHP: " + twoHealth + "\n -" + punch);
            sound.play();
            checkHealth();
        }

        nextFight(event, nextFight);

        nextFight(event, nextFightTwo);


    }

    private void nextFight(ActionEvent event, Button nextFight) {
        if(event.getSource() == nextFight){
            buttonPunchTwo.setOnAction(this);
            buttonPunchThree.setOnAction(this);
            window.setScene(fightScene);
            getFighters();
            fighterOneName.setText(one.getName()+ " " );
            fighterTwoName.setText(two.getName()+ " ");
            hpFighterOne.setText("HP: " + one.getHealth());
            hpFighterTwo.setText("HP: " + two.getHealth());
            fighterOneName2.setText(one.getName() + " " );
            fighterTwoName2.setText(two.getName()+ " ");
            hpFighterOne2.setText("HP: " + one.getHealth());
            hpFighterTwo2.setText("HP: " + two.getHealth());
            buttonPunchThree.setOnAction(this);
        }
    }


    public static void main(String[] args) {
        Match match = Match.getInstance(Roster.getInstance());
        Roster roster = Roster.getInstance();

        Fighter one = FighterFactory.getFighter("HHP","Pontus","Enkel Vinst!");
        Fighter two = FighterFactory.getFighter("HPF","Conny","Jag gillar Öl!");
        Fighter three = FighterFactory.getFighter("HSF","Åke","Jag är stark!");
        Fighter four = FighterFactory.getFighter("HPF","Berra","För lätt");
        Fighter five = FighterFactory.getFighter("HHP","Albert","Klen instats");
        Fighter six = FighterFactory.getFighter("HHP","Klasse","Jag är för bra");
        Fighter seven = FighterFactory.getFighter("HSF","Conrad","Ingen gillar dig");
        Fighter eight = FighterFactory.getFighter("HSF","Kenta","Vart är motståndet?");

        launch(args);
    }

    private void getFighters(){
        switch (matchSeries){
            case 1:
                one = Roster.getInstance().getRoster().get(fighterOne);
                oneHealth = Roster.getInstance().getRoster().get(fighterOne).getHealth();
                two = Roster.getInstance().getRoster().get(fighterTwo);
                twoHealth = Roster.getInstance().getRoster().get(fighterTwo).getHealth();
                break;
            case 2:
                one = Roster.getInstance().getQuarterFinals().get(fighterOne);
                oneHealth = Roster.getInstance().getQuarterFinals().get(fighterOne).getHealth();
                two = Roster.getInstance().getQuarterFinals().get(fighterTwo);
                twoHealth = Roster.getInstance().getQuarterFinals().get(fighterTwo).getHealth();
                break;
            case 3:
                one = Roster.getInstance().getSemiFinals().get(fighterOne);
                oneHealth = Roster.getInstance().getSemiFinals().get(fighterOne).getHealth();
                two = Roster.getInstance().getSemiFinals().get(fighterTwo);
                twoHealth = Roster.getInstance().getSemiFinals().get(fighterTwo).getHealth();
                break;
            case 4:
                one = Roster.getInstance().getWinner().get(0);
                two = Roster.getInstance().getWinner().get(0);
                break;
        }
    }

    private void setMatchSeries(){
        if(matchSeries == 1 && match == 5) {
            matchSeries = 2;
            match = 1;
            fighterOne = 0;
            fighterTwo = 1;
            nextFight.setText("Semi Finals");
            nextFightTwo.setText("Semi Finals");
            setSecondBracket();
        }
        else if(matchSeries == 2 && match == 3){
            matchSeries = 3;
            match = 1;
            fighterOne = 0;
            fighterTwo = 1;
            nextFight.setText("Final Match");
            nextFightTwo.setText("Final Match");
            setSecondBracket();
            setThirdBracket();
        }
        else if(matchSeries == 3 && match == 2){
            matchSeries = 4;
            getFighters();
            nextFight.setText("Bracket");
            nextFightTwo.setText("Bracket");
            nextFight.setOnAction(actionEvent -> window.setScene(bracketScene));
            nextFightTwo.setOnAction(actionEvent -> window.setScene(bracketScene));
            setSecondBracket();
            setThirdBracket();
            setFourthBracket();
        }
    }


    private void checkHealth(){
        if(twoHealth<=0||oneHealth<=0) {
            buttonPunchTwo.setOnAction(null);
            buttonPunchThree.setOnAction(null);
            if(oneHealth>twoHealth || twoHealth<=0) {
                one.setHealth(initialHealthOne);
                buttonPunchThree.setOnAction(null);
                PauseTransition pause = new PauseTransition(Duration.seconds(1));
                pause.setOnFinished(next -> window.setScene(fightSceneFour));
                pause.play();
                if(matchSeries==1) {
                    Roster.getInstance().addFighterQuarter(one);
                } else if(matchSeries==2){
                    Roster.getInstance().addFighterSemi(one);
                } else if(matchSeries==3){
                    Roster.getInstance().addWinner(one);
                }
                match++;
                fighterOne+=2;
                fighterTwo+=2;
                setMatchSeries();
            }
            else if(oneHealth<twoHealth || oneHealth<=0){
                two.setHealth(initialHealthTwo);
                buttonPunchThree.setOnAction(null);
                PauseTransition pause = new PauseTransition(Duration.seconds(1));
                pause.setOnFinished(next -> window.setScene(fightSceneFive));
                pause.play();
                if(matchSeries==1) {
                    Roster.getInstance().addFighterQuarter(two);
                } else if(matchSeries==2){
                    Roster.getInstance().addFighterSemi(two);
                } else if(matchSeries==3){
                    Roster.getInstance().addWinner(two);
                }
                match++;
                fighterOne+=2;
                fighterTwo+=2;
                setMatchSeries();

            }
        }
    }

    public void setSecondBracket(){
        secondBracket.setText(Roster.getInstance().getQuarterFinals().get(0).getName() + "\n\n"+
                Roster.getInstance().getQuarterFinals().get(1).getName()+"\n\n"+
                Roster.getInstance().getQuarterFinals().get(2).getName()+"\n\n"+
                Roster.getInstance().getQuarterFinals().get(3).getName()+"\n\n");
        secondBracket.setStyle(LABEL_STYLE);
    }

    public void setThirdBracket(){
        thirdBracket.setText(Roster.getInstance().getSemiFinals().get(0).getName()+"\n\n\n\n"+
                Roster.getInstance().getSemiFinals().get(1).getName());
        thirdBracket.setStyle(LABEL_STYLE);
    }

    public void setFourthBracket(){
        winnerBracket.setText(Roster.getInstance().getWinner().get(0).getName());
        winnerBracket.setStyle(LABEL_STYLE);
    }
}
