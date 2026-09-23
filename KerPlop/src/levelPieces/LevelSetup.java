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
			
			playerStartLoc = 10 ; 
			
			Prize prize = new Prize(5);
			gameBoard[prize.getLocation()] = prize;
			interactingPieces.add(prize);
					
			TRex trex = new TRex(18); 
			gameBoard[trex.getLocation()] = trex;
			movingPieces.add(trex);
			interactingPieces.add(trex);
			
			Mountain mountain = new Mountain(3);
			gameBoard[mountain.getLocation()] = mountain;
			
			Brontosaurus bronto = new Brontosaurus(4);
			gameBoard[bronto.getLocation()] = bronto;
			interactingPieces.add(bronto);
			
			
		}else if (levelNum == 2) {
			
			playerStartLoc = 7 ; 
			
			Prize prize = new Prize(12);
			gameBoard[prize.getLocation()] = prize;
			interactingPieces.add(prize);
					
			TRex trex = new TRex(20); 
			gameBoard[trex.getLocation()] = trex;
			movingPieces.add(trex);
			interactingPieces.add(trex);
			
			Mountain mountain = new Mountain(9);
			gameBoard[mountain.getLocation()] = mountain;
			
			Brontosaurus bronto = new Brontosaurus(18);
			gameBoard[bronto.getLocation()] = bronto;
			interactingPieces.add(bronto);
			
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
