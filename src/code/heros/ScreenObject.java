package code.heros;

import javafx.scene.canvas.GraphicsContext;

public interface ScreenObject {
    public void draw(GraphicsContext g);
    public Team getTeam();
    public void setDestination(Position pos);
    public void updatePos();
    public boolean isAlive();
    public Position getCurrentPos();
}
