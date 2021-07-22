package code.card;

/*
 **
 * this class for create Wizard card
 * *
 */
public class Wizard extends Troop{

    public Wizard(TroopBuilder tb) {
        super(tb.cost, Defaults.WIZARD_IMAGE, Defaults.WIZARD_SOUND, tb);
    }

    @Override
    public void playCard() {

    }

    @Override
    // this method for upgrade wizard card
    public void upgradeCard(Level l) {
        WizardUpgrade wu = new WizardUpgrade(l);
        this.hp = wu.hp;
        this.damage = wu.damage;
    }
}
