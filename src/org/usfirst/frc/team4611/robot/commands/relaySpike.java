package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.OI;
import org.usfirst.frc.team4611.robot.RobotMap;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Direction;
import edu.wpi.first.wpilibj.command.Command;

public class relaySpike extends Command{
	
	public static Relay spike;
	
	public relaySpike(int p,Direction d){//p is port
		spike = new Relay(p, d);
	}
	
	protected void execute(){
		spike.set(Relay.Value.kOn);
		//turns light on? connor needs to work on commenting
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	protected void end(){
		spike.set(Relay.Value.kOff);
		//turns light off? connor needs to work on commenting
	}
}
