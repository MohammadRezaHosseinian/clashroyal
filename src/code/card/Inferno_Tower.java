package code.card;

/*
 **
 * this class for create InfernoTower card
 * *
 */
import java.net.URI;

public class Inferno_Tower extends Building implements CardImpl{


    public Inferno_Tower(int cost, URI sound) {
        super(cost, "res//drawable//infernoCard.png", sound);
    }


    public void Leftime(int leftime) {}




    @Override
    public void playCard() {

    }

    @Override
    // this method for upgrade inferno card
    public void upgradeCard(Level l) {

    }


}
