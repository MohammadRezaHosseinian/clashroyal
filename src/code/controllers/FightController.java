package code.controllers;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
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
    }
}
