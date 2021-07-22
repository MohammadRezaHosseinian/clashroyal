package code.card;

import java.net.URI;

/*
 **
 * this class for create Rage card
 * *
 */
public class Rage extends Spell{

    private double radius = 0;

    public Rage(int cost, URI sound, double radius) {
        super(cost, "res//drawable//spellCard.png", sound);
        this.radius = radius;
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
