package code.heros;

import code.card.Range;
import code.card.Speed;
import javafx.scene.image.ImageView;

public class WizardHero extends BaseHero implements Fightable, CanMakeSound, CanWalk, DieAble{

    public WizardHero(ImageView imageView, int hp, Position pos, Speed speed) {
        super(imageView, hp, pos, speed);
    }

    @Override
    public Position findNextAim() {
        return null;
    }

    @Override
    public void run() {

    }

    @Override
    public void fight() {

    }

    @Override
    public Fightable getNeartarget() {
        return null;
    }

    @Override
    public Range getRangFight() {
        return null;
    }

    @Override
    public boolean CanAreaSlpash() {
        return false;
    }

    @Override
    public double getHitSpeed() {
        return 1.7;
    }

    @Override
    public void playSound() {

    }

    @Override
    public void walk() {

    }

    @Override
    public void die() {

    }
}
