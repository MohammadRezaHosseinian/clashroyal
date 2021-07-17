package code.controllers;

import code.card.Speed;
import code.heros.MyHero;
import code.heros.Position;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.util.Duration;

public class FightController {
    @FXML
    public Canvas board;
    public AnchorPane parent;
    public Pane pane;
    public ImageView img;
    private BoardHandler bHandler;


    @FXML
    public void initialize() {

        BackgroundImage bi = new BackgroundImage(new Image("res//drawable//back.jpg"),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT
        );
        this.parent.setBackground(new Background(bi));
        this.bHandler = new BoardHandler(this.board);
        bHandler.initBoard();
        this.board.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try{
                    ImageView img2;
                    img2 = new ImageView();
                    img2.setFitWidth(25);
                    img2.setFitHeight(25);
                    img2.setImage(new Image("res//drawable//hero.png"));
                    img2.setVisible(true);
                    img2.setX(mouseEvent.getX());
                    img2.setY(mouseEvent.getY());
                    pane.getChildren().add(img2);

//                System.out.println(String.format("x : %f\ny:%f",mouseEvent.getX(), mouseEvent.getY()));
                    MyHero hero = new MyHero(img2,100,new Position(mouseEvent.getX(), mouseEvent.getY()), Speed.FAST);
                    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0),
                            actionEvent -> hero.changePos()),
                            new KeyFrame(Duration.millis(1)));
                    timeline.setCycleCount(Timeline.INDEFINITE);
                    timeline.play();
                    new Thread(hero).start();
                }
                catch (Exception ex){};
            }
        });
    }
}
