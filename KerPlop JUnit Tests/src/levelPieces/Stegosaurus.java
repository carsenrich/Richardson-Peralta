/*
 * Class: Stegosaurus. Stationary piece that hits the player only on the same space.
 * Authors: Carmela Richardson and Frank Peralta
 * Date: 9/23/26
 * 
 */

package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Stegosaurus extends GamePiece {
	
	public Stegosaurus(int location) {
		super('S', "Stegosaurus", location);
	}
	
	// Hits player on same space
	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		
		if (playerLocation == getLocation()) {
			return InteractionResult.HIT;
		}
		
		// No effect when the player is outside interaction range
		return InteractionResult.NONE;
	}

}

