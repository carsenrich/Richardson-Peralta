/*
 * Class: Raptor. Moves randomly to the left or right and hits the player on the same
 * or adjacent space
 * Authors: Carmela Richardson and Frank Peralta
 * Date: 9/23/26
 */

package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;
import java.util.Random;

public class Raptor extends GamePiece implements Moveable {
	
	private Random random = new Random();
	
	// Creates the Raptor at starting location
	public Raptor(int location ) {
		super('R', "Raptor", location);
	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		int currentLocation = getLocation();
		
		// Randomly moves one space to the left or right
		int direction = random.nextBoolean() ? -1 : 1;
		int newLocation = currentLocation + direction;
		
		// Stays still if next space is off the board or taken
		if (newLocation >= 0
				&& newLocation < gameBoard.length
				&& gameBoard[newLocation] == null) {
			
			// Updates the board and raptor's location
			gameBoard[currentLocation] = null;
			gameBoard[newLocation] = this;
			setLocation(newLocation);
		}
	}
	
	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		
		// Hits the player when they are max one space away
		if (Math.abs(playerLocation - getLocation()) <= 1) {
			return InteractionResult.HIT;
		}
		
		// No effect when the player is outside interaction range
		return InteractionResult.NONE;
	}

}
