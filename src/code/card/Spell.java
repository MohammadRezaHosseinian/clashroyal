package code.card;

import java.net.URI;

public abstract class  Spell extends AbstractBaseCard implements CardImpl{
    private double radius;

    public Spell(int cost, URI img, URI sound , double radius) {
        super(cost, img, sound);
        this.radius = radius;
    }


    @Override
    public abstract void playCard();

    @Override
    public abstract void upgradeCard();
}
