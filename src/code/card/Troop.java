package code.card;

import java.net.URI;

public abstract class Troop extends AbstractBaseCard implements CardImpl{

    protected int hp;
    protected int damage;
    protected float hitSpeedPerSecond;
    protected Speed speed;
    protected Target target;
    protected Range range;
    protected int counts;

    public Troop(int cost, URI img, URI sound, TroopBuilder tb) {
        super(cost, img, sound);
        this.hp = tb.hp;
        this.damage = tb.damage;
        this.hitSpeedPerSecond = tb.hitSpeed;
        this.speed = tb.speed;
        this.target = tb.target;
        this.range = tb.range;
        this.counts = tb.counts;
    }

    public int getHp(){
        return this.hp;
    }

    public int getDamage(){
        return this.damage;
    }

    public float getHitSpeedPerSecond(){
        return this.hitSpeedPerSecond;
    }

    public Speed getSpeed(){
        return this.speed;
    }

    public Target getTarget(){
        return this.target;
    }

    public Range getRange(){
        return this.range;
    }

    public int getCounts(){
        return this.counts;
    }

    @Override
    public abstract void playCard();

    @Override
    public abstract void upgradeCard(Level l);
}
