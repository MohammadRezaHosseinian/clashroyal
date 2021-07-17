package code.heros;

import code.card.Speed;
import javafx.scene.image.ImageView;

public class MyHero extends BaseHero implements CanWalk{
    public MyHero(ImageView imageView, int hp, Position pos, Speed speed) {
        super(imageView, hp, pos, speed);
    }


    @Override
    public Position findNextAim() {
        return new Position(0, 0);
    }


    @Override
    public void run()  {
        while (isAlive) {
            this.walk();
            this.checkIsAlive();
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void walk() {
        Position aim = this.findNextAim();
        double m = (aim.getHeight() - currnetPos.getHeight())/(aim.getWidth() - currnetPos.getWidth());
        double y = currnetPos.getHeight() + sign(aim.getHeight() - currnetPos.getHeight());
        double x = currnetPos.getWidth() + sign(aim.getWidth() - currnetPos.getWidth());
        this.currnetPos = new Position(x, y);

    }

    private double sign(double x){
        if(x == 0)
            return 0;
        if(x > 0)
            return 1;
        return -1;
    }

    public void changePos(){
        this.imageView.setX(currnetPos.getWidth());
        this.imageView.setY(currnetPos.getHeight());
    }

}
