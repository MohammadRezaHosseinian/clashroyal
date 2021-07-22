package code.card;

/*
 **
 * this class for Upgrade arrows card
 * *
 */
public class Arrows_Upgrade extends TroopUpgrade{

    public Arrows_Upgrade(Level level) {
        super(level);
    }

    @Override
    public void upgrade() {

        while (true) {
            switch (level) {
                case LV1:
                    this.damage = 144;
                    break;
                case LV2:
                    this.damage = 156;
                    break;
                case LV3:
                    this.damage = 174;
                    break;
                case LV4:
                    this.damage = 189;
                    break;
                case LV5:
                    this.damage = 210;
                    break;
            }
        }
    }
}
