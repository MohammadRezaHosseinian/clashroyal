package code.card;

import java.net.URI;

public abstract class  Spell extends AbstractBaseCard implements CardImpl{
    public Spell(int cost, String img, URI sound) {
        super(cost, img, sound);
    }

    @Override
    public abstract void playCard();

    @Override
    public abstract void upgradeCard(Level l);
}
