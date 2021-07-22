package code.castles;

/*
 **
 * this class create king castle
 **
 */
import code.heros.Dimension;
import code.heros.Position;
import code.heros.Team;
import javafx.scene.image.Image;

public class KingCastle extends BaseCastle{
    public KingCastle(Image img, Team team, Position pos) {
        super(img, team, pos, new Dimension(80,100), 2400, 7, 50, 1);
    }
}
