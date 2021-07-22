package code.card;

import java.net.URI;

/*
 **
 * this class for create Cannon card
 * *
 */

public  class Cannon extends Building implements CardImpl{



    public Cannon(int cost, URI sound) {
        super(cost, "res//drawable//cannonCard.png", sound);
    }

//    @Override
//    public void Leftime(int leftime) {}


    @Override
    public void playCard(){}

    @Override
    // this method for upgrade cannon card
    public void upgradeCard(Level l) {

    }

    ;



}
