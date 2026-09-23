/*
 * Class: Prize class, extends the Gamepiece abstract class. The Prize is not moveable, its interaction
 * result is GET_POINT.
 * Authors: Carmela Richardson and Frank Peralta
 * Date: 9/6/26
 *
 */

package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Prize extends GamePiece {

    public Prize(int location) {
        super('$', "Prize", location);
    }

    // Interaction result is GET_POINT if player lands on same spot as Prize
    @Override
    public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {

        if (playerLocation == getLocation()) {
            return InteractionResult.GET_POINT;
        }

        return InteractionResult.NONE;
    }
}