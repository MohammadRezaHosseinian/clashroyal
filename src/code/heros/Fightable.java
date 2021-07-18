package code.heros;

import code.card.Range;

public interface Fightable {
    public void fight();
    public Fightable getNeartarget();
    public Range getRangFight();
    public boolean CanAreaSlpash();
    public double getHitSpeed();
}
