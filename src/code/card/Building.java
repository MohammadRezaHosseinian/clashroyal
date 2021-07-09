package code.card;

import java.net.URI;

public abstract class Building extends AbstractBaseCard implements CardImpl{
    public Building(int cost, URI img, URI sound) {
        super(cost, img, sound);
    }

    @Override
    public abstract void playCard();

    @Override
    public abstract void upgradeCard(Level l);
}
