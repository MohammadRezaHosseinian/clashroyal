package code.card;

public class BarabariansUpgrade extends TroopUpgrade{


    public BarabariansUpgrade(Level level) {
        super(level);
    }

    @Override
    public void upgrade() {
        while (true) {
            switch (level) {
                case LV1:
                    this.hp = 300;
                    this.damage = 75;
                    break;
                case LV2:
                    this.hp = 330;
                    this.damage = 82;
                    break;
                case LV3:
                    this.hp = 363;
                    this.damage = 90;
                    break;
                case LV4:
                    this.hp = 438;
                    this.damage = 99;
                    break;
                case LV5:
                    this.hp = 480;
                    this.damage = 109;
                    break;
            }
        }
    }
}
