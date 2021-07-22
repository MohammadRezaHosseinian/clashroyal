package code.heros;

/*
 **
 * this class create giant hero
 **
 */

import javafx.scene.image.Image;

public class GiantHero extends BaseHero implements Walkable {

    public GiantHero(Image img, Position position,Team team) {
        super(img, position,new Dimension(90,100),2000, team, 0,0, 1.5,126);
    }

    @Override
    public void updatePos() {
        walk();
    }

    @Override
    public void walk() {
        if (destination == null)
            return;
        double x = position.getX();
        double y = position.getY();
        this.position.setX(x + sign(destination.getX() - x));
        this.position.setY(y + sign(destination.getY() - y));
    }

    public int sign(double i) {
        if (i < 0)
            return -1;
        if (i > 0)
            return 1;
        return 0;
    }

    @Override
    public boolean canTrackable(ScreenObject enemy){
        return false;
    }



}
