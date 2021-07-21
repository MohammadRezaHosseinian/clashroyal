package code.card;

import java.net.URI;

public class Arrows extends Spell{

    private double radius = 0;

    public Arrows(int cost, URI sound, double radius) {
        super(cost, "res//drawable//arrowCard.png", sound);
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
    public void upgradeCard(Level l) {

    }


}
