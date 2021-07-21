package code.heros;

import code.card.AbstractBaseCard;
import code.controllers.GameManager;
import code.users.User;

public class GamePlayer implements Runnable, GamerImpl{

    private GameManager manager;
    private User user;
    private int elixir;
    private final Team team;
    private Position selectedPos;
    private AbstractBaseCard selectedCard;

    public GamePlayer(User user, GameManager manager){
        this.user = user;
        this.manager = manager;
        this.elixir = 10;
        this.team = Team.DOWN_SIDE_TEAM;
    }

    public void chooseCard(AbstractBaseCard card){
        this.selectedCard = card;
    }

    public void choosePos(Position pos){
        if(pos.getY() < 280){
            this.selectedPos = null;
            return;
        }

        this.selectedPos = pos;
    }

    @Override
    public AbstractBaseCard selectCard() {
        return this.selectedCard;
    }

    @Override
    public Position selectPos() {
        return this.selectedPos;
    }

    @Override
    public void play() throws InterruptedException {
        if(!isAlive())
            return;
        if(this.selectedPos == null)
            return;
        if(selectedCard == null)
            return;
        if(selectedCard.getCost() > this.elixir)
            return;
        AbstractBaseCard card = this.selectCard();
        Position pos = selectPos();
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
        if(this.elixir + v >=0 && this.elixir + v <= 10){
            this.elixir += v;
        }
    }

    @Override
    public int getElixir() {
        return this.elixir;
    }

    @Override
    public void run() {
        while (isAlive()){
            try {
                Thread.sleep(2000);
                this.updateElixir(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
