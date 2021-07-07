package code.card;

import java.net.URI;

public class AbstractBaseCard {
    protected URI imageUri;
    protected URI soundUri;
    protected int cost;

    public AbstractBaseCard(int cost, URI img, URI sound){
        this.cost = cost;
        this.imageUri = img;
        this.soundUri = sound;
    }

    
}
