package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gameEngine.GameEngine;
import gameEngine.Drawable;
import gameEngine.InteractionResult;
import levelPieces.Brontosaurus;

class BrontosaurusTest {

	@Test
	public void testBrontosaurus() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Brontosaurus bronto = new Brontosaurus(12);
		gameBoard[12] = bronto;
		
		// Advance if on same space
		assertEquals(InteractionResult.ADVANCE, bronto.interact(gameBoard, 12));
		
		// These loops ensure no interaction if not on same space
		for (int i=0; i<12; i++)
			assertEquals(InteractionResult.NONE, bronto.interact(gameBoard, i));
		for (int i=13; i<GameEngine.BOARD_SIZE; i++)
			assertEquals(InteractionResult.NONE, bronto.interact(gameBoard, i));
		
	}

}
