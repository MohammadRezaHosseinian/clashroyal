package code.card;

public class Inferno_Tower_Upgrade extends TroopUpgrade{

    public Inferno_Tower_Upgrade(Level level) {
        super(level);
    }

    @Override
    public void upgrade() {

        while (true) {
            switch (level) {
                case LV1:
                    this.hp = 800;
                    this.damage = 20;
                    this.damage2 = 400;
                    break;
                case LV2:
                    hp = 880;
                    damage = 22;
                    damage2 = 440;
                    break;
                case LV3:
                    hp = 968;
                    damage = 24;
                    damage2 = 484;
                    break;
                case LV4:
                    hp = 1064;
                    damage = 26;
                    damage2 = 532;
                    break;
                case LV5:
                    hp = 1168;
                    damage = 29;
                    damage2 = 584;
                    break;
            }
        }
    }
}



