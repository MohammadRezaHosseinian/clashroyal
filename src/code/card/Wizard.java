package code.card;

import java.net.URI;

public class Wizard extends Troop{

    public Wizard(int cost, URI img, URI sound, TroopBuilder tb) {
        super(tb.cost, Defaults.WIZARD_IMAGE, Defaults.WIZARD_SOUND, tb);
    }

    @Override
    public void playCard() {

    }

    @Override
    public void upgradeCard(Level l) {
        WizardUpgrade wu = new WizardUpgrade(l);
        this.hp = wu.hp;
        this.damage = wu.damage;
    }
}
