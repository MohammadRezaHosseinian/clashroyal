package code.card;

import java.net.URI;

public abstract class Troop extends AbstractBaseCard{

    public Troop(int cost, URI img, URI sound) {
        super(cost, img, sound);
    }

    @Override
    public abstract void playCard();
}
