package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.OI;
import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Command;

public class relaySpike extends Command{

	public void light(boolean x)
	{
		if(x = true)
			OI.spike.set(Relay.Value.kOn);
		if(x = false)
			OI.spike.set(Relay.Value.kOff);
	}
	
	protected void execute(){
		light(true);
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	protected void end(){
		light(false);
	}
}
