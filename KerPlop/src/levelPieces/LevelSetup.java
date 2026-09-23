package levelPieces;

import java.util.ArrayList;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.Moveable;


public class LevelSetup {
	
	private Drawable[] gameBoard;
	private ArrayList<Moveable> movingPieces;
	private ArrayList<GamePiece> interactingPieces;
	private int playerStartLoc;
	

	public LevelSetup() {
		super();
	}

	public void createLevel(int levelNum) {
		
		gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		movingPieces = new ArrayList<Moveable>();
		interactingPieces = new ArrayList<GamePiece>();
		
		if (levelNum == 1) {
			
			playerStartLoc =10 ; 
					
			TRex trex = new TRex(18); 
			
			gameBoard[trex.getLocation()]= trex;
			movingPieces.add(trex);
			interactingPieces.add(trex);
			
			
			
		}else if (levelNum == 2) {
			
			
		}
		
		
		
	}

	public ArrayList<Moveable> getMovingPieces() {
		return movingPieces;
	}

	public Drawable[] getBoard() {
		return gameBoard;
	}

	public ArrayList<GamePiece> getInteractingPieces() {
		return interactingPieces;
	}

	public int getPlayerStartLoc() {
		return playerStartLoc;
	}
	
	

}
