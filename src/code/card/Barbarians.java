package code.card;

import java.net.URI;

public class Barbarians extends Troop{

    public Barbarians(TroopBuilder tb) {
        super(tb.cost, Defaults.BARBARIANS_IMAGE, Defaults.BARBARIANCE_SOUND, tb);
    }


    @Override
    public void playCard() {

    }

    @Override
    public void upgradeCard() {

    }
}
