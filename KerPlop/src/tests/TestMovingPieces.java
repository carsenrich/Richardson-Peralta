package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import levelPieces.Raptor;
import levelPieces.TRex;

class TestMovingPieces {

	// tests that Raptor randomly moves one space left or right
	// only if both spaces are available
	@Test
	public void testRaptorMovesOneSpace() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Raptor raptor = new Raptor(12);
		gameBoard[12] = raptor;
		
		raptor.move(gameBoard, 0);
		
		int newLocation = raptor.getLocation();
		
		assertTrue(newLocation == 11 || newLocation == 13);
		
		assertSame(raptor, gameBoard[newLocation]);
		assertNull(gameBoard[12]);
	
	}
	
	// tests that TRex moves one space to the left
	@Test
	public void testTRexMovesLeft() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		TRex trex = new TRex(12);
		gameBoard[12] = trex;
		
		trex.move(gameBoard, 0);
		
		assertEquals(11, trex.getLocation());
		assertSame(trex, gameBoard[11]);
		assertNull(gameBoard[12]);
		
	}
		

}
