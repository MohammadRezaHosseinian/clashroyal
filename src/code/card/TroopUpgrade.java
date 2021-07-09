package code.card;

public abstract class TroopUpgrade {

    protected int hp;
    protected int damage;
    protected int damage2;
    protected Level level;
    protected double duration;


    public TroopUpgrade(Level level){
        this.level = level;
    }
    public abstract void upgrade();
}
