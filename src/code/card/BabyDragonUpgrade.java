package code.card;

public class BabyDragonUpgrade extends TroopUpgrade{

    public BabyDragonUpgrade(Level level) {
        super(level);
    }

    @Override
    public void upgrade() {
        while (true) {
            switch (level) {
                case LV1:
                    this.hp = 800;
                    this.damage = 100;
                    break;
                case LV2:
                    this.hp = 880;
                    this.damage = 110;
                    break;
                case LV3:
                    this.hp = 968;
                    this.damage = 121;
                    break;
                case LV4:
                    this.hp = 1064;
                    this.damage = 133;
                    break;
                case LV5:
                    this.hp = 1168;
                    this.damage = 146;
                    break;
            }
        }
    }
}
