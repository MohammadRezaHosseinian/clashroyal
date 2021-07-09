package code.card;

import java.net.URI;

public class Cannon_Upgrade extends TroopUpgrade{

    public Cannon_Upgrade(Level level) {
        super(level);
    }

    @Override
    public void upgrade() {

        while (true) {
            switch (level) {
                case LV1:
                    this.hp = 380;
                    this.damage = 60;
                    break;
                case LV2:
                    hp = 418;
                    damage = 66;
                    break;
                case LV3:
                    hp = 459;
                    damage = 72;
                    break;
                case LV4:
                    hp = 505;
                    damage = 79;
                    break;
                case LV5:
                    hp = 554;
                    damage = 87;
                    break;
            }
        }
    }
}
