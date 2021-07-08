package code.card;

public abstract class TroopUpgrade {

    protected int hp;
    protected int damage;
    protected Level level;

    public TroopUpgrade(Level level){
        this.level = level;
    }
    public abstract void upgrade();
}
