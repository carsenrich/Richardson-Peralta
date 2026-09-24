package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import gameEngine.Drawable;
import levelPieces.Triceratops;

class TriceratopsTest {

	@Test
	public void testTriceratops() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Triceratops tricera = new Triceratops(12);
		gameBoard[12] = tricera;
		
		// Hit points only if player is on same or adjacent spot
		assertEquals(InteractionResult.HIT, tricera.interact(gameBoard, 11));
		assertEquals(InteractionResult.HIT, tricera.interact(gameBoard, 12));
		assertEquals(InteractionResult.HIT, tricera.interact(gameBoard, 13));
		
		// These loops ensure no interaction if not on same space
		for (int i=0; i<11; i++)
			assertEquals(InteractionResult.NONE, tricera.interact(gameBoard, i));
		for (int i=14; i<GameEngine.BOARD_SIZE; i++)
			assertEquals(InteractionResult.NONE, tricera.interact(gameBoard, i));
	}

}
