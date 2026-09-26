package tests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import levelPieces.TRex;
import levelPieces.Triceratops;
import levelPieces.Prize;
import levelPieces.Brontosaurus;
import levelPieces.Pterodactyl;
import levelPieces.Stegosaurus;
import levelPieces.Raptor;

class TestInteractions {

	// tests TRex KILL when player lands within two spaces
	@Test
	public void testTRex() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		TRex trex = new TRex(12);
		gameBoard[12] = trex;
		
		assertEquals(InteractionResult.KILL, trex.interact(gameBoard, 10));
		assertEquals(InteractionResult.KILL, trex.interact(gameBoard, 11));
		assertEquals(InteractionResult.KILL, trex.interact(gameBoard, 12));
		assertEquals(InteractionResult.KILL, trex.interact(gameBoard, 13));
		assertEquals(InteractionResult.KILL, trex.interact(gameBoard, 14));
		
		// ensures no interaction if not on same space
		for (int i=0; i<10; i++)
			assertEquals(InteractionResult.NONE, trex.interact(gameBoard, i));
		for (int i=15; i<GameEngine.BOARD_SIZE; i++)
			assertEquals(InteractionResult.NONE, trex.interact(gameBoard, i));
		
	}
	
	// tests Triceratops HIT if player lands on same or adjacent space
	@Test
	public void testTriceratops() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Triceratops tricera = new Triceratops(12);
		gameBoard[12] = tricera;
		
		assertEquals(InteractionResult.HIT, tricera.interact(gameBoard, 11));
		assertEquals(InteractionResult.HIT, tricera.interact(gameBoard, 12));
		assertEquals(InteractionResult.HIT, tricera.interact(gameBoard, 13));
		
		// ensure no interaction if not on same space
		for (int i=0; i<11; i++)
			assertEquals(InteractionResult.NONE, tricera.interact(gameBoard, i));
		for (int i=14; i<GameEngine.BOARD_SIZE; i++)
			assertEquals(InteractionResult.NONE, tricera.interact(gameBoard, i));
	}
	
	// tests Prize GET_POINT if player lands on same space
	@Test
	public void testPrize() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Prize prize = new Prize(12);
		gameBoard[12] = prize;
		
		assertEquals(InteractionResult.GET_POINT, prize.interact(gameBoard, 12));
		
		// ensure no interaction if not on same space
		for (int i=0; i<12; i++)
			assertEquals(InteractionResult.NONE, prize.interact(gameBoard, i));
		for (int i=13; i<GameEngine.BOARD_SIZE; i++)
			assertEquals(InteractionResult.NONE, prize.interact(gameBoard, i));
	}
	
	// tests Brontosaurus ADVANCE if player lands on same space
	@Test
	public void testBrontosaurus() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Brontosaurus bronto = new Brontosaurus(12);
		gameBoard[12] = bronto;
		
		assertEquals(InteractionResult.ADVANCE, bronto.interact(gameBoard, 12));
		
		// ensure no interaction if not on same space
		for (int i=0; i<12; i++)
			assertEquals(InteractionResult.NONE, bronto.interact(gameBoard, i));
		for (int i=13; i<GameEngine.BOARD_SIZE; i++)
			assertEquals(InteractionResult.NONE, bronto.interact(gameBoard, i));
		
	}
	
	// tests Pterodactyl ADVANCE if player lands on same or adjacent space
	@Test
	public void testPterodactyl() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Pterodactyl ptero = new Pterodactyl(12);
		gameBoard[12] = ptero;
		
		assertEquals(InteractionResult.ADVANCE, ptero.interact(gameBoard, 11));
		assertEquals(InteractionResult.ADVANCE, ptero.interact(gameBoard, 12));
		assertEquals(InteractionResult.ADVANCE, ptero.interact(gameBoard, 13));
		
		// ensure no interaction if not in range
		for (int i=0; i<11; i++)
			assertEquals(InteractionResult.NONE, ptero.interact(gameBoard, i));
		for (int i=14; i<GameEngine.BOARD_SIZE; i++)
			assertEquals(InteractionResult.NONE, ptero.interact(gameBoard, i));
	}
	
	// tests Stegosaurus HIT if player lands on same space
	@Test
	public void testStegosaurus() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Stegosaurus stego = new Stegosaurus(12);
		gameBoard[12] = stego;
		
		assertEquals(InteractionResult.HIT, stego.interact(gameBoard, 12));
		
		// ensure no interaction if not on same space
		for (int i=0; i<12; i++)
			assertEquals(InteractionResult.NONE, stego.interact(gameBoard, i));
		for (int i=13; i<GameEngine.BOARD_SIZE; i++)
			assertEquals(InteractionResult.NONE, stego.interact(gameBoard, i));
		
	}
	
	// tests Raptor HIT if player lands max one space away
	@Test
	public void testRaptor() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Raptor raptor = new Raptor(12);
		gameBoard[12] = raptor;
		
		assertEquals(InteractionResult.HIT, raptor.interact(gameBoard, 11));		assertEquals(InteractionResult.HIT, raptor.interact(gameBoard, 12));
		assertEquals(InteractionResult.HIT, raptor.interact(gameBoard, 13));
		
		// ensure no interaction if not on same space
		for (int i=0; i<10; i++)
			assertEquals(InteractionResult.NONE, raptor.interact(gameBoard, i));
		for (int i=15; i<GameEngine.BOARD_SIZE; i++)
			assertEquals(InteractionResult.NONE, raptor.interact(gameBoard, i));
		
	}
	
	
	

}
