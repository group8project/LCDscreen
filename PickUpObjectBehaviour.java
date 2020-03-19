package newLejos;

import lejos.hardware.Button;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;
import lejos.robotics.navigation.MovePilot;
import lejos.robotics.subsumption.Behavior;
public class PickUpObjectBehaviour implements Behavior {
	private MovePilot turner;
	private EV3UltrasonicSensor us=new EV3UltrasonicSensor(SensorPort.S1);
	private SampleProvider sp = us.getDistanceMode();
	private float[] samples = new float[1];
	
	public PickUpObjectBehaviour(MovePilot p) {
	turner = p;
	}
	public void action() {
		turner.travel(-10);
	//	turner.rotate(180);
	//	turner.travel(-10);
		}
	
	public void suppress() {
		Button.ENTER.waitForPressAndRelease();
		//makes action stop
	}
	public boolean takeControl() {
		sp.fetchSample(samples, 0);
		return (samples[1] < 0.05f);
		}
		}