package code.controllers;

import code.heros.Position;
import code.heros.ScreenObject;
import code.heros.Team;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class GameManager implements Runnable{
    private final ArrayList<ScreenObject> elements;
    private final GraphicsContext graphics;
    private final BoardHandler handler;
    private final Position[] DOWN_LEFT_PLAYER_ROADS;
    private final Position[] DOWN_RIGHT_PLAYER_ROADS;
    private final Position[] UP_LEFT_PLAYER_ROADS;
    private final Position[] UP_RIGHT_PLAYER_ROADS;

    public GameManager(GraphicsContext g, BoardHandler b){
        this.graphics = g;
        this.elements = new ArrayList<>();
        this.handler = b;
        this.DOWN_LEFT_PLAYER_ROADS = new Position[]{
                handler.getLeftDownSideBridgePos(),
                handler.getLeftUpSideBridgePos(),
                handler.getLeftUpSideCastlePos(),
                handler.getUpSideKingCastlePos()
        };
        this.DOWN_RIGHT_PLAYER_ROADS = new Position[]{
                handler.getRightDownSideBridgePos(),
                handler.getRightUpSideBridgePos(),
                handler.getRightUpSideCastlePos(),
                handler.getUpSideKingCastlePos()
        };

        this.UP_LEFT_PLAYER_ROADS = new Position[]{
                handler.getLeftUpSideBridgePos(),
                handler.getLeftDownSideBridgePos(),
                handler.getLeftDownSideCastlePos(),
                handler.getDownSideKingCastlePos()
        };
        this.UP_RIGHT_PLAYER_ROADS = new Position[]{
                handler.getRightUpSideBridgePos(),
                handler.getRightDownSideBridgePos(),
                handler.getRightDownSideCastlePos(),
                handler.getDownSideKingCastlePos()
        };
    }

    public synchronized void addElement(ScreenObject element){
        this.elements.add(element);
    }

    public synchronized void removeElement(ScreenObject element){
        this.elements.remove(element);
    }

    @Override
    public void run() {

        while (true) {
            checkElementsIsAlive();
            drawElements();
            checkConflicts();
            setDestinationElements();
            updateElementsPos();
            try {
                Thread.sleep(60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void checkElementsIsAlive() {
        ScreenObject obj;
        for(int i=0; i< elements.size(); i++){
            obj = elements.get(i);
            if(!obj.isAlive())
                this.elements.remove(obj);
        }
    }

    private synchronized void updateElementsPos() {
        for(ScreenObject obj : this.elements){
            obj.updatePos();
        }
    }

    private synchronized void setDestinationElements() {
        for(ScreenObject obj : this.elements){
            obj.setDestination(findRoad(obj));

        }
    }

    private void checkConflicts() {
    }

    private synchronized void drawElements() {
        try {
            handler.drawBase();
            for(ScreenObject element : this.elements){
                element.draw(this.graphics);
            }
        }
        catch (Exception ex){
            System.out.println("ooops");
        }

    }

    public Position findRoad(ScreenObject obj){
        if(obj.getTeam().equals(Team.DOWN_SIDE_TEAM))
            return downSidePlayerFindRoad(obj);
        return upSidePlayerFindRoad(obj);
    }

    private Position upSidePlayerFindRoad(ScreenObject obj) {
        if(obj.getCurrentPos().getX() < handler.getCANVAS_WIDTH()/2)
            return upLeftSidePlayerFindRoad(obj);
        return upRightSidePlayerFindRoad(obj);
    }

    private Position upRightSidePlayerFindRoad(ScreenObject obj) {
        Position current = obj.getCurrentPos() ;
        if(current.getY() <= this.UP_RIGHT_PLAYER_ROADS[0].getY())
            return UP_RIGHT_PLAYER_ROADS[0];
        if(current.getY() < this.UP_RIGHT_PLAYER_ROADS[1].getY())
            return UP_RIGHT_PLAYER_ROADS[1];

        if(current.getY() < this.UP_RIGHT_PLAYER_ROADS[2].getY())
            return UP_RIGHT_PLAYER_ROADS[2];
        return UP_RIGHT_PLAYER_ROADS[3];
    }

    private Position upLeftSidePlayerFindRoad(ScreenObject obj) {
        Position current = obj.getCurrentPos();
        if(current.getY() < this.UP_LEFT_PLAYER_ROADS[0].getY())
            return UP_LEFT_PLAYER_ROADS[0];
        if(current.getY() < this.UP_LEFT_PLAYER_ROADS[1].getY())
            return UP_LEFT_PLAYER_ROADS[1];
        if(current.getY() < this.UP_LEFT_PLAYER_ROADS[2].getY())
            return UP_LEFT_PLAYER_ROADS[2];
        return UP_LEFT_PLAYER_ROADS[3];
    }

    private Position downSidePlayerFindRoad(ScreenObject obj) {
        if(obj.getCurrentPos().getX() < handler.getCANVAS_WIDTH()/2)
            return downLeftSidePlayerFindRoad(obj);
        return downRightSidePlayerFindRoad(obj);
    }

    private Position downRightSidePlayerFindRoad(ScreenObject obj) {
        Position current = obj.getCurrentPos() ;
        if(current.getY() >= this.DOWN_RIGHT_PLAYER_ROADS[0].getY())
            return DOWN_RIGHT_PLAYER_ROADS[0];
        if(current.getY() > this.DOWN_RIGHT_PLAYER_ROADS[1].getY())
            return DOWN_RIGHT_PLAYER_ROADS[1];

        if(current.getY() > this.DOWN_RIGHT_PLAYER_ROADS[2].getY())
            return DOWN_RIGHT_PLAYER_ROADS[2];
        return DOWN_RIGHT_PLAYER_ROADS[3];

    }

    private Position downLeftSidePlayerFindRoad(ScreenObject obj) {
        Position current = obj.getCurrentPos();
        if(current.getY()  > this.DOWN_LEFT_PLAYER_ROADS[0].getY())
            return DOWN_LEFT_PLAYER_ROADS[0];
        if(current.getY() > this.DOWN_LEFT_PLAYER_ROADS[1].getY())
            return DOWN_LEFT_PLAYER_ROADS[1];
        if(current.getY() > this.DOWN_LEFT_PLAYER_ROADS[2].getY())
            return DOWN_LEFT_PLAYER_ROADS[2];
        return DOWN_LEFT_PLAYER_ROADS[3];
    }
}
