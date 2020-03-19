import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

public class sounds2 {
	
	public static void main(String[] args) {

		Sound.beepSequence();
		Sound.beepSequenceUp();
		LCD.drawString("done!", 6, 4);
		//Sound.systemSound(false, 4);
		Button.ENTER.waitForPressAndRelease();
			
			
	}
}
//sounds should play at the end when the robot is back at the original position
