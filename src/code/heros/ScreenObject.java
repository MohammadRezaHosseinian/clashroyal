package code.heros;

/*
 **
 * this class create screenObject
 **
 */
import code.castles.BaseCastle;
import javafx.scene.canvas.GraphicsContext;

public interface ScreenObject {
    public void draw(GraphicsContext g);
    public Team getTeam();
    public void setDestination(Position pos);
    public void updatePos();
    public boolean isAlive();
    public Position getCurrentPos();
    public boolean canTrackable(ScreenObject enemy);
    public State getState();
    public double getDamagePerSec();
    public void decreaseHp(double enemyDamage);
    public void setState(State s);
    public boolean canTrackableCastle(BaseCastle enemy);
}
