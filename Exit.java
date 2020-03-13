import lejos.hardware.Battery;

public class Exit {
	static int LOWBATTERY = (int) 7.8; 	
	public static void main (String[] args) {
		
		int CURRENTVOLTAGE = (int) Battery.getVoltage();
		if (CURRENTVOLTAGE<LOWBATTERY) {
			System.exit(0);
		}
	
		}
}

