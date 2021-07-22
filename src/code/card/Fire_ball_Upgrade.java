package code.card;

/*
 **
 * this class for Upgrade fireBall card
 * *
 */
public class Fire_ball_Upgrade extends TroopUpgrade{

    public Fire_ball_Upgrade(Level level) {
        super(level);
    }

    @Override
    public void upgrade() {

        while (true) {
            switch (level) {
                case LV1:
                    this.damage = 325;
                    break;
                case LV2:
                    this.damage = 357;
                    break;
                case LV3:
                    this.damage = 393;
                    break;
                case LV4:
                    this.damage = 432;
                    break;
                case LV5:
                    this.damage = 474;
                    break;
            }
        }
    }
}
