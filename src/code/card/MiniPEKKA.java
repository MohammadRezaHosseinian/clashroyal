package code.card;

import java.net.URI;

public class MiniPEKKA extends Troop{

    public MiniPEKKA(int cost, URI img, URI sound, TroopBuilder tb) {
        super(tb.cost, Defaults.MiniPEKKA_IMAGE, Defaults.MiniPEKKA_SOUND, tb);
    }

    @Override
    public void playCard() {

    }

    @Override
    public void upgradeCard(Level l) {
        MiniPEKKAUpgrade mu = new MiniPEKKAUpgrade(l);
        this.hp = mu.hp;
        this.damage = mu.damage;
    }
}
