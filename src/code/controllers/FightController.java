package code.controllers;

import code.heros.Dimension;
import code.heros.MyHero;
import code.heros.Position;
import code.heros.Team;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

public class FightController {
    @FXML
    public Canvas board;
    public AnchorPane parent;
    public Pane pane;
    public ImageView img;
    private BoardHandler bHandler;
    private GameManager manger;


    @FXML
    public void initialize() {

        BackgroundImage bi = new BackgroundImage(new Image("res//drawable//back.jpg"),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT
        );
        this.parent.setBackground(new Background(bi));
        this.bHandler = new BoardHandler(this.board);
        this.manger = new GameManager(board.getGraphicsContext2D(),bHandler);
        new Thread(manger).start();
        this.board.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                MyHero hero = new MyHero(
                        new Image("res//drawable//hero.png"),
                        new Position(mouseEvent.getX(), mouseEvent.getY()),
                        new Dimension(50,50),
                        100,
                        Team.UP_SIDE_TEAM
                );
                manger.addElement(hero);

            }
        });
    }
}
