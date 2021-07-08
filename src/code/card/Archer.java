package code.card;

import code.card.*;

import java.net.URI;

public class Archer extends Troop {


    public Archer(int cost, URI img, URI sound, TroopBuilder tb) {
        super(tb.cost, Defaults.BARBARIANS_IMAGE, Defaults.BARBARIANCE_SOUND, tb);
    }

    @Override
    public void playCard() {

    }

    @Override
    public void upgradeCard(Level l) {
        ArchersUpgrade au = new ArchersUpgrade(l);
        this.hp = au.hp;
        this.damage = au.damage;
    }
}
