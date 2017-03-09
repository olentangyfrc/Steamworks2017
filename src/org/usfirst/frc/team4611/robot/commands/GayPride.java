package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class GayPride extends CommandGroup{
	
	public GayPride(){
		Timer t = new Timer();
		t.start();
		
		if(t.hasPeriodPassed(1)){
			Robot.fl.makeRed();
		}
		if(t.hasPeriodPassed(2)){
			Robot.fl.makeYellow();
		}
		if(t.hasPeriodPassed(3)){
			Robot.fl.makeGreen();
		}
		if(t.hasPeriodPassed(4)){
			Robot.fl.makeCyan();
		}
		if(t.hasPeriodPassed(5)){
			Robot.fl.makeBlue();
		}
		if(t.hasPeriodPassed(6)){
			Robot.fl.makePurple();
		}
		if(t.hasPeriodPassed(9)){
			Robot.fl.makeAmericaGreatAgain();
		}
		if(t.hasPeriodPassed(10)){
			Robot.fl.turnOff();
		}
		
			
    
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
