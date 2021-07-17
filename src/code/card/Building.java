package code.card;

import java.net.URI;

public abstract class Building extends AbstractBaseCard {


    private int hit_Speed;
    private Target target;
    private Range range;
    private int lifetime;

    public Building(int cost, URI img, URI sound, int lifetime, int hit_Speed, Target target, Range range) {
        super(cost, img, sound);
        this.lifetime = lifetime;
        this.hit_Speed = hit_Speed;
        this.target = target;
        this.range = range;
    }

    public abstract void Leftime(int leftime);


}



