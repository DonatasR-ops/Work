package com.company;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class alienShots {
    public ArrayList<Rectangle> alienShots=new ArrayList<>();
    public int amountOfShotsFired;




    public void makeShots(Group root,ArrayList<Rectangle> aliens,Aliens alien){
        for (int i=0; i<alien.numberOfAliens; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, 0+500);
                    if(randomNum==25 && i>((alien.numberOfAliens-7))){
                        Rectangle shot = new Rectangle();
                        shot.setX(aliens.get(i).getX());
                        shot.setY(aliens.get(i).getY()+30);
                        shot.setHeight(5);
                        shot.setWidth(5);
                        shot.setFill(Color.RED);
                        root.getChildren().add(shot);
                        alienShots.add(shot);
                        amountOfShotsFired++;
                    }
                    else if(randomNum==25 && alien.checkAlien[i+6]==0 ){
                        Rectangle shot = new Rectangle();
                        shot.setX(aliens.get(i).getX());
                        shot.setY(aliens.get(i).getY()+30);
                        shot.setHeight(5);
                        shot.setWidth(5);
                        shot.setFill(Color.RED);
                        alienShots.add(shot);
                        root.getChildren().add(shot);
                        amountOfShotsFired++;
                    }
        }

    }

    public void moveAlienShots(Rectangle defender,int HEIGHT){
        if(amountOfShotsFired>0){
            for(int i=0; i<amountOfShotsFired;i++){
                if(defender.getX()-4<=alienShots.get(i).getX() && defender.getX()+20>=alienShots.get(i).getX() && defender.getY()-4<=alienShots.get(i).getY() &&defender.getY()+20>=alienShots.get(i).getY()){
                    System.exit(0);
                }
                if(alienShots.get(i).getY()> HEIGHT){
                    alienShots.remove(i);
                    amountOfShotsFired--;
                }
                alienShots.get(i).setY(alienShots.get(i).getY() + 1);

            }
        }
            }

            public void checkAlienShots(){

            }
}
