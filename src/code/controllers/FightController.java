package code.controllers;

import code.heros.*;
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
                Team team = Team.UP_SIDE_TEAM;
                String uri = "res//drawable//giant.png";
                if(mouseEvent.isPrimaryButtonDown()){
                    uri = "res//drawable//giant2.png";
                    team = Team.DOWN_SIDE_TEAM;
                }
                    BarbarianceHero barbar = new BarbarianceHero(new Image(uri),
                            new Position(mouseEvent.getX(), mouseEvent.getY()),
                            team
                    );
                    ArcherHero archer = new ArcherHero(new Image(uri),
                            new Position(mouseEvent.getX() , mouseEvent.getY()),
                            team
                    );
                BabyDragonHero babyDragonHero = new BabyDragonHero(new Image(uri),
                        new Position(mouseEvent.getX() , mouseEvent.getY()),
                        team
                );
                WizardHero wizard = new WizardHero(new Image(uri),
                        new Position(mouseEvent.getX() , mouseEvent.getY()),
                        team
                );
                MiniPEKKAHero miniPEKKAHero = new MiniPEKKAHero(new Image(uri),
                        new Position(mouseEvent.getX() , mouseEvent.getY()),
                        team
                );
                ValkyrieHero valkyrieHero = new ValkyrieHero(new Image(uri),
                        new Position(mouseEvent.getX() , mouseEvent.getY()),
                        team
                );
                GiantHero giantHero = new GiantHero(new Image(uri),
                        new Position(mouseEvent.getX() , mouseEvent.getY()),
                        team
                );
                    manger.addElement(giantHero);

            }
        });

        BotGamer bot = new BotGamer(manger, BotLevel.EASY, "mamoosh");
        new Thread(bot).start();
    }
}
