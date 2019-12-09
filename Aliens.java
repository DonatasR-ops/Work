package com.company;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Aliens {
    private int spawnStartingPointX=100;
    private int spawnStartingPointY=0;
    private int gapSize = 20;
    private int side = 0;
    public int numberOfAliens=12;
    public ArrayList<Rectangle> aliens = new ArrayList<>();
    public int[] checkAlien;


    public void createAliens(  Group root, int WIDTH) {
        int superAlien = ThreadLocalRandom.current().nextInt(0, numberOfAliens);
        checkAlien = new int[numberOfAliens];
        for (int i = 0; i < numberOfAliens; i++) {

            Rectangle alien = new Rectangle();
            if (i == superAlien) {
                alien.setFill(Color.PURPLE);
            } else {
                alien.setFill(Color.BLACK);
            }
            if ((spawnStartingPointX + gapSize) >= WIDTH) {
                spawnStartingPointY += 40;
                spawnStartingPointX = 100;
            }
            alien.setX(spawnStartingPointX += 50);
            alien.setY(20 + spawnStartingPointY);
            alien.setHeight(20);
            alien.setWidth(20);
            aliens.add(alien);
            checkAlien[i] = 1;
            root.getChildren().add(alien);
        }
    }

    public void moveAliens() {
        for (int i = 0; i < numberOfAliens; i++) {
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
        }
    }
    public void checkGame(){
        if(numberOfAliens==0 ){
            System.exit(0);
        }
    }

}