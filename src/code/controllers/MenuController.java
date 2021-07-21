package code.controllers;

import code.card.AbstractBaseCard;
import code.heros.BotGamer;
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
        cards = new ArrayList<>(8);
        bot = new BotGamer(null, "easyBot");
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

    public void setBot(BotGamer b){
        this.bot = b;
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
        controller.setCards(this.cards);
        stage.setScene(new Scene(p));
    }

    public void gotoBotLevelMenu(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) parent.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../res/fxml/botMenu.fxml"));
        Parent p = loader.load();
        BotMenuController controller = loader.getController();
        controller.setInitialBot(bot);
        controller.setData(bot, user, cards);
        stage.setScene(new Scene(p));
    }

    public void gotoCardMenu(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) parent.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../res/fxml/cardMenu.fxml"));
        Parent p = loader.load();
        CardMenuController controller = loader.getController();
        controller.setData(bot, user, cards);
        stage.setScene(new Scene(p));
    }

    public void setUser(User u){
        this.user = u;
    }

    public void setCards(ArrayList<AbstractBaseCard> c){
        this.cards = c;
        replacementCards();
    }
}
