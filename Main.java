package com.company;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Space Invaders");
        Map map=new Map(400,400);
        Aliens alien= new Aliens(20,20,12);
        Defender defender=new Defender(20,20);
        Score score=Score.getInstance();
        alienShots alienS=new alienShots();
        defenderShots defShots=new defenderShots();
        map.initializeScene();
        alien.createShip(map.root,map.getWIDTH(),map.getHEIGHT());
        defender.createShip(map.root,map.getWIDTH(),map.getHEIGHT());
        map.initializeControls(defender.defender,map.scene,map.root,map.getWIDTH(),defShots,defender);
        stage.setScene(map.scene);
        stage.show();
        AnimationTimer animator = new AnimationTimer(){
            @Override
            public void handle(long arg0) {
                score.setScore(map.getWIDTH(),map.root);
                alien.moveAliens(map.getWIDTH());
                alienS.makeShots(map.root,alien.aliens,alien);
                alienS.moveShots(defender.defender,defender,map.getWIDTH());
                defShots.moveShots();
                defShots.checkShots(map.root,alien,score);
                alien.checkGame();
            }
        };

        animator.start();

    };

}