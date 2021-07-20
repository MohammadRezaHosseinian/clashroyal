package code.card;

public class Valkyrie extends Troop{

    public Valkyrie(TroopBuilder tb) {
        super(tb.cost, Defaults.Valkyrie_IMAGE, Defaults.Valkyrie_SOUND, tb);
    }

    @Override
    public void playCard() {

    }

    @Override
    public void upgradeCard(Level l) {
        ValkyrieUpgrade vu = new ValkyrieUpgrade(l);
        this.hp = vu.hp;
        this.damage = vu.damage;
    }
}
