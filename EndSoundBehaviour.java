package newLejos;
import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.robotics.Touch;
import lejos.robotics.subsumption.Behavior;


public class EndSoundBehaviour implements Behavior  {
	EV3TouchSensor touchSensor = new EV3TouchSensor(SensorPort.S4);
	SensorMode touch = touchSensor.getTouchMode();
	float[] sample = new float[touch.sampleSize()];
	
	

	
	@Override
	public boolean takeControl() {
		touch.fetchSample(sample,0);
	
		//if touch sensor is pressed return true and play sound
		if (sample[0] == 0){
			return false;
		}
		else{return true;}
		
	}

	@Override
	public void action() {
		Sound.beepSequence();
		Sound.beepSequenceUp();
		LCD.drawString("done!", 6, 4);
		//Sound.systemSound(false, 4);
	//	Button.ENTER.waitForPressAndRelease();
		// TODO Auto-generated method stub
		
	}

	@Override
	public void suppress() {
		Button.ENTER.waitForPressAndRelease();
		// TODO Auto-generated method stub
		
	}

}
