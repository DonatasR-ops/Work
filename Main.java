package com.company;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


public class Main extends Application {
    int WIDTH = 400;
    int HEIGHT = 400;
    int side=0;
    int sh=0;
    int sh1=0;
    int numberAliens=5;
    Rectangle defender= new Rectangle();
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Space Invaders");
        Group root = new Group();
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        defender.setX(190);
        defender.setY(370);
        defender.setHeight(20);
        defender.setWidth(20);
        defender.setFill(Color.BLUE);
        ArrayList<Rectangle> alienShots=new ArrayList<>();
        ArrayList<Rectangle> aliens = new ArrayList();
        for (int i=0; i<numberAliens; i++) {
            Rectangle alien = new Rectangle();
            alien.setX(100 + 50 * i);
            alien.setY(20);
            alien.setHeight(20);
            alien.setWidth(20);
            aliens.add(alien);
            root.getChildren().add(alien);
        }
        root.getChildren().add(defender);
        ArrayList<Rectangle> shots = new ArrayList();

        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case LEFT:
                    if(defender.getX()!=0) {
                        defender.setX(defender.getX() - 5);
                    }
                    break;
                case RIGHT:
                    if(defender.getX()!=WIDTH-20) {
                        defender.setX(defender.getX() + 5);
                    }
                    break;
                case UP:
                    Rectangle shot = new Rectangle();
                    shot.setX(defender.getX());
                    shot.setY(defender.getY()-30);
                    shot.setHeight(5);
                    shot.setWidth(5);
                    shot.setFill(Color.GREEN);
                    shots.add(shot);
                    sh++;
                    root.getChildren().add(shot);


            }
        });
        stage.setScene(scene);

        stage.show();
        AnimationTimer animator = new AnimationTimer(){

            @Override
            public void handle(long arg0) {

                for (int i=0; i<numberAliens; i++) {
                    if (aliens.get(i).getX() != 0 && side == 0) {
                        aliens.get(i).setX(aliens.get(i).getX() - 1);
                        if (aliens.get(i).getX() == 1) {
                            side = 1;
                        }
                    }
                    if (aliens.get(i).getX() != 380 && side == 1) {
                        aliens.get(i).setX(aliens.get(i).getX() + 1);
                        if (aliens.get(i).getX() == 380) {
                            side = 0;
                        }
                    }
                    int randomNum = ThreadLocalRandom.current().nextInt(0, 0+500);
                    if(randomNum==25 ){
                        Rectangle shot = new Rectangle();
                        shot.setX(aliens.get(i).getX());
                        shot.setY(aliens.get(i).getY()+30);
                        shot.setHeight(5);
                        shot.setWidth(5);
                        shot.setFill(Color.RED);
                        alienShots.add(shot);
                        root.getChildren().add(shot);
                        sh1++;
                    }
                }
                for (int i=0; i<numberAliens; i++) {
                    for(int y=0 ;y<sh; y++){
                        System.out.println(aliens.get(i)+" "+shots.get(y));
                        if(aliens.get(i).getX()-10<=shots.get(y).getX() && aliens.get(i).getX()+10>=shots.get(y).getX() && aliens.get(i).getY()-10>=shots.get(y).getY() ){
                            root.getChildren().remove(aliens.get(i));
                            root.getChildren().remove(shots.get(y));
                            aliens.remove(i);
                            shots.remove(y);
                            sh--;
                            numberAliens--;
                        }
                        else if(shots.get(y).getY()==1 && sh!=0){
                            root.getChildren().remove(shots.get(y));
                            shots.remove(y);
                            sh--;
                        }
                    }
                }

                if(sh!=0){
                for(int i=0; i<sh;i++){
                    shots.get(i).setY(shots.get(i).getY()-1);
                }}
                if(sh1!=0){
                    for(int i=0; i<sh1;i++){
                        System.out.println(defender.getX()+" "+defender.getY()+" "+alienShots.get(i));
                        if(defender.getX()-10<=alienShots.get(i).getX() && defender.getX()+10>=alienShots.get(i).getX() && defender.getY()+10<=alienShots.get(i).getY() ){
                            stage.close();
                        }
                            alienShots.get(i).setY(alienShots.get(i).getY() + 1);

                    }}

                if(numberAliens==0 ){
                    stage.close();
                }


            }
        };

        animator.start();

    };



}
