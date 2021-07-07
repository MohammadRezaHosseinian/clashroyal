package code.card;

import java.net.URI;

public class Inferno_Tower extends Building implements CardImpl{


    public Inferno_Tower(int cost, URI img, URI sound, int lifetime, int hit_Speed, Target target, Range range) {
        super(cost, img, sound, lifetime, hit_Speed, target, range);
    }

    @Override
    public void playCard() {

    }

    @Override
    public void upgradeCard() {

    }
}
