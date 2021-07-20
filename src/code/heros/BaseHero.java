package code.heros;

import code.controllers.Defaults;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class BaseHero implements ScreenObject {

    protected State state;
    private Image img;
    protected Position position;
    protected int hp;
    protected Dimension dimension;
    protected Position destination;
    protected Team team;
    protected int range;
    protected double fightingRange;
    protected double hitRate;
    protected int damage;

    public BaseHero(Image img, Position position, Dimension dimension, int hp, Team team, int range, double fightingRange, double hitRate, int damage){
        this.img = img;
        this.position = position;
        this.dimension = dimension;
        this.hp = hp;
        this.team = team;
        this.range = range;
        this.fightingRange = fightingRange;
        this.hitRate = hitRate;
        this.damage = damage;
        this.state = State.WALKING;
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

    @Override
    public boolean canTrackable(ScreenObject enemy){
        double tolerance = Defaults.TILE_WIDTH * 1.9;
        double distanceFromEnemy = getDistanceFromEnemy(enemy);
        boolean returnValue = tolerance * this.range > distanceFromEnemy;
        if(returnValue){
            state = State.TRACKING_ENEMY;
            if(distanceFromEnemy < fightingRange * tolerance) {
                state = State.FIGHTING_ENEMY;
            }
        }
        else{
            state = State.WALKING;
        }
        return returnValue;
    }

    public State getState(){
        return state;
    }

    private double getDistanceFromEnemy(ScreenObject enemy){
        double dx = this.getCurrentPos().getX() - enemy.getCurrentPos().getX();
        double dy = this.getCurrentPos().getY() - enemy.getCurrentPos().getY();

        return Math.sqrt(dx*dx + dy*dy);
    }

    @Override
    public double getDamagePerSec(){
        return damage * hitRate;
    }

    @Override
    public void decreaseHp(double damage){
        this.hp -= damage;
    }

    @Override
    public void setState(State e){
        this.state = e;
    }
}
