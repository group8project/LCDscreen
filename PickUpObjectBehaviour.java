package newLejos;

import lejos.hardware.Button;
import lejos.hardware.motor.BaseRegulatedMotor;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;
import lejos.robotics.chassis.Chassis;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;
import lejos.robotics.navigation.MovePilot;
import lejos.robotics.subsumption.Behavior;



public class PickUpObjectBehaviour implements Behavior {
	//private MovePilot turner1;
	//private EV3UltrasonicSensor us=new EV3UltrasonicSensor(SensorPort.S1);
	//private SampleProvider sp = us.getDistanceMode();
//	private float[] samples = new float[1];
	
	
	EV3UltrasonicSensor us1 =new EV3UltrasonicSensor(SensorPort.S2);
	SampleProvider sp1 = us1.getDistanceMode();
	float[] samples1 = new float[sp1.sampleSize()];	
	
	
	BaseRegulatedMotor mLeft = new EV3LargeRegulatedMotor(MotorPort.A);
	BaseRegulatedMotor mRight = new EV3LargeRegulatedMotor(MotorPort.D);

	// create a wheel with Diameter 51mm and offset 22mm left of centre
	Wheel wLeft = WheeledChassis.modelWheel(mLeft, 56).offset(-200 / 2);

	// create wheel with Diameter 51mm and offset 22mm right of centre
	Wheel wRight = WheeledChassis.modelWheel(mRight, 56).offset(200 / 2);

	// create a chassis with two wheels on it
	Chassis chassis = new WheeledChassis((new Wheel[] { wRight, wLeft }), WheeledChassis.TYPE_DIFFERENTIAL);

	// finally create a pilot which can drive its wheel separately
	MovePilot turner1 = new MovePilot(chassis);
	
	


	@Override
	public boolean takeControl() {
		
		
		
	sp1.fetchSample(samples1, 0);	
		
		if (samples1[0] < 0.05f) {
			return true;}
	    else {
	    	turner1.travel(10);
	    	return false;}
	}
		
		
		
	
		// TODO Auto-generated method stub


	@Override
	public void action() {
	
	//	final static float WHEEL_DIAMETER = 56; // Diameter of the wheels (mm)
	//	final static float AXLE_LENGTH = 200; // Distance of the two driven wheels
	//	final static float AGULAR_SPEED = 100; // How fast it turns corners (degrees/sec)
	//	final static float LINEAR_SPEED = 35; // How fast in a straight line (mm/sec)
		
		mLeft . setSpeed (720); // 2 Revolutions Per Second ( RPS )
		mRight . setSpeed (720);
		turner1.travel(-50);
		turner1.rotate(100);
		mLeft . setSpeed (100); // 2 Revolutions Per Second ( RPS )
		mRight . setSpeed (100);
		turner1.travel(-40);
		
	//	us1.close();
		
	}
		
	

	@Override
	public void suppress() {
		Button.ENTER.waitForPressAndRelease();
	}
		// TODO Auto-generated method stub
		
	}
