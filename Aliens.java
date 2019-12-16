package com.company;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Aliens extends Ship {
    private int spawnStartingPointX=shipWidth*3;
    private int spawnStartingPointY=0;
    private int side = 0;
    public int numberOfAliens;
    public ArrayList<Rectangle> aliens = new ArrayList<>();
    public int[] checkAlien;

    public Aliens(int shipWidth, int shipHeight,int numberOfAliens) {
        super(shipWidth, shipHeight);
        this.numberOfAliens=numberOfAliens;
    }

    public void createShip(Group root, int WIDTH,int HEIGHT ) {
        int superAlien = ThreadLocalRandom.current().nextInt(0, numberOfAliens);
        checkAlien = new int[numberOfAliens];
        for (int i = 0; i < numberOfAliens; i++) {

            Rectangle alien = new Rectangle();
            if (i == superAlien) {
                alien.setFill(Color.PURPLE);
            } else {
                alien.setFill(Color.BLACK);
            }
            if ((spawnStartingPointX + shipWidth) >= WIDTH) {
                spawnStartingPointY += shipHeight*2;
                spawnStartingPointX = shipWidth*3;
            }
            alien.setX(spawnStartingPointX += shipWidth*2);
            alien.setY(shipHeight + spawnStartingPointY);
            alien.setHeight(shipHeight);
            alien.setWidth(shipWidth);
            aliens.add(alien);
            checkAlien[i] = 1;
            root.getChildren().add(alien);
        }
    }

    public void moveAliens(int mapWidth) {
        if(checkGame()==true){
            System.exit(0);
        }
        for (int i = 0; i < numberOfAliens; i++) {
            if (aliens.get(i).getX() != 0 && side == 0) {
                aliens.get(i).setX(aliens.get(i).getX() - 1);
                if (aliens.get(i).getX() == 0) {
                    side = 1;
                }
            }
            if (aliens.get(i).getX() != mapWidth-shipWidth && side == 1) {
                aliens.get(i).setX(aliens.get(i).getX() + 1);
                if (aliens.get(i).getX() == mapWidth-shipWidth) {
                    side = 0;
                }
            }
        }
    }
    public boolean checkGame(){
        if(numberOfAliens==0 ){
            return true;
        }
        return false;
    }

}