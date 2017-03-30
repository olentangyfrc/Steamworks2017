package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.OI;
import org.usfirst.frc.team4611.robot.RobotMap;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Direction;
import edu.wpi.first.wpilibj.command.Command;

public class relaySpike extends Command{
	
	public static Relay spike;
	
	/*	
		type Value
	    kOff - Turns both relay outputs off
		kForward - Sets the relay to forward (M+ @ 12V, M- @ GND)
		kReverse - Sets the relay to reverse (M+ @ GND, M- @ 12V)
		kOn - Sets both relay outputs on (M+ @ 12V, M- @ 12V).
	*/
	
	public relaySpike(int p,Direction d){//p is port
		spike = new Relay(p, d); //instantiation of a new spike
	}
	
	protected void execute(){
		spike.set(Relay.Value.kOn); //sets both relay outputs on
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	protected void end(){
		spike.set(Relay.Value.kOff); //turns both relay out puts off
	}
}
