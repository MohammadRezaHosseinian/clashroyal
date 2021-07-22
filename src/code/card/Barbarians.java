package code.card;
/*
**
* this class create Barbarians card
**
 */

public class Barbarians extends Troop{

    public Barbarians(TroopBuilder tb) {
        super(tb.cost, Defaults.BARBARIANS_IMAGE, Defaults.BARBARIANCE_SOUND, tb);
    }


    @Override
    public void playCard() {

    }

    @Override
    // this method for upgrade level of card
    public void upgradeCard(Level l) {
        BarabariansUpgrade bu = new BarabariansUpgrade(l);
        bu.upgrade();
        this.hp = bu.hp;
        this.damage = bu.damage;
    }
}
