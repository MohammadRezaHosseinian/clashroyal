package code.controllers;

/*
 **
 * this class control card menu
 **
 */
import code.card.AbstractBaseCard;
import code.heros.BotGamer;
import code.heros.ScreenObjectBuilder;
import code.users.User;
import javafx.fxml.FXML;
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

public class CardMenuController {
    public AnchorPane parent;
    public HBox selectedCardsContainer;
    public HBox troopsContainer;
    public HBox spellsContainer;
    public HBox buildingsContainer;
    private BotGamer bot;
    private User user;
    private ArrayList<AbstractBaseCard> selectedCards;


    @FXML
    public void initialize() {
        selectedCards = new ArrayList<>(8);
        this.setBackgroundParent();
        this.replacementCards();
        this.replacementTroops();
        this.replacementBuildings();
        this.replacementSpells();
    }

    // replace splle in choosen cards
    private void replacementSpells() {
        ImageView iv;
        AbstractBaseCard card;
        ArrayList<AbstractBaseCard> spells = ScreenObjectBuilder.getAllSpells();
        for(int i=0; i<spells.size(); i++){
            card = spells.get(i);
            try {
                iv = (ImageView) spellsContainer.getChildren().get(i);
                iv.setImage(new Image(card.getImageUri()));
            }
            catch (Exception ex){
                System.out.println(card.getImageUri());
            }
        }
    }

    // replace building in choosen cards
    private void replacementBuildings() {
        ImageView iv;
        AbstractBaseCard card;
        ArrayList<AbstractBaseCard> buildings = ScreenObjectBuilder.getAllBuildings();
        for(int i=0; i<buildings.size(); i++){
            card = buildings.get(i);
            try {
                iv = (ImageView) buildingsContainer.getChildren().get(i);
                iv.setImage(new Image(card.getImageUri()));
            }
            catch (Exception ex){
                System.out.println(card.getImageUri());
            }
        }
    }

    // replace troop in choosen cards
    private void replacementTroops() {
        ImageView iv;
        AbstractBaseCard card;
        ArrayList<AbstractBaseCard> troops = ScreenObjectBuilder.getAllTroops();
        for(int i=0; i<troops.size(); i++){
            card = troops.get(i);
            try {
                iv = (ImageView) troopsContainer.getChildren().get(i);
                iv.setImage(new Image(card.getImageUri()));
            }
            catch (Exception ex){
                System.out.println(card.getImageUri());
            }
        }
    }

    // replace card in choosen cards
    private void replacementCards() {
        ImageView iv;
        AbstractBaseCard card;
        for(int i=0; i<selectedCards.size(); i++){
            card = selectedCards.get(i);
            try {
                iv = (ImageView) selectedCardsContainer.getChildren().get(i);
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


    // go to main menu
    public void gotoMenu(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) parent.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../res/fxml/menu.fxml"));
        Parent p = loader.load();
        MenuController controller = loader.getController();
        controller.setBot(this.bot);
        controller.setCards(this.selectedCards);
        controller.setUser(this.user);
        stage.setScene(new Scene(p));
    }

    public void setData(BotGamer bot, User user, ArrayList<AbstractBaseCard> cards) {
        System.out.println("setdata called");
        this.selectedCards = cards;
        this.bot = bot;
        this.user = user;
        replacementCards();
    }

    public void removeSelectedCard(MouseEvent mouseEvent) {
        ImageView iv = (ImageView) mouseEvent.getSource();
        if(iv.getImage() == null)
            return;
        int index = selectedCardsContainer.getChildren().indexOf(iv);
        AbstractBaseCard card = selectedCards.remove(index);
        resetImagesSelectedCardsContainer();
        replacementCards();
    }

    // reset image from choosen cards image
    private void resetImagesSelectedCardsContainer(){
        ImageView iv;
        int len = selectedCardsContainer.getChildren().size();
        for (int i = 0; i < len; i++) {
            iv = (ImageView) selectedCardsContainer.getChildren().get(i);
            iv.setImage(null);
        }
    }

    public void addTroopToSelectedCards(MouseEvent mouseEvent) {
        ImageView iv = (ImageView) mouseEvent.getSource();
        int index = troopsContainer.getChildren().indexOf(iv);
        AbstractBaseCard card = ScreenObjectBuilder.getAllTroops().get(index);
        if(isDuplicateCard(card))
            return;
        if(selectedCards.size() == 8)
            selectedCards.remove(7);
        this.selectedCards.add(card);
        resetImagesSelectedCardsContainer();
        replacementCards();
    }

    public void addSpellToSelectedCards(MouseEvent mouseEvent) {
        ImageView iv = (ImageView) mouseEvent.getSource();
        int index = spellsContainer.getChildren().indexOf(iv);
        if(iv.getImage() == null)
            return;
        AbstractBaseCard card = ScreenObjectBuilder.getAllSpells().get(index);
        if(isDuplicateCard(card))
            return;
        if(selectedCards.size() == 8)
            selectedCards.remove(7);
        this.selectedCards.add(card);
        resetImagesSelectedCardsContainer();
        replacementCards();
    }

    private boolean isDuplicateCard(AbstractBaseCard c){
        for(AbstractBaseCard card : selectedCards){
            if(c.getClass() == card.getClass()){
                return true;
            }
        }
        return false;
    }

    public void addBuildingToSelectedCards(MouseEvent mouseEvent) {
        ImageView iv = (ImageView) mouseEvent.getSource();
        int index = buildingsContainer.getChildren().indexOf(iv);
        if(iv.getImage() == null)
            return;
        AbstractBaseCard card = ScreenObjectBuilder.getAllBuildings().get(index);
        if(isDuplicateCard(card))
            return;
        if(selectedCards.size() == 8)
            selectedCards.remove(7);
        this.selectedCards.add(card);
        resetImagesSelectedCardsContainer();
        replacementCards();
    }
}
