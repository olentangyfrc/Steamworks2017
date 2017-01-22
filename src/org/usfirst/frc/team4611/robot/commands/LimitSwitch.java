package org.usfirst.frc.team4611.robot.commands;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
public class LimitSwitch extends Command{
	 public DigitalInput limitSwitch;

	//Closed = true
	boolean normalOpenSwitch;
	public LimitSwitch(boolean normalOpen) {		
		normalOpenSwitch = normalOpen;
	}
	
	public boolean isClosed(){
		boolean status = limitSwitch.get();
		//This is a normally closed switch which inverts the value
		if(!normalOpenSwitch){
			status = !status;		
		}
		return status;
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
