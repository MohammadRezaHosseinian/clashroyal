package code.card;

import java.net.URI;

public abstract class  Spell extends AbstractBaseCard{
    public Spell(int cost, URI img, URI sound) {
        super(cost, img, sound);
    }

    @Override
    public abstract void playCard();
}
