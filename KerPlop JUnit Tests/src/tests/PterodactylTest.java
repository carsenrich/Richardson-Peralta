package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import gameEngine.Drawable;
import levelPieces.Pterodactyl;

class PterodactylTest {

	@Test
	public void testPterodactyl() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Pterodactyl ptero = new Pterodactyl(12);
		gameBoard[12] = ptero;
		
		// Advance if player is on same or adjacent spot
		assertEquals(InteractionResult.ADVANCE, ptero.interact(gameBoard, 11));
		assertEquals(InteractionResult.ADVANCE, ptero.interact(gameBoard, 12));
		assertEquals(InteractionResult.ADVANCE, ptero.interact(gameBoard, 13));
		
		// These loops ensure no interaction if not in range
		for (int i=0; i<11; i++)
			assertEquals(InteractionResult.NONE, ptero.interact(gameBoard, i));
		for (int i=14; i<GameEngine.BOARD_SIZE; i++)
			assertEquals(InteractionResult.NONE, ptero.interact(gameBoard, i));
	}
	

}
