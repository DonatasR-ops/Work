package com.company;

import javafx.scene.Group;
import javafx.scene.text.Text;

public class Score {
    public int score;
    Text text=new Text();

    public void setScore(int WIDTH, Group root){
        text.setText("Score : "+score);
        text.setX(WIDTH-60);
        text.setY(10);
        root.getChildren().remove(text);
        text.setText("Score : "+score);
        root.getChildren().add(text);
    }


}
