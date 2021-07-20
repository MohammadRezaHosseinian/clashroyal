package code.card;

import java.net.URI;

public abstract class AbstractBaseCard{
    protected String imageUri;
    protected URI soundUri;
    protected int cost;

    public AbstractBaseCard(int cost, String img, URI sound){
        this.cost = cost;
        this.imageUri = img;
        this.soundUri = sound;
    }

    public int getCost(){
        return this.cost;
    }


    public String getImageUri(){
        return this.imageUri;
    }

    public URI getSoundUri(){
        return this.soundUri;
    }


}
