package code.card;

/*
 **
 * this class helps for create troops
 * *
 */
public class TroopBuilder {
    protected int hp;
    protected int damage;
    protected float hitSpeed;
    protected Speed speed;
    protected Target target;
    protected Range range;
    protected int counts;
    protected int cost;

    // in this method set hp of troops
    public TroopBuilder addHp(int hp){
        this.hp = hp;
        return this;
    }

    // in this method set damage of troops
    public TroopBuilder addDamage(int damage){
        this.damage = damage;
        return this;
    }

    // in this method set hit speed of troops
    public TroopBuilder addHitSpeed(float hit){
        this.hitSpeed = hit;
        return this;
    }

    // in this method set speed of troops
    public TroopBuilder addSpeed(Speed speed){
        this.speed = speed;
        return this;
    }

    // in this method set range of troops
    public TroopBuilder addRange(Range r){
        this.range = r;
        return this;
    }

    // in this method set target of troops
    public TroopBuilder addTarget(Target t){
        this.target = t;
        return this;
    }

    // in this method set count of troops
    public TroopBuilder addCounts(int c){
        this.counts = c;
        return this;
    }

    // in this method set cost of troops
    public TroopBuilder addCost(int cost){
        this.cost = cost;
        return this;
    }
}
