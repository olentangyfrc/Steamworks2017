package org.usfirst.frc.team4611.robot.commands;
import org.usfirst.frc.team4611.robot.Robot;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class startAuton extends CommandGroup{
	public startAuton() {
		String side = "";//This is where Hannah said she could get me something for smart dashboard
		
		//use the identifiers Boiler, Loader or middle (or you can just use Boiler and Loader)
		
		if(Robot.alliance == Robot.red) {//this checks what alliance we are on so we know the field layout
			if(side == "Boiler") {	
				genericAutoSideCommand(1);//-1 if you want to turn right and 1 if you want to turn left
			}
			else if(side == "Loader") {
				genericAutoSideCommand(-1);
			}
			else {//if it is not either the loader or the boiler it is the middle and runs the middle program
				startMiddle();
			}
		}
		else if(Robot.alliance == Robot.blue) {//this is the same as the above one that has been changed for the blue alliance side of the field
			if(side == "Boiler") {
				genericAutoSideCommand(-1);
			}
			else if(side == "Loader")
			{
				genericAutoSideCommand(1);
			}
			else {
				startMiddle();
			}
		}
		else
			System.out.println("Panic");// in case of tactical emergency
	}
	//-1 is for the right and 1 left
	public void genericAutoSideCommand(int direction) {
		addSequential(new driveAuto(-0.6),0.75); //Drive forward			
		addSequential(new turnAuto(direction, 0.55), 0.45); //Turn left
		addSequential(new driveAuto(-0.6),0.75); //Drive forward again
		addSequential(new autoAim(0.55), 0.45); //Turn using VA
		addSequential(new ultraDrive(.45), 2); //Go forward until you hit
		addSequential(new driveAuto(0),0.1); //Stop driving
		addSequential(new MoveTestSolenoid(), 1); //Open solenoid
		addParallel(new autoFeeder(0.75), 1); //Run the feeder
		addSequential(new driveAuto(0.5), 1.5); //Drive backwards
		addSequential (new driveAuto(0),0.1); //Stop driving backwards
		addParallel(new autoFeeder(0), 0.1); //Stop running the feeder
		addParallel(new CloseTestSolenoid(), 1); //Close the solenoid 
		addSequential(new driveAuto(0.55), 1);//Drive back
		addSequential (new driveAuto(0),0.1); //Stop driving
	}
	public void startMiddle() {
		addSequential(new driveAuto(-.6), .5);//drive forward
		addSequential(new driveAuto(0), .1);//stop
		addSequential(new driveAuto(-.6), .5);//drive forward
		addSequential(new driveAuto(0), .1);//stop
		addSequential(new driveAuto(.6), .5);//backup
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
