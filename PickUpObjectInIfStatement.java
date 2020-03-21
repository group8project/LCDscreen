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
	MovePilot turner = new MovePilot(chassis);
	
	
	 
	 
	sp1.fetchSample(samples1, 0);	
		     
	 while(samples1[0] > 0.05f){   
	  	 turner.travel(100);
	  	 sp1.fetchSample(samples1, 0);	
		
	  	 }
	  turner.travel(-50);
	  turner.rotate(115);
	  turner.travel(-20);
	  turner.stop(); 	 
	  	 