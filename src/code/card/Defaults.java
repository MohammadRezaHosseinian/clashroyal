package code.card;

/*
**
* this class for CONSTANT variable
**
 */
import java.net.URI;

public class Defaults {

    // create Barbarians features
    protected static final int BARBARIANCE_COST = 5;
    protected static final String BARBARIANS_IMAGE = "res//drawable//barbarCard.png";
    protected static final URI BARBARIANCE_SOUND = null;
    protected static final float BARBARIANS_HIT_SPEED = 1.8f;
    protected static final int BARBARIANS_COUNT = 4;
    protected static final int BARBARIANS_DAMAGE = 75;
    protected static final int BARBARIANS_HP = 300;
    protected static final Range BARBARIANS_RANGE = Range.MELEE;
    protected static final Target BARBARIANS_TARGET = Target.GROUND_TARGET;

    // create Archers features
    protected static final int Archer_COST = 3;
    protected static final String Archer_IMAGE = "res//drawable//archerCard.png";;
    protected static final URI Archer_SOUND = null;
    protected static final float Archer_HIT_SPEED = 1.2f;
    protected static final int Archer_COUNT = 2;
    protected static final int Archer_DAMAGE = 33;
    protected static final int Archer_HP = 125;
    protected static final Range Archer_RANGE = Range.RANGED;
    protected static final Target Archer_TARGET = Target.AIR_GROUND_TARGET;

    // create BabyDragon features
    protected static final int BabyDragon_COST = 4;
    protected static final String BabyDragon_IMAGE = "res//drawable//babyCard.png";;
    protected static final URI BabyDragon_SOUND = null;
    protected static final float BabyDragon_HIT_SPEED = 1.8f;
    protected static final int BabyDragon_COUNT = 1;
    protected static final int BabyDragon_DAMAGE = 100;
    protected static final int BabyDragon_HP = 800;
    protected static final Range BabyDragon_RANGE = Range.RANGED;
    protected static final Target BabyDragon_TARGET = Target.AIR_GROUND_TARGET;

    // create Wizard features
    protected static final int WIZARD_COST = 5;
    protected static final String WIZARD_IMAGE = "res//drawable//wizardCard.png";
    protected static final URI WIZARD_SOUND = null;
    protected static final float WIZARD_HIT_SPEED = 1.7f;
    protected static final int WIZARD_COUNT = 1;
    protected static final int WIZARD_DAMAGE = 130;
    protected static final int WIZARD_HP = 340;
    protected static final Range WIZARD_RANGE = Range.RANGED;
    protected static final Target WIZARD_TARGET = Target.AIR_GROUND_TARGET;

    // create MiniPEKKA features
    protected static final int MiniPEKKA_COST = 4;
    protected static final String MiniPEKKA_IMAGE = "res//drawable//pikaCard.png";
    protected static final URI MiniPEKKA_SOUND = null;
    protected static final float MiniPEKKA_HIT_SPEED = 1.8f;
    protected static final int MiniPEKKA_COUNT = 1;
    protected static final int MiniPEKKA_DAMAGE = 350;
    protected static final int MiniPEKKA_HP = 600;
    protected static final Range MiniPEKKA_RANGE = Range.MELEE;
    protected static final Target MiniPEKKA_TARGET = Target.GROUND_TARGET;

    // create Giant features
    protected static final int Giant_COST = 5;
    protected static final String Giant_IMAGE = "res//drawable//giantCard.png";
    protected static final URI Giant_SOUND = null;
    protected static final float Giant_HIT_SPEED = 1.5f;
    protected static final int Giant_COUNT = 1;
    protected static final int Giant_DAMAGE = 126;
    protected static final int Giant_HP = 2000;
    protected static final Range Giant_RANGE = Range.MELEE;
    protected static final Target Giant_TARGET = Target.BULDINGS_TARGET;

    // create Giant features
    protected static final int Valkyrie_COST = 4;
    protected static final String Valkyrie_IMAGE = "res//drawable//valkCard.png";
    protected static final URI Valkyrie_SOUND = null;
    protected static final float Valkyrie_HIT_SPEED = 1.5f;
    protected static final int Valkyrie_COUNT = 1;
    protected static final int Valkyrie_DAMAGE = 120;
    protected static final int Valkyrie_HP = 880;
    protected static final Range Valkyrie_RANGE = Range.MELEE;
    protected static final Target Valkyrie_TARGET = Target.GROUND_TARGET;
}
