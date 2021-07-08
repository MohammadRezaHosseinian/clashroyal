package code.card;

public class ArchersUpgrade extends TroopUpgrade{

    public ArchersUpgrade(Level level) {
        super(level);
    }

    @Override
    public void upgrade() {

        while (true) {
            switch (level) {
                case LV1:
                    this.hp = 125;
                    this.damage = 33;
                    break;
                case LV2:
                    hp = 127;
                    damage = 44;
                    break;
                case LV3:
                    hp = 151;
                    damage = 48;
                    break;
                case LV4:
                    hp = 166;
                    damage = 53;
                    break;
                case LV5:
                    hp = 182;
                    damage = 58;
                    break;
            }
        }
    }
}
