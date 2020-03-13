import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;


public class WelcomeScreen {
	
	public static void main (String[] args) {
		
		
		Button.ENTER.waitForPressAndRelease();
		LCD.drawString("Welcome", 5,5);
		LCD.drawString("By Abdallah, Aoife, Hyun, Stefanie", 5,8);
		LCD.drawString("Version 1", 5,12);
		
		Button.ENTER.waitForPressAndRelease();
		LCD.clear();

}}
