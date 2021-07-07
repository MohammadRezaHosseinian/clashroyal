package code.card;

import java.net.URI;

public abstract class AbstractBaseCard {
    protected URI imageUri;
    protected URI soundUri;
    protected int cost;

    public AbstractBaseCard(int cost, URI img, URI sound){
        this.cost = cost;
        this.imageUri = img;
        this.soundUri = sound;
    }

    public int getCost(){
        return this.cost;
    }

    public URI getImageUri(){
        return this.imageUri;
    }

    public URI getSoundUri(){
        return this.soundUri;
    }

    public abstract void playCard();
}
