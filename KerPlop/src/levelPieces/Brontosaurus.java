/*
 * Class: Brontosaurus class, extends the Gamepiece abstract class.
 * The Brontosaurus is not moveable, its interaction result is ADVANCE.
 * Authors: Carmela Richardson and Frank Peralta
 * Date: 9/23/26
 *
 */

package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Brontosaurus extends GamePiece {

    public Brontosaurus(int location) {
        super('B', "Brontosaurus", location);
    }

    // Interaction result is advance if player lands on same spot as Brontosaurus
    @Override
    public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {

        if (playerLocation == getLocation()) {
            return InteractionResult.ADVANCE;
        }

        return InteractionResult.NONE;
    }
}