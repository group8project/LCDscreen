package newLejos;
import lejos.robotics.navigation.MovePilot;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import lejos.robotics.navigation.MovePilot;
public class StartEndMaze {
	//private static MovePilot turner;
	
	
	public static void main(String[] args) {
		
		Behavior b1 = new EndSoundBehaviour();
	   // Behavior b2 = new LowBattery();
	   //  Behavior b3 = new PickUpObjectBehaviour(turner);
		
		 Behavior [] bArray = {b1};
	     Arbitrator arby = new Arbitrator(bArray);
	     arby.go();
	}}
	

//http://www.lejos.org/nxt/nxj/tutorial/Behaviors/BehaviorProgramming.htm