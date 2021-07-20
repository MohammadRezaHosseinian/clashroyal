package code.controllers;

import code.card.AbstractBaseCard;
import code.heros.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.util.Duration;

import java.util.ArrayList;

public class FightController {
    @FXML
    public Canvas board;
    public AnchorPane parent;
    public VBox cardsPane;
    @FXML
    public ImageView card_1;
    public ImageView card_2;
    public ImageView card_3;
    public ImageView card_4;
    public ImageView card_5;
    public ImageView card_6;
    public ImageView card_7;
    public ImageView card_8;
    public ImageView cardSel;
    public Label elixirVal;
    private BoardHandler bHandler;
    private GameManager manger;
    private ArrayList<AbstractBaseCard> cards;
    private AbstractBaseCard selectedCard;


    @FXML
    public void initialize() {
        this.cards = ScreenObjectBuilder.getAllCards();
        BackgroundImage bi = new BackgroundImage(new Image("res//drawable//back.jpg"),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT
        );
        this.parent.setBackground(new Background(bi));
        this.bHandler = new BoardHandler(this.board);
        this.manger = new GameManager(board.getGraphicsContext2D(),bHandler);
        this.placementCards();
        new Thread(manger).start();

        GamePlayer player = new GamePlayer(null,manger);
        new Thread(player).start();

        this.board.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                player.chooseCard(selectedCard);
                player.choosePos(new Position(mouseEvent.getX(), mouseEvent.getY()));
                try {
                    player.play();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        BotGamer bot = new BotGamer(manger, BotLevel.EASY, "mamoosh");

        new Thread(bot).start();
        setupElixirTimerTask(player);
    }

    private void setupElixirTimerTask(GamePlayer p) {
        Timeline tl = new Timeline(
                new KeyFrame(
                        Duration.millis(100),
                        new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                elixirVal.setText(""+p.getElixir());
                            }
                        }
                )
               );
        tl.setCycleCount(Timeline.INDEFINITE);
        tl.play();
    }

    private void placementCards() {
        ImageView iv;
        AbstractBaseCard card;
        for(int i=0; i<cards.size(); i++){
            card = cards.get(i);
            try {
                iv = (ImageView) cardsPane.getChildren().get(i);
                iv.setImage(new Image(card.getImageUri()));
            }
            catch (Exception ex){
                System.out.println(card.getImageUri());
            }
        }
    }

    public void setCards(ArrayList<AbstractBaseCard> cards){
        this.cards = cards;
    }

    public void cardClicked(MouseEvent mouseEvent) {
        ImageView iv = (ImageView) mouseEvent.getSource();
        AbstractBaseCard card =cards.get(cardsPane.getChildren().indexOf(iv));
        Image img = new Image(card.getImageUri());
        cardSel.setImage(img);
        this.selectedCard = card;
    }
}
