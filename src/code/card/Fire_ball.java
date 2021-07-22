package code.card;

/*
 **
 * this class for create FireBall card
 * *
 */
import java.net.URI;

public class Fire_ball extends Spell{

    private int Cost=0;
    private double radius;

    public Fire_ball(int cost, URI sound, double radius) {
        super(cost, "res//drawable//fireCard.png", sound);
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
