package com.company;
import com.company.Defender;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class defenderShots {

   public int amountOfShots;
   public boolean powerUp=false;
   public ArrayList<Rectangle> shots = new ArrayList();
   Main main=new Main();

   public void createShot(Rectangle defender, Group root){

           Rectangle shot = new Rectangle();
           shot.setX(defender.getX());
           shot.setY(defender.getY() - 30);
           shot.setHeight(10);
           shot.setWidth(1);
           shot.setFill(Color.GREEN);
           shots.add(shot);
           amountOfShots++;
           root.getChildren().add(shot);

   }

   public void moveShots(){

       if(amountOfShots!=0){
           for(int i=0; i<amountOfShots;i++){
               shots.get(i).setY(shots.get(i).getY()-1);
           }}
   }

    public void chechShots(Group root,Aliens alien,Score score){
        for (int i=0; i<alien.numberOfAliens; i++) {
            for(int y=0 ;y<amountOfShots; y++){
                if(shots.get(y).getX()>=alien.aliens.get(i).getX() && shots.get(y).getX()<=alien.aliens.get(i).getX()+20 && shots.get(y).getY()>=alien.aliens.get(i).getY() && shots.get(y).getY()<=alien.aliens.get(i).getY()+30) {
                    if(alien.aliens.get(i).getFill().equals(Color.PURPLE)){
                        powerUp=true;
                    }
                    root.getChildren().remove(alien.aliens.get(i));
                    root.getChildren().remove(shots.get(y));
                    alien.aliens.remove(i);
                    alien.checkAlien[i]=0;
                    shots.remove(y);
                    amountOfShots--;
                    alien.numberOfAliens--;
                    if(powerUp==false){
                        score.score=score.score+10;}
                    else {
                        score.score=score.score+20;
                    }
                }
                else if(shots.get(y).getY()==1 && amountOfShots!=0){
                    root.getChildren().remove(shots.get(y));
                    shots.remove(y);
                    amountOfShots--;
                }
            }
        }
    }
}
