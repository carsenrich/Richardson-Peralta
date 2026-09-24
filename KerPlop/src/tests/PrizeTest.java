package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gameEngine.GameEngine;
import gameEngine.Drawable;
import gameEngine.InteractionResult;
import levelPieces.Prize;

class PrizeTest {

	@Test
	public void testPrize() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Prize prize = new Prize(12);
		gameBoard[12] = prize;
		
	    // Interaction result is GET_POINT if player lands on same spot as Prize
		assertEquals(InteractionResult.GET_POINT, prize.interact(gameBoard, 12));
		
		// These loops ensure no interaction if not on same space
		for (int i=0; i<12; i++)
			assertEquals(InteractionResult.NONE, prize.interact(gameBoard, i));
		for (int i=13; i<GameEngine.BOARD_SIZE; i++)
			assertEquals(InteractionResult.NONE, prize.interact(gameBoard, i));
	}

}
