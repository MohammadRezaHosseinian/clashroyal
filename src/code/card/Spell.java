package code.card;

import java.net.URI;

public class Spell extends AbstractBaseCard{
    public Spell(int cost, URI img, URI sound) {
        super(cost, img, sound);
    }

    @Override
    public void playCard() {

    }
}
