package code.heros;

/*
 **
 * this class create hero
 **
 */
import javafx.scene.image.Image;

public class MyHero extends BaseHero implements  Walkable{
    public MyHero(Image img, Position position, Dimension dimension, int hp, Team team, int range) {
        super(img, position, dimension, hp, team, range, .5, 1.8, 20);
    }

    @Override
    public void updatePos() {
        walk();
//        walk();
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

    public int sign(double i){
        if(i < 0)
            return -1;
        if(i > 0)
            return 1;
        return 0;
    }
}
