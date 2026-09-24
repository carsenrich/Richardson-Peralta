package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gameEngine.GameEngine;
import gameEngine.Drawable;
import gameEngine.InteractionResult;
import levelPieces.Stegosaurus;

class StegosaurusTest {

	@Test
	public void testStegosaurus() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Stegosaurus stego = new Stegosaurus(12);
		gameBoard[12] = stego;
		
		// Hit points only if player on same space
		assertEquals(InteractionResult.HIT, stego.interact(gameBoard, 12));
		
		// These loops ensure no interaction if not on same space
		for (int i=0; i<12; i++)
			assertEquals(InteractionResult.NONE, stego.interact(gameBoard, i));
		for (int i=13; i<GameEngine.BOARD_SIZE; i++)
			assertEquals(InteractionResult.NONE, stego.interact(gameBoard, i));
		
	}

}
