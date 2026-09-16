/*
 * Class: Setting Class, this is an enum class that holds settings as enums.
 * These are listed as Off, Low, Medium, and High with string values in either - or + combinations.
 * Authors: Carmela Richardson and Frank Peralta
 * Date: 9/16/26
 * 
 */
public enum Setting{
		OFF("---"),LOW("--+"), MEDIUM("-++"), HIGH("+++");
		
	private String display;
		
	Setting (String aValue){
			this.display= aValue;
	}
	
	@Override
	public String toString() {
		return display;
	}
}

