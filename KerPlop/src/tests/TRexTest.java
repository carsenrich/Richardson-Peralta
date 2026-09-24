package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import gameEngine.Drawable;
import levelPieces.TRex;

class TRexTest {

	@Test
	public void testTRex() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		TRex trex = new TRex(12);
		gameBoard[12] = trex;
		
		// Kills if player is within 2 spots from trex
		assertEquals(InteractionResult.KILL, trex.interact(gameBoard, 10));
		assertEquals(InteractionResult.KILL, trex.interact(gameBoard, 11));
		assertEquals(InteractionResult.KILL, trex.interact(gameBoard, 12));
		assertEquals(InteractionResult.KILL, trex.interact(gameBoard, 13));
		assertEquals(InteractionResult.KILL, trex.interact(gameBoard, 14));
		
		// These loops ensure no interaction if not on same space
		for (int i=0; i<10; i++)
			assertEquals(InteractionResult.NONE, trex.interact(gameBoard, i));
		for (int i=15; i<GameEngine.BOARD_SIZE; i++)
			assertEquals(InteractionResult.NONE, trex.interact(gameBoard, i));
		
	}
	
	@Test
	public void testTRexMovesLeft() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		TRex trex = new TRex(12);
		gameBoard[12] = trex;
		
		trex.move(gameBoard, 0);
		
		// Location stored and board should both reflect the move
		assertEquals(11, trex.getLocation());
		assertSame(trex, gameBoard[11]);
		assertNull(gameBoard[12]);
		
	}
	
	@Test
	public void testTRexStaysAtLeftEdge() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		TRex trex = new TRex(0);
		gameBoard[0] = trex;
		
		trex.move(gameBoard, 10);
		
		// Unable to move left off the board
		assertEquals(0, trex.getLocation());
		assertSame(trex, gameBoard[0]);
		
	}
	
	@Test
	public void testTRexStaysWhenBlocked() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		TRex trex = new TRex(12);
		TRex blocker = new TRex(11);
		gameBoard[12] = trex;
		gameBoard[11] = blocker;
		
		trex.move(gameBoard, 0);
		
		// Both pieces remain in original spots
		assertEquals(12, trex.getLocation());
		assertSame(trex, gameBoard[12]);
		assertSame(blocker, gameBoard[11]);
	}

}
