package code.card;

public class Builders {

    public static TroopBuilder CreateBarbariansBuilder(){
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

    public static TroopBuilder CreateArcherBuilder(){
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

    public static TroopBuilder CreateBabyDragonBuilder(){
        TroopBuilder tb = new TroopBuilder();
        tb.addHitSpeed(Defaults.BabyDragon_HIT_SPEED);
        tb.addCounts(Defaults.BabyDragon_COUNT);
        tb.addDamage(Defaults.BabyDragon_DAMAGE);
        tb.addHp(Defaults.BabyDragon_HP);
        tb.addRange(Defaults.BabyDragon_RANGE);
        tb.addTarget(Defaults.BabyDragon_TARGET);
        tb.addCost(Defaults.BabyDragon_COST);
        return tb;
    }

    public static TroopBuilder CreateWizardBuilder(){
        TroopBuilder tb = new TroopBuilder();
        tb.addHitSpeed(Defaults.WIZARD_HIT_SPEED);
        tb.addCounts(Defaults.WIZARD_COUNT);
        tb.addDamage(Defaults.WIZARD_DAMAGE);
        tb.addHp(Defaults.WIZARD_HP);
        tb.addRange(Defaults.WIZARD_RANGE);
        tb.addTarget(Defaults.WIZARD_TARGET);
        tb.addCost(Defaults.WIZARD_COST);
        return tb;
    }

    public static TroopBuilder CreateMiniPEKKABuilder(){
        TroopBuilder tb = new TroopBuilder();
        tb.addHitSpeed(Defaults.MiniPEKKA_HIT_SPEED);
        tb.addCounts(Defaults.MiniPEKKA_COUNT);
        tb.addDamage(Defaults.MiniPEKKA_DAMAGE);
        tb.addHp(Defaults.MiniPEKKA_HP);
        tb.addRange(Defaults.MiniPEKKA_RANGE);
        tb.addTarget(Defaults.MiniPEKKA_TARGET);
        tb.addCost(Defaults.MiniPEKKA_COST);
        return tb;
    }

    public static TroopBuilder CreateGiantBuilder(){
        TroopBuilder tb = new TroopBuilder();
        tb.addHitSpeed(Defaults.Giant_HIT_SPEED);
        tb.addCounts(Defaults.Giant_COUNT);
        tb.addDamage(Defaults.Giant_DAMAGE);
        tb.addHp(Defaults.Giant_HP);
        tb.addRange(Defaults.Giant_RANGE);
        tb.addTarget(Defaults.Giant_TARGET);
        tb.addCost(Defaults.Giant_COST);
        return tb;
    }

    public static TroopBuilder CreateValkyrieBuilder(){
        TroopBuilder tb = new TroopBuilder();
        tb.addHitSpeed(Defaults.Valkyrie_HIT_SPEED);
        tb.addCounts(Defaults.Valkyrie_COUNT);
        tb.addDamage(Defaults.Valkyrie_DAMAGE);
        tb.addHp(Defaults.Valkyrie_HP);
        tb.addRange(Defaults.Valkyrie_RANGE);
        tb.addTarget(Defaults.Valkyrie_TARGET);
        tb.addCost(Defaults.Valkyrie_COST);
        return tb;
    }
}
