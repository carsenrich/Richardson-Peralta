/*
 * Class: Mountain class, implements Drawable. This is the one item that does not interact with the player
 * Authors: Carmela Richardson and Frank Peralta
 * Date: 9/6/26
 * 
 */

package levelPieces;

import gameEngine.Drawable;


public class Mountain implements Drawable{
	
	private char symbol = 'M';
	private int location;
	
	public Mountain(int location) {
		this.location = location;
	}

	@Override
	public void draw() {
		System.out.println(symbol);
		
	}

	public int getLocation() {
		return location;
	}
	
	
	
}

	