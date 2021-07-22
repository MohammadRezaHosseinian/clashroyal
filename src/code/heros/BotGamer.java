package code.heros;

/*
 **
 * this class handle bot game
 **
 */
import code.card.AbstractBaseCard;
import code.controllers.GameManager;

import java.util.ArrayList;
import java.util.Random;

public class BotGamer implements GamerImpl, Runnable{

    private BotLevel level;
    private final String name;
    private int elixir;
    private GameManager manager;
    private final Team team;
    private final ArrayList<AbstractBaseCard> allCards;
    private final int maxX = 600;
    private final int maxY = 200;

    public BotGamer(GameManager manager, String name){
        this.level = BotLevel.LEVEL_1;
        this.name = name;
        this.elixir = 10;
        this.manager = manager;
        this.team = Team.UP_SIDE_TEAM;
        this.allCards = ScreenObjectBuilder.getAllTroops();
    }

    public void setManager(GameManager m){
        this.manager = m;
    }

    @Override
    public AbstractBaseCard selectCard() {
        ArrayList<AbstractBaseCard> availableCards = new ArrayList<>();
//        System.out.println(String.format("-------[%d]-------", getElixir()));
        for(AbstractBaseCard card : allCards){
            if(card.getCost() < getElixir()){
//                System.out.println(card.getClass().getSimpleName());
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
        Random random = new Random();
        return new Position(random.nextInt(this.maxX),random.nextInt(this.maxY));
    }

    @Override
    public void play() throws InterruptedException{
        Random rand = new Random();
        long randSleepTime = rand.nextInt(4000);
        Thread.sleep(100 + randSleepTime);
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
                updateElixir(2);
                play();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public BotLevel getLevel(){
        return this.level;
    }

    public void setLevel(BotLevel l){
        this.level = l;
    }
}
