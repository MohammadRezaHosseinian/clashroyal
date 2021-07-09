package code.card;

import java.net.URI;

public class Giant extends Troop{

    public Giant(int cost, URI img, URI sound, TroopBuilder tb) {
        super(tb.cost, Defaults.Giant_IMAGE, Defaults.Giant_SOUND, tb);
    }

    @Override
    public void playCard() {

    }

    @Override
    public void upgradeCard(Level l) {
        GiantUpgrade gu = new GiantUpgrade(l);
        this.hp = gu.hp;
        this.damage = gu.damage;
    }
}
