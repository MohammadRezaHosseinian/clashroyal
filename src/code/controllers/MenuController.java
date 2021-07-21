package code.controllers;

import code.card.AbstractBaseCard;
import code.heros.BotGamer;
import code.heros.BotLevel;
import code.heros.ScreenObjectBuilder;
import code.users.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class MenuController {

    public AnchorPane parent;
    public HBox cardsPane;
    private ArrayList<AbstractBaseCard> cards;
    private BotGamer bot;
    private User user;

    public void initialize() {
        cards = ScreenObjectBuilder.getAllCards();
        bot = new BotGamer(null, BotLevel.EASY, "easyBot");
        this.setBackgroundParent();
        this.replacementCards();
    }

    private void replacementCards() {
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

    private void setBackgroundParent() {
        BackgroundImage bi = new BackgroundImage(new Image("res//drawable//back.jpg"),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT
        );
        this.parent.setBackground(new Background(bi));
    }


    public void exitHandler(MouseEvent mouseEvent) {
        //save all things in db
        System.exit(0);
    }

    public void gotoGame(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) parent.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../res/fxml/fight.fxml"));
        Parent p = loader.load();
        FightController controller = loader.getController();
        controller.setBot(this.bot);
        controller.setUser(this.user);
        cards = ScreenObjectBuilder.getAllCards();
        cards.remove(0);
        controller.setCards(cards);
        stage.setScene(new Scene(p));
    }
}
