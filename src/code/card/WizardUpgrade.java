package code.card;

public class WizardUpgrade extends TroopUpgrade{

    public WizardUpgrade(Level level) {
        super(level);
    }

    @Override
    public void upgrade() {

        while (true) {
            switch (level) {
                case LV1:
                    this.hp = 340;
                    this.damage = 130;
                    break;
                case LV2:
                    hp = 374;
                    damage = 143;
                    break;
                case LV3:
                    hp = 411;
                    damage = 157;
                    break;
                case LV4:
                    hp = 452;
                    damage = 172;
                    break;
                case LV5:
                    hp = 496;
                    damage = 189;
                    break;
            }
        }
    }

}
