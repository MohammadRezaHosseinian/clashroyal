package code.card;

public class ValkyrieUpgrade extends TroopUpgrade{

    public ValkyrieUpgrade(Level level) {
        super(level);
    }

    @Override
    public void upgrade() {
        while (true) {
            switch (level) {
                case LV1:
                    this.hp = 880;
                    this.damage = 120;
                    break;
                case LV2:
                    this.hp = 968;
                    this.damage = 132;
                    break;
                case LV3:
                    this.hp = 1064;
                    this.damage = 145;
                    break;
                case LV4:
                    this.hp = 1170;
                    this.damage = 159;
                    break;
                case LV5:
                    this.hp = 1284;
                    this.damage = 175;
                    break;
            }
        }
    }
}
