
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
		if (timer == 0) {
			return;
		}
		
		timer--;
		
		if (timer > 0) {
			return;
		}
		
		Temperature target;
		
		switch (mySetting) {
			case OFF:
				target = Temperature.COLD;
				break;
			case LOW:
				target = Temperature.WARM;
				break;
			case MEDIUM:
				target = Temperature.HOT;
				break;
			case HIGH:
				target = Temperature.BLAZING;
				break;
			default:
				throw new IllegalStateException("Unknown setting");
		}
		
		switch (myTemperature) {
			case COLD:
				if (target != Temperature.COLD) {
					myTemperature = Temperature.WARM;
				}
				break;
				
			case WARM:
				if (target == Temperature.COLD) {
					myTemperature = Temperature.COLD;
				} else if (target != Temperature.WARM) {
					myTemperature = Temperature.HOT;
				}
				break;
				
			case HOT:
				if (target == Temperature.BLAZING) {
					myTemperature = Temperature.BLAZING;
				} else if (target != Temperature.HOT) {
					myTemperature = Temperature.WARM;
				}
				break;
				
			case BLAZING:
				if (target != Temperature.BLAZING) {
					myTemperature = Temperature.HOT;
				}
				break;
		}
		
		//if more heating or cooling is needed, wait 2 mins
		if (myTemperature != target) {
			timer = TIME_DURATION;
		}
		
	}
	
	
	public void display() {
		System.out.print("[" + mySetting + "].....");
		
		switch (myTemperature) {
			case BLAZING:
				System.out.println("VERY HOT! DON'T TOUCH");
				break;
				
			case HOT:
				System.out.println("CAREFUL");
				break;
				
			case WARM:
				System.out.println("warm");
				break;
				
			case COLD:
				System.out.println("cooool");
				break;
		}
		
	}
	
	
	
}


