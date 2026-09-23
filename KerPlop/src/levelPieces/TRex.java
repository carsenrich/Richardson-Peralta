/*
 * Class: TRex class, extends the Gamepiece abstract class. The TRex is moveable, its interaction
 * result is KILL. This class allows interaction at a distance. If Player is within 2 spots, it will Kill
 * Player
 * Authors: Carmela Richardson and Frank Peralta
 * Date: 9/6/26
 * 
 */
package levelPieces;
import gameEngine.Moveable;
import gameEngine.Drawable;
import gameEngine.InteractionResult;


public class TRex extends GamePiece implements Moveable{

	public TRex(int location) {
		super('T', "T-Rex", location);
		
	}
	
	
	//The TRex is moveable and moves 1 space left each time it moves
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		
		int currentLocation = getLocation();
		int newLocation = currentLocation -1;
		
		//TRex should not move off of the board
		//TRex should only move if new spot is empty
		if (newLocation >= 0 && gameBoard[newLocation] == null) {
			
			//remove from old location
			gameBoard[currentLocation] = null;
			
			//place in new location
			gameBoard[newLocation] = this;
			
			//set location using setter
			setLocation(newLocation);
		}
		
		
	}
	
	//TRex interaction is kill if Player is within 2 spots of it
	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		
		if(Math.abs(playerLocation - getLocation()) <=2) {
			return InteractionResult.KILL;
		}
		
		return InteractionResult.NONE;
		
	}

		
}
