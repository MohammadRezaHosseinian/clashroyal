package code.controllers;

/*
**
* this class control bot menu
**
 */
import code.card.AbstractBaseCard;
import code.heros.BotGamer;
import code.heros.BotLevel;
import code.users.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class BotMenuController {
    @FXML
    public Label levelVal;
    public AnchorPane parent;
    public VBox buttonContainer;
    private BotGamer bot;
    private User user;
    private ArrayList<AbstractBaseCard> cards;

    @FXML
    public void initialize(){
        setBackgroundParent();
    }

    private void setBackgroundParent() {
        BackgroundImage bi = new BackgroundImage(new Image("res//drawable//back.jpg"),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT
        );
        this.parent.setBackground(new Background(bi));
    }
    
    public void setInitialBot(BotGamer b){
        this.bot = b;
        updateLevelVal(b);
    }

    // update level of bot
    private void updateLevelVal(BotGamer b){
        if(b != null)
            this.levelVal.setText(b.getLevel().toString());
    }

    // change bot level
    public void changeLevel(MouseEvent mouseEvent) {
        Button btn = (Button) mouseEvent.getSource();
        int index = buttonContainer.getChildren().indexOf(btn);
        System.out.println(index);
        this.setLevel(index);
        this.updateLevelVal(this.bot);
    }


    private void setLevel(int i){
        switch (i) {
            case 0 -> this.bot.setLevel(BotLevel.LEVEL_1);
            case 1 -> this.bot.setLevel(BotLevel.LEVEL_2);
            case 2 -> this.bot.setLevel(BotLevel.LEVEL_3);
            case 3 -> this.bot.setLevel(BotLevel.LEVEL_4);
            case 4 -> this.bot.setLevel(BotLevel.LEVEL_5);
            case 5 -> this.bot.setLevel(BotLevel.LEVEL_6);
        }
    }

    // go to menu page
    public void gotoMenu(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) parent.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../res/fxml/menu.fxml"));
        Parent p = loader.load();
        MenuController controller = loader.getController();
        controller.setBot(this.bot);
        controller.setCards(this.cards);
        controller.setUser(this.user);
        stage.setScene(new Scene(p));
    }

    public void setData(BotGamer bot, User user, ArrayList<AbstractBaseCard> cards) {
        System.out.println("setdata called");
        this.cards = cards;
        this.bot = bot;
        this.user = user;
    }
}
