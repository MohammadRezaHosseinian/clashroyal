package code.card;

public class TroopBuilder {
    protected int hp;
    protected int damage;
    protected float hitSpeed;
    protected Speed speed;
    protected Target target;
    protected Range range;
    protected int counts;
    protected int cost;

    public TroopBuilder addHp(int hp){
        this.hp = hp;
        return this;
    }

    public TroopBuilder addDamage(int damage){
        this.damage = damage;
        return this;
    }

    public TroopBuilder addHitSpeed(float hit){
        this.hitSpeed = hit;
        return this;
    }

    public TroopBuilder addSpeed(Speed speed){
        this.speed = speed;
        return this;
    }

    public TroopBuilder addRange(Range r){
        this.range = r;
        return this;
    }

    public TroopBuilder addTarget(Target t){
        this.target = t;
        return this;
    }

    public TroopBuilder addCounts(int c){
        this.counts = c;
        return this;
    }

    public TroopBuilder addCost(int cost){
        this.cost = cost;
        return this;
    }
}
