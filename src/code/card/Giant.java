package code.card;


/*
 **
 * this class for create Giant card
 * *
 */
public class Giant extends Troop{

    public Giant(TroopBuilder tb) {
        super(tb.cost, Defaults.Giant_IMAGE, Defaults.Giant_SOUND, tb);
    }

    @Override
    public void playCard() {

    }

    @Override
    // this method for upgrade giant card
    public void upgradeCard(Level l) {
        GiantUpgrade gu = new GiantUpgrade(l);
        this.hp = gu.hp;
        this.damage = gu.damage;
    }
}
