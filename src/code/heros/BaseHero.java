package code.heros;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class BaseHero implements ScreenObject {

    private Image img;
    protected Position position;
    protected int hp;
    protected Dimension dimension;
    protected Position destination;
    protected Team team;

    public BaseHero(Image img, Position position, Dimension dimension, int hp, Team team){
        this.img = img;
        this.position = position;
        this.dimension = dimension;
        this.hp = hp;
        this.team = team;
    }

    public boolean isAlive(){
        return this.hp > 0;
    }

    @Override
    public void draw(GraphicsContext g) {
        g.drawImage(this.img,
                position.getX(),
                position.getY(),
                dimension.getWidth(),
                dimension.getHeight()
        );
    }

    @Override
    public Team getTeam() {
        return team;
    }

    public void setDestination(Position d){
        this.destination = d;
    }

    @Override
    public abstract void updatePos();

    @Override
    public Position getCurrentPos() {
        return this.position;
    }
}
