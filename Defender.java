package com.company;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Defender {
    private int spawnStartingPointX=190;
    private int spawnStartingPointY=370;
    public Rectangle defender= new Rectangle();

    public void createDefender(Group root){
        defender.setX(spawnStartingPointX);
        defender.setY(spawnStartingPointY);
        defender.setHeight(20);
        defender.setWidth(20);
        defender.setFill(Color.BLUE);
        root.getChildren().add(defender);
    }
}
