package code.castles;

/*
 **
 * this class create queen castle
 **
 */
import code.heros.Dimension;
import code.heros.Position;
import code.heros.Team;
import javafx.scene.image.Image;

public class QueenCastle extends BaseCastle{
    public QueenCastle(Image img, Team team, Position pos) {
        super(img, team, pos, new Dimension(30,60), 1400, 8, 50, .8);
    }
}
