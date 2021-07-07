package code.card;

import java.net.URI;

public abstract class Building extends AbstractBaseCard{
    public Building(int cost, URI img, URI sound) {
        super(cost, img, sound);
    }

    @Override
    public abstract void playCard();
}
