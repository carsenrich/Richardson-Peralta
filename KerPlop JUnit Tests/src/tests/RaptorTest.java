package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import gameEngine.Drawable;
import levelPieces.Raptor;

class RaptorTest {

	@Test
	public void testRaptor() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Raptor raptor = new Raptor(12);
		gameBoard[12] = raptor;
		
		// Hits the player when they are max one space away
		assertEquals(InteractionResult.HIT, raptor.interact(gameBoard, 11));		assertEquals(InteractionResult.HIT, raptor.interact(gameBoard, 12));
		assertEquals(InteractionResult.HIT, raptor.interact(gameBoard, 13));
		
		// These loops ensure no interaction if not on same space
		for (int i=0; i<10; i++)
			assertEquals(InteractionResult.NONE, raptor.interact(gameBoard, i));
		for (int i=15; i<GameEngine.BOARD_SIZE; i++)
			assertEquals(InteractionResult.NONE, raptor.interact(gameBoard, i));
		
	}
	
	@Test
	public void testRaptorMovesOneSpace() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Raptor raptor = new Raptor(12);
		gameBoard[12] = raptor;
		
		raptor.move(gameBoard, 0);
		
		int newLocation = raptor.getLocation();
		
		// Random movement in either direction
		assertTrue(newLocation == 11 || newLocation == 13);
		
		// Board and location must agree
		assertSame(raptor, gameBoard[newLocation]);
		assertNull(gameBoard[12]);
	
	}
	
	@Test
	public void testRaptorStaysWhenBlocked() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Raptor raptor = new Raptor(12);
		Raptor leftBlocker = new Raptor(11);
		Raptor rightBlocker = new Raptor(13);
		
		gameBoard[12] = raptor;
		gameBoard[11] = leftBlocker;
		gameBoard[13] = rightBlocker;
		
		raptor.move(gameBoard, 0);
		
		// Neither random direction has empty space
		assertEquals(12, raptor.getLocation());
		assertSame(raptor, gameBoard[12]);
		assertSame(leftBlocker, gameBoard[11]);
		assertSame(rightBlocker, gameBoard[13]);
		
	}
	
	@Test
	public void testRaptorAtBoardEdges() {
		int lastSpace = GameEngine.BOARD_SIZE - 1;
		
		for (int start : new int[] {0, lastSpace}) {
			Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
			Raptor raptor = new Raptor(start);
			gameBoard[start] = raptor;
			
			raptor.move(gameBoard, 10);
			
			int location = raptor.getLocation();
			
			// Could stay put or move one space towards center or board
			if (start == 0) {
				assertTrue(location == 0 || location == 1);
			}else {
				assertTrue(location == lastSpace
						|| location == lastSpace - 1);
			}
			
			assertSame(raptor, gameBoard[location]);
			
			if (location != start) {
				assertNull(gameBoard[start]);
			}
		}
	}

}
