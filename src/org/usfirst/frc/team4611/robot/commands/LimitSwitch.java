package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
public class LimitSwitch extends Command{

	//Closed = true
	boolean normalOpenSwitch;
	public LimitSwitch(boolean normalOpen) {
		normalOpenSwitch = normalOpen;
	}
	
	

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
