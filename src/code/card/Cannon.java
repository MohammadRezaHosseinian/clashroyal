package code.card;

import java.net.URI;

public abstract class Cannon extends Building implements CardImpl{



    public Cannon(int cost, URI img, URI sound, int lifetime, int hit_Speed, Target target, Range range) {
        super(cost, img, sound, lifetime, hit_Speed, target, range);
    }

    @Override
    public void Leftime(int leftime) {}


    @Override
    public void playCard(){};



}
