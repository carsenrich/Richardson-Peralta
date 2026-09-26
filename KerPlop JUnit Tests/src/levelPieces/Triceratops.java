/*
 * Class: Triceratops. Stationary piece that hits the player on the same or an adjacent space.
 * Authors: Carmela Richardson and Frank Peralta
 * Date: 9/23/26
 * 
 */

package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Triceratops extends GamePiece {
	
	public Triceratops(int location) {
		super('C', "Triceratops", location);
	}
	
	// Hits player on same or adjacent space
	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		
		if (Math.abs(playerLocation - getLocation()) <= 1) {
			return InteractionResult.HIT;
		}
		
		// No effect when the player is outside interaction range
		return InteractionResult.NONE;
	}

}
