package code.card;

/*
 **
 * this class for Upgrade miniPEKKA card
 * *
 */
public class MiniPEKKAUpgrade extends TroopUpgrade{

    public MiniPEKKAUpgrade(Level level) {
        super(level);
    }

    @Override
    public void upgrade() {
        while (true) {
            switch (level) {
                case LV1:
                    this.hp = 600;
                    this.damage = 325;
                    break;
                case LV2:
                    this.hp = 660;
                    this.damage = 357;
                    break;
                case LV3:
                    this.hp = 726;
                    this.damage = 393;
                    break;
                case LV4:
                    this.hp = 798;
                    this.damage = 432;
                    break;
                case LV5:
                    this.hp = 876;
                    this.damage = 474;
                    break;
            }
        }
    }
}
