package code.heros;

import javafx.scene.image.Image;

public class MiniPEKKAHero extends BaseHero implements Walkable{

    public MiniPEKKAHero(Image img, Position position, Team team) {
        super(img, position, new Dimension(30,30),600, team, 1, 1, 1.8,325);
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
    public int sign(double i){
        if(i < 0)
            return -1;
        if(i > 0)
            return 1;
        return 0;
    }
}
