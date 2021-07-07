package code.card;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

import java.net.URI;

public class Fire_ball extends Spell{

    private int Cost=0;
    private double radius;

    public Fire_ball(int cost, URI img, URI sound, double radius) {
        super(cost, img, sound, radius);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public void playCard() {
//    @FXML
//    void Ball_Shooting(MouseEvent e) {
//
//        Circle newCircle = new Circle(e.getX(), e.getY(),fire_ball.getRadius());
//        drawingAreaPane.getChildren().add(newCircle);
//        System.out.println(e.getX());
//        System.out.println(e.getY());
//    }

    }

    @Override
    public void upgradeCard() {

    }






}
