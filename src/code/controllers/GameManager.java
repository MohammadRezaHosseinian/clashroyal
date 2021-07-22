package code.controllers;

/*
 **
 * this class for manage the game
 * this class implement runnable
 **
 */

import code.castles.BaseCastle;
import code.castles.KingCastle;
import code.castles.QueenCastle;
import code.heros.Position;
import code.heros.ScreenObject;
import code.heros.State;
import code.heros.Team;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import java.util.ArrayList;

public class GameManager implements Runnable{
    private final ArrayList<ScreenObject> elements;
    private final GraphicsContext graphics;
    private final BoardHandler handler;
    private final Position[] DOWN_LEFT_PLAYER_ROADS;
    private final Position[] DOWN_RIGHT_PLAYER_ROADS;
    private final Position[] UP_LEFT_PLAYER_ROADS;
    private final Position[] UP_RIGHT_PLAYER_ROADS;
    private final long SLEEP_TIME_PER_MILI_SECOND = 50;
    private final ArrayList<BaseCastle> castles;
    private  BaseCastle upSideKingCastle;
    private  BaseCastle downSideKingCastle;
    private  BaseCastle upSideLeftQueenCastle;
    private  BaseCastle upSideRightQueenCastle;
    private  BaseCastle downSideLeftQueenCastle;
    private  BaseCastle downSideRightQueenCastle;
    private Button playAgain;

    public GameManager(GraphicsContext g, BoardHandler b, Button btn){
        this.graphics = g;
        this.elements = new ArrayList<>();
        this.castles = new ArrayList<>();
        this.handler = b;
        initCastles();
        this.playAgain = btn;
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

    private void initCastles() {
        KingCastle upSideKing = new KingCastle(
                new Image("res//drawable//tower5.png"),
                Team.UP_SIDE_TEAM,
                handler.getUpSideKingCastlePos()
        );
        QueenCastle rightUpQueen = new QueenCastle(
                new Image("res//drawable//tower6.png"),
                Team.UP_SIDE_TEAM,
                handler.getRightUpSideCastlePos()
        );
        QueenCastle leftUpQueen = new QueenCastle(
                new Image("res//drawable//tower6.png"),
                Team.UP_SIDE_TEAM,
                handler.getLeftUpSideCastlePos()
        );

        KingCastle downKing = new KingCastle(
                new Image("res//drawable//tower4.png"),
                Team.DOWN_SIDE_TEAM,
                handler.getDownSideKingCastlePos()
        );
        QueenCastle rightDownQueen = new QueenCastle(
          new Image("res//drawable//tower7.png"),
                Team.DOWN_SIDE_TEAM,
                handler.getRightDownSideCastlePos()
        );
        QueenCastle leftDownQueen = new QueenCastle(
          new Image("res//drawable//tower7.png"),
          Team.DOWN_SIDE_TEAM,
          handler.getLeftDownSideCastlePos()
        );

        this.castles.add(upSideKing);
        this.castles.add(rightUpQueen);
        this.castles.add(leftUpQueen);
        this.castles.add(downKing);
        this.castles.add(rightDownQueen);
        this.castles.add(leftDownQueen);

        this.upSideKingCastle = upSideKing;
        this.upSideLeftQueenCastle = leftUpQueen;
        this.upSideRightQueenCastle = rightUpQueen;
        this.downSideKingCastle = downKing;
        this.downSideLeftQueenCastle = leftDownQueen;
        this.downSideRightQueenCastle = rightDownQueen;
    }

    public synchronized void addElement(ScreenObject element){
        this.elements.add(element);
    }

    public synchronized void removeElement(ScreenObject element){
        this.elements.remove(element);
    }

    @Override
    public void run() {

        while (upSideKingCastle.isAlive() && downSideKingCastle.isAlive())  {
            checkElementsIsAlive();
            drawElements();
            checkConflicts();
            setDestinationElements();
            updateElementsPos();
            try {
                Thread.sleep(SLEEP_TIME_PER_MILI_SECOND);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        finalizeGame();

    }

    private void finalizeGame() {
        checkElementsIsAlive();
        drawElements();
        System.out.println(getWinner().toString());
        int destroiedCastles = 3;
        for(BaseCastle c : castles){
            if(c.getTeam().equals(Team.UP_SIDE_TEAM)) {
                destroiedCastles--;
            }
        }
        Image img;
        if(getWinner().equals(Team.DOWN_SIDE_TEAM)){
            img = new Image("res//drawable//star3.png");
        }
        else{
            img = new Image(String.format("res//drawable//star%d.png", destroiedCastles));
        }
        this.graphics.drawImage(img,0,0);
        System.out.println("destroied :" + destroiedCastles);
        this.playAgain.setVisible(true);
    }

    private synchronized void checkElementsIsAlive() {
        ScreenObject obj;
        for(int i = 0; i< elements.size(); i++){
            obj = elements.get(i);
            if(!obj.isAlive())
                this.elements.remove(obj);
        }
        BaseCastle castle;
        for(int i=0; i<castles.size(); i++){
            castle = castles.get(i);
            if(!castle.isAlive())
                this.castles.remove(castle);
        }
    }

    private synchronized void updateElementsPos() {
        for(ScreenObject obj : this.elements){
            obj.updatePos();
        }
    }

    private synchronized void setDestinationElements() {
        for(ScreenObject obj : this.elements){
            setDestOneElement(obj);
        }
    }

    private void setDestOneElement(ScreenObject obj) {
        Team team = obj.getTeam();
        for(ScreenObject enemy : elements){
            if(!enemy.getTeam().equals(team)){
               if(obj.canTrackable(enemy)){
                   obj.setDestination(enemy.getCurrentPos());
                   checkFightElement(obj, enemy);
                   return;
               }
            }
        }
        for(BaseCastle castle: castles){
            if(!castle.getTeam().equals(obj.getTeam())){
                if(obj.canTrackableCastle(castle)){
                    obj.setDestination(castle.getPos());
                    checkFightWithCastle(obj, castle);
                }
            }
        }
        obj.setState(State.WALKING);
        obj.setDestination(findRoad(obj));
    }

    private void checkFightWithCastle(ScreenObject obj, BaseCastle castle) {
        if(castle.canShootEnemy(obj)){
            obj.decreaseHp(castle.getDamagePerSec()* SLEEP_TIME_PER_MILI_SECOND / 1000);
        }
        if(obj.getState() != State.FIGHTING_CASTLE)
            return;
        castle.decreaseHp(obj.getDamagePerSec() * SLEEP_TIME_PER_MILI_SECOND / 1000);
    }

    private void checkFightElement(ScreenObject obj, ScreenObject enemy) {
        State state = obj.getState();
        if(state != State.FIGHTING_ENEMY)
            return;
        enemy.decreaseHp((obj.getDamagePerSec() * SLEEP_TIME_PER_MILI_SECOND) / 1000);
    }

    private void checkConflicts() {
    }

    private synchronized void drawElements() {



        try {
            handler.drawBase();
            for(BaseCastle castle: castles){
                castle.draw(this.graphics);
            }
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

        if(current.getY() < this.UP_RIGHT_PLAYER_ROADS[2].getY() && downSideRightQueenCastle.isAlive())
            return UP_RIGHT_PLAYER_ROADS[2];
        return UP_RIGHT_PLAYER_ROADS[3];
    }

    private Position upLeftSidePlayerFindRoad(ScreenObject obj) {
        Position current = obj.getCurrentPos();
        if(current.getY() < this.UP_LEFT_PLAYER_ROADS[0].getY())
            return UP_LEFT_PLAYER_ROADS[0];
        if(current.getY() < this.UP_LEFT_PLAYER_ROADS[1].getY())
            return UP_LEFT_PLAYER_ROADS[1];
        if(current.getY() < this.UP_LEFT_PLAYER_ROADS[2].getY() && downSideLeftQueenCastle.isAlive())
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
        if(current.getY() > this.DOWN_RIGHT_PLAYER_ROADS[2].getY() && upSideRightQueenCastle.isAlive())
            return DOWN_RIGHT_PLAYER_ROADS[2];
        return DOWN_RIGHT_PLAYER_ROADS[3];

    }

    private Position downLeftSidePlayerFindRoad(ScreenObject obj) {
        Position current = obj.getCurrentPos();
        if(current.getY()  > this.DOWN_LEFT_PLAYER_ROADS[0].getY())
            return DOWN_LEFT_PLAYER_ROADS[0];
        if(current.getY() > this.DOWN_LEFT_PLAYER_ROADS[1].getY())
            return DOWN_LEFT_PLAYER_ROADS[1];
        if(current.getY() > this.DOWN_LEFT_PLAYER_ROADS[2].getY() && upSideLeftQueenCastle.isAlive())
            return DOWN_LEFT_PLAYER_ROADS[2];
        return DOWN_LEFT_PLAYER_ROADS[3];
    }

    public Team getWinner(){
        if(! (this.downSideKingCastle.isAlive() && this.upSideKingCastle.isAlive())) {
            if (!this.downSideKingCastle.isAlive())
                return Team.UP_SIDE_TEAM;
            return Team.DOWN_SIDE_TEAM;
        }
        return null;
    }
}
