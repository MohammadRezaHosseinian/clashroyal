package code.card;

/*
 **
 * this class for create Archer card
 * *
 */
public class Archer extends Troop {

// Archer extends from Troop
    public Archer(TroopBuilder tb) {
        super(tb.cost, Defaults.Archer_IMAGE, Defaults.Archer_SOUND, tb);
    }

    @Override
    public void playCard() {

    }

    @Override
    // this method for upgrade level of card
    public void upgradeCard(Level l) {
        ArchersUpgrade au = new ArchersUpgrade(l);
        this.hp = au.hp;
        this.damage = au.damage;
    }
}
