package code.card;

import java.net.URI;

/*
**
* this class for create Buldings card
**
 */
public abstract class Building extends AbstractBaseCard implements CardImpl{
    public Building(int cost, String img, URI sound) {
        super(cost, img, sound);
    }

    @Override
    public abstract void playCard();

    @Override
    // this method for upgrade level of Buildings
    public abstract void upgradeCard(Level l);
}
