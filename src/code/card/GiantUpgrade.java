package code.card;

/*
 **
 * this class for Upgrade giant card
 * *
 */
public class GiantUpgrade extends TroopUpgrade{

    public GiantUpgrade(Level level) {
        super(level);
    }

    @Override
    public void upgrade() {
        while (true) {
            switch (level) {
                case LV1:
                    this.hp = 2000;
                    this.damage = 126;
                    break;
                case LV2:
                    this.hp = 2200;
                    this.damage = 138;
                    break;
                case LV3:
                    this.hp = 2420;
                    this.damage = 152;
                    break;
                case LV4:
                    this.hp = 2660;
                    this.damage = 167;
                    break;
                case LV5:
                    this.hp = 2920;
                    this.damage = 183;
                    break;
            }
        }
    }
}
