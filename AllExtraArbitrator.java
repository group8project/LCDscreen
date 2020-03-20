package newLejos;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
public class SoundAndLowBatteryBehaviorArbitrator {
	//private static MovePilot turner;
	
	
	public static void main(String[] args) {
		
		Behavior b1 = new EndSoundBehaviour();
	    Behavior b2 = new LowBattery();
	    Behavior b3 = new PickUpObjectBehaviour();
	    
	    //maybe put pickUpObjectBehavior in another array
		
		 Behavior [] bArray = {b3};
	     Arbitrator arby = new Arbitrator(bArray);
	     arby.go();
	}}
	

//http://www.lejos.org/nxt/nxj/tutorial/Behaviors/BehaviorProgramming.htm