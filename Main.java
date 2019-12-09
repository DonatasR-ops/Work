package com.company;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application {
   public int WIDTH = 400;
   public int HEIGHT = 400;
   Text text=new Text();


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Space Invaders");
        Group root = new Group();
        Scene scene = new Scene(root, WIDTH, HEIGHT);

        Aliens alien= new Aliens();
        alienShots alienS=new alienShots();
        defenderShots defShots=new defenderShots();
        Defender defender=new Defender();
        Controlls controlls=new Controlls();
        Score score=new Score();
        alien.createAliens(root,WIDTH);
        defender.createDefender(root);
        controlls.initializeControls(defender.defender,scene,root,WIDTH,defShots);
        stage.setScene(scene);
        stage.show();
        AnimationTimer animator = new AnimationTimer(){
            @Override
            public void handle(long arg0) {
                score.setScore(WIDTH,root);
                alien.moveAliens();
                alienS.makeShots(root,alien.aliens,alien);
                alienS.moveAlienShots(defender.defender,HEIGHT);
                defShots.moveShots();
                defShots.chechShots(root,alien,score);
                alien.checkGame();
            }
        };

        animator.start();

    };

}