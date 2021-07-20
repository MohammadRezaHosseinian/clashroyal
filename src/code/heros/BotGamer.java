package code.heros;

import code.card.AbstractBaseCard;
import code.controllers.GameManager;

import java.util.ArrayList;
import java.util.Random;

public class BotGamer implements GamerImpl, Runnable{

    private BotLevel level;
    private String name;
    private int elixir;
    private GameManager manager;
    private Team team;
    private ArrayList<AbstractBaseCard> allCards;

    public BotGamer(GameManager manager, BotLevel level, String name){
        this.level = level;
        this.name = name;
        this.elixir = 10;
        this.manager = manager;
        this.team = Team.UP_SIDE_TEAM;
        this.allCards = ScreenObjectBuilder.getAllCards();
    }


    @Override
    public AbstractBaseCard selectCard() {
        ArrayList<AbstractBaseCard> availableCards = new ArrayList<>();
        System.out.println(String.format("-------[%d]-------", getElixir()));
        for(AbstractBaseCard card : allCards){
            if(card.getCost() < getElixir()){
                System.out.println(card.getClass().getSimpleName());
                availableCards.add(card);
            }
        }
        int len = availableCards.size();
        if(len <= 0)
            return null;
        Random rand = new Random();
        return availableCards.get(rand.nextInt(len));
    }

    @Override
    public Position selectPos() {
        return new Position(5,5);
    }

    @Override
    public void play() throws InterruptedException{
        Random rand = new Random();
        long randSleepTime = rand.nextInt(4000);
        Thread.sleep(8000 + randSleepTime);
        Position pos = this.selectPos();
        AbstractBaseCard card = this.selectCard();
        if(card == null)
            return;
        this.updateElixir(-1 * card.getCost());
        ScreenObject obj = ScreenObjectBuilder.build(card, pos, team);
        this.manager.addElement(obj);
    }

    @Override
    public boolean isAlive() {
        return true;
    }


    @Override
    public void updateElixir(int v) {
        if(elixir+v <= 10 && elixir + v >= 0)
            this.elixir += v;
    }

    @Override
    public int getElixir() {
        return this.elixir;
    }

    @Override
    public void run() {
        while (this.isAlive()){
            try {
                Thread.sleep(2000);
                updateElixir(1);
                play();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
