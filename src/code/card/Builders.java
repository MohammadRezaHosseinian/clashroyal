package code.card;

public class Builders {

    protected static TroopBuilder CreateBarbariansBuilder(){
        TroopBuilder tb = new TroopBuilder();
        tb.addHitSpeed(Defaults.BARBARIANS_HIT_SPEED);
        tb.addCounts(Defaults.BARBARIANS_COUNT);
        tb.addDamage(Defaults.BARBARIANS_DAMAGE);
        tb.addHp(Defaults.BARBARIANS_HP);
        tb.addRange(Defaults.BARBARIANS_RANGE);
        tb.addTarget(Defaults.BARBARIANS_TARGET);
        tb.addCost(Defaults.BARBARIANCE_COST);
        return tb;
    }

    protected static TroopBuilder CreateArcherBuilder(){
        TroopBuilder tb = new TroopBuilder();
        tb.addHitSpeed(Defaults.Archer_HIT_SPEED);
        tb.addCounts(Defaults.Archer_COUNT);
        tb.addDamage(Defaults.Archer_DAMAGE);
        tb.addHp(Defaults.Archer_HP);
        tb.addRange(Defaults.Archer_RANGE);
        tb.addTarget(Defaults.Archer_TARGET);
        tb.addCost(Defaults.Archer_COST);
        return tb;
    }

}
