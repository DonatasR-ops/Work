package com.company;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Defender extends Ship{
    private int spawnStartingPointX;
    private int spawnStartingPointY;
    public Rectangle defender= new Rectangle();

    public Defender(int shipWidth, int shipHeight) {
        super(shipWidth, shipHeight);
    }

    public void createShip(Group root,int Width, int Height){
        spawnStartingPointX=(Width/2)-(shipWidth/2);
        spawnStartingPointY=Height-(shipHeight*2);
        defender.setX(spawnStartingPointX);
        defender.setY(spawnStartingPointY);
        defender.setHeight(shipHeight);
        defender.setWidth(shipWidth);
        defender.setFill(Color.BLUE);
        root.getChildren().add(defender);
    }

    
}
