package code.heros;

/*
 **
 * this class create barbariance hero
 **
 */
import javafx.scene.image.Image;

public class BarbarianceHero extends BaseHero implements Walkable{
    public BarbarianceHero(Image img, Position pos, Team team) {
        super(img, pos, new Dimension(40,60), 300, team, 1, .5, 1.5, 75);
    }

    @Override
    public void updatePos() {
        walk();
    }

    @Override
    public void setDestination(Position d)
    {
        if(state.equals(State.FIGHTING_ENEMY)) {
            this.destination = this.getCurrentPos();
        }
        else
            this.destination = d;
    }

    @Override
    public void walk() {
        if(destination == null)
            return;
        double x = position.getX();
        double y = position.getY();
        this.position.setX(x + sign(destination.getX() - x));
        this.position.setY(y + sign(destination.getY() - y));
    }
    public double sign(double i){
        if(i < 0)
            return - .5;
        if(i > 0)
            return .5;
        return 0;

    }
}
