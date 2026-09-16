
public class Burner {
	
	public enum Temperature{BLAZING, HOT, WARM, COLD};
		
		private Temperature myTemperature;

		public Temperature getTemperature() {
			return myTemperature;
		}
	
	
	private Setting mySetting;
	
	private int timer;
	
	public static final int TIME_DURATION = 2;

	public Burner() {
		super();
		myTemperature = Temperature.COLD;
		mySetting = Setting.OFF;
		timer = 0;
		
	}
	
	public void plusButton() {
		
		switch (mySetting){
			
			case OFF:
				mySetting = Setting.LOW;
				break;
				
			case LOW:
				mySetting = Setting.MEDIUM;
				break;
				
			case MEDIUM:
				mySetting = Setting.HIGH;
				break;
				
			case HIGH:
				//no change for HIGH
				break;
		}
		
		timer = TIME_DURATION;
	}
	
	public void minusButton() {
		
		switch (mySetting) {

        	case HIGH:
        		mySetting = Setting.MEDIUM;
        		break;

        	case MEDIUM:
        		mySetting = Setting.LOW;
        		break;

        	case LOW:
        		mySetting = Setting.OFF;
        		break;

        	case OFF:
        		//no change for OFF
        		break;
            
		}
		
		timer = TIME_DURATION;
	}
	
	public void updateTemperature() {
		//needs filled in
		
		
	}
	
	
	public void display() {
		//needs filled in,
		//display current burner state, current temperature, formating should match example
	}
	
	
	
}


