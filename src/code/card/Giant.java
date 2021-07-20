package code.card;

public class Giant extends Troop{

    public Giant(TroopBuilder tb) {
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
