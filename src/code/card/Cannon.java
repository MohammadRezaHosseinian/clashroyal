package code.card;

import java.net.URI;

public  class Cannon extends Building implements CardImpl{



    public Cannon(int cost, URI sound) {
        super(cost, "res//drawable//cannonCard.png", sound);
    }

//    @Override
//    public void Leftime(int leftime) {}


    @Override
    public void playCard(){}

    @Override
    public void upgradeCard(Level l) {

    }

    ;



}
