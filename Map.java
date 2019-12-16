package com.company;

import javafx.scene.Group;
import javafx.scene.Scene;

public class Map extends Controlls{
    private int WIDTH;
    private int HEIGHT;
    public Group root = new Group();
    public Scene scene;

    public Map(int WIDTH, int HEIGHT) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
    }

    public void initializeScene(){
        scene = new Scene(root, WIDTH, HEIGHT);
    }

    public int getWIDTH() {
        return WIDTH;
    }
    public int getHEIGHT(){return HEIGHT;}
}
