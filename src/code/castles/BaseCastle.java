package code.castles;

import code.heros.Dimension;
import code.heros.Position;
import code.heros.ScreenObject;
import code.heros.Team;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class BaseCastle {

    protected Team team;
    protected Position pos;
    protected int hp;
    protected int range;
    protected int damage;
    protected double hitSpeed;
    protected Image img;
    protected Dimension dim;
    protected int initialHp;

    public BaseCastle(Image img, Team team, Position pos, Dimension dim, int hp, int range, int damage, double hitSpeed){
        this.team = team;
        this.pos = pos;
        this.hp = hp;
        this.range = range;
        this.damage = damage;
        this.hitSpeed = hitSpeed;
        this.img = img;
        this.dim = dim;
        this.initialHp = hp;
    }

    public Team getTeam(){
        return this.team;
    }

    public void draw(GraphicsContext g){
        g.drawImage(img, pos.getX(), pos.getY(), dim.getWidth(), dim.getHeight());
    }

    public boolean isAlive(){
        return this.hp > 0;
    }

    public boolean canShootEnemy(ScreenObject enemy){
        if(this.hp == this.initialHp)
            return false;

        return getDistance(enemy) < this.range;
    }

    public double getDamagePerSec(){
        return this.damage * this.hitSpeed;
    }

    public double getDistance(ScreenObject obj){
        double dx = this.pos.getX() - obj.getCurrentPos().getX();
        double dy = this.pos.getY() - obj.getCurrentPos().getY();

        return Math.sqrt(dx*dx + dy*dy);
    }

    public void decreaseHp(double d){
        this.hp -= d;
    }

    public Position getPos(){
        return this.pos;
    }
}
