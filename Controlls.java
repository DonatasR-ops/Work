package com.company;

import javafx.scene.Group;
import javafx.scene.Scene;
import com.company.*;
import java.awt.*;
import java.util.ArrayList;
import javafx.scene.shape.Rectangle;

public class Controlls {
    private long end=0;

    public void initializeControls( Rectangle defender,Scene scene, Group root, int WIDTH,defenderShots defShots){

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
                    long start = System.currentTimeMillis();
                    if(defShots.amountOfShots==0) {
                        defShots.createShot(defender,root);

                    }
                    else if(defShots.powerUp==true && end==0 || defShots.powerUp==true && start>=end+1000){
                        end= System.currentTimeMillis();
                        defShots.createShot(defender,root);

                    }
            }
        });
    }
}
