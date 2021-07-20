package code.card;

public class Archer extends Troop {


    public Archer(TroopBuilder tb) {
        super(tb.cost, Defaults.Archer_IMAGE, Defaults.Archer_SOUND, tb);
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
