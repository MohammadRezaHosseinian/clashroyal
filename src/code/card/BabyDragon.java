package code.card;

/*
**
* this class create BabyDragon card
* *
 */
public class BabyDragon extends Troop{

    public BabyDragon(TroopBuilder tb) {
        super(tb.cost,Defaults.BabyDragon_IMAGE,Defaults.BabyDragon_SOUND,tb);
    }

    @Override
    public void playCard() {

    }

    @Override
    // this method for upgrade level of card
    public void upgradeCard(Level l) {
        BabyDragonUpgrade bu = new BabyDragonUpgrade(l);
        this.hp = bu.hp;
        this.damage = bu.damage;
    }
}
