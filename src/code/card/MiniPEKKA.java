package code.card;

/*
 **
 * this class for create MiniPEKKA card
 * *
 */
public class MiniPEKKA extends Troop{

    public MiniPEKKA(TroopBuilder tb) {
        super(tb.cost, Defaults.MiniPEKKA_IMAGE, Defaults.MiniPEKKA_SOUND, tb);
    }

    @Override
    public void playCard() {

    }

    @Override
    // this method for upgrade miniPEKKA card
    public void upgradeCard(Level l) {
        MiniPEKKAUpgrade mu = new MiniPEKKAUpgrade(l);
        this.hp = mu.hp;
        this.damage = mu.damage;
    }
}
