package code.card;

import java.net.URI;

public class BabyDragon extends Troop{

    public BabyDragon(int cost, URI img, URI sound, TroopBuilder tb) {
        super(tb.cost,Defaults.BabyDragon_IMAGE,Defaults.BARBARIANCE_SOUND,tb);
    }

    @Override
    public void playCard() {

    }

    @Override
    public void upgradeCard(Level l) {
        BarabariansUpgrade bu = new BarabariansUpgrade(l);
        this.hp = bu.hp;
        this.damage = bu.damage;
    }
}
