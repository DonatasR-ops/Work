package com.company;

import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import org.junit.Test;


import static org.junit.Assert.*;

public class AliensTest {
    Group root=new Group();
    Aliens aliens=new Aliens(20,20,2);
    @Test
    public void checkIfDefenderCreatesShots() {

        Rectangle defe = new Rectangle();
        defenderShots shots=new defenderShots();
        shots.createShot(defe,root);
        assertEquals(1,shots.amountOfShots);
    }

    @Test
    public void checkIfGameClosesWhenThereIsNoAliens() {

        aliens.numberOfAliens=0;
        assertTrue(aliens.checkGame());
    }

    @Test
    public void checkIfRandomNumberGenerateAlienShotsCorrectly(){
        alienShots shots=new alienShots();
        shots.makeShots(root,aliens.aliens,aliens);
        assertEquals(shots.amountOfShotsFired,shots.alienShots.size());

    }



}