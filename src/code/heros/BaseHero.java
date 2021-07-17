package code.heros;

import code.card.Speed;
import javafx.concurrent.Task;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class BaseHero  implements Runnable{

    protected boolean isAlive;
    protected int hp;
    protected Position currnetPos ;
    protected Speed speed;
    protected ImageView imageView;

    public  BaseHero(ImageView imageView, int hp, Position pos, Speed speed){
        this.imageView = imageView;
        this.isAlive = true;
        this.hp = hp;
        this.currnetPos = pos;
        this.speed = speed;
    }

    protected void checkIsAlive(){
        if(hp <= 0)
            this.isAlive = false;
    }
    public abstract Position findNextAim();

}
