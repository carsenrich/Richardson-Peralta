/*
 * Class: Pterodactyl. Stationary piece that advances the player on the same or an adjacent space.
 * Authors: Carmela Richardson and Frank Peralta
 * Date: 9/23/26
 * 
 */

package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Pterodactyl extends GamePiece {
	
	public Pterodactyl(int location) {
		super('D', "Pterodactyl", location);
	}
	
	// Advances player on same or adjacent space
	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		
		if (Math.abs(playerLocation - getLocation()) <= 1) {
			return InteractionResult.ADVANCE;
		}
		
        // No effect when the player is outside interaction range
		return InteractionResult.NONE;
	}

}

