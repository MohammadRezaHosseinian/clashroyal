package code.heros;

import code.card.*;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class ScreenObjectBuilder {

    public static ScreenObject build(AbstractBaseCard card, Position pos, Team team){
        Troop t = (Troop) card;
        if(t instanceof Archer)
            return new ArcherHero(new Image("res//drawable//archer.png"), pos, team);
        if(t instanceof Barbarians)
            return new BarbarianceHero(new Image("res//drawable//barbar.png"), pos, team);
        if(t instanceof BabyDragon)
            return new BabyDragonHero(new Image("res//drawable//babyDragon.png"), pos, team);
        if(t instanceof Wizard)
            return new WizardHero(new Image("res//drawable//wizard.png"), pos, team);
        if(t instanceof Giant)
            return new GiantHero(new Image("res//drawable//giant.png"), pos, team);
        if(t instanceof Valkyrie)
            return new ValkyrieHero(new Image("res//drawable//valkyrie.png"), pos, team);
        if (t instanceof MiniPEKKA)
            return new MiniPEKKAHero(new Image("res//drawable//miniPEKKA.png"), pos, team);
        return null;
    }

    public static ArrayList<AbstractBaseCard> getAllCards(){
        ArrayList<AbstractBaseCard> cards = new ArrayList<>();
        cards.add(new BabyDragon(Builders.CreateBabyDragonBuilder()));
        cards.add(new Barbarians(Builders.CreateBarbariansBuilder()));
        cards.add(new Archer(Builders.CreateArcherBuilder()));
        cards.add(new Wizard(Builders.CreateWizardBuilder()));
        cards.add(new MiniPEKKA(Builders.CreateMiniPEKKABuilder()));
        cards.add(new Giant(Builders.CreateGiantBuilder()));
        cards.add(new Valkyrie(Builders.CreateValkyrieBuilder()));
        return cards;
    }

}
