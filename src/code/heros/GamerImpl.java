package code.heros;

import code.card.AbstractBaseCard;

public interface GamerImpl {
    public AbstractBaseCard selectCard();
    public Position selectPos();
    public void play() throws InterruptedException;
    public boolean isAlive();
    public void updateElixir(int v);
    public int getElixir();
}
