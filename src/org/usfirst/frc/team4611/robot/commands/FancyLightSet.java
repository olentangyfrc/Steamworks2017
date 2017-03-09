package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Direction;
import edu.wpi.first.wpilibj.command.Command;

public class FancyLightSet {
	public Relay fancyLights1;
	public Relay fancyLights2;
	
	/*	kOff - Turns both relay outputs off
	kForward - Sets the relay to forward (M+ @ 12V, M- @ GND)
	kReverse - Sets the relay to reverse (M+ @ GND, M- @ 12V)
	kOn - Sets both relay outputs on (M+ @ 12V, M- @ 12V).
	 */
	
	/**
	 *  M- for fancyLights1 must be powered for any lights to turn on
	 *  Each color has a specific pin to be grounded to turn on
	 *  Colors are red, green, blue
	 *  If all 3 are grounded lights = white
	 *  The colors that need to be off should be powered
	 *  
	 *  M+ on fancyLights1 is Green
	 *  M- on fancyLights2 is Red
	 *  M+ on fancyLights2 is Blue
	 */
	
	public FancyLightSet(){
		fancyLights1 = new Relay(RobotMap.fancyPort1, Direction.kBoth);
		fancyLights2 = new Relay(RobotMap.fancyPort2, Direction.kBoth);
	}
	
	public void show(boolean inRange, boolean gear){
		//turns lights green if in range, yellow for gear, blue if not
		if(inRange){
			makeGreen();
		}
		else if (gear){
			makeAmericaGreatAgain();
		}
		else{
			makeBlue();
		}
	}
	
	public void makeGreen(){
		fancyLights1.set(Relay.Value.kReverse);
		fancyLights2.set(Relay.Value.kOn);
	}
	
	public void makeRed(){
		fancyLights1.set(Relay.Value.kOn);
		fancyLights2.set(Relay.Value.kForward);
	}
	
	public void makeBlue(){
		fancyLights1.set(Relay.Value.kOn);
		fancyLights2.set(Relay.Value.kReverse);
	}
	

	public void makeYellow(){
		fancyLights1.set(Relay.Value.kReverse);
		fancyLights2.set(Relay.Value.kForward);
	}
	
	public void makeCyan(){
		fancyLights1.set(Relay.Value.kReverse);
		fancyLights1.set(Relay.Value.kReverse);
	}
	
	public void makePurple(){
		fancyLights1.set(Relay.Value.kOn);
		fancyLights2.set(Relay.Value.kOff);
	}
	
	
	public void makeAmericaGreatAgain(){//just makes the lights white don't worry
		fancyLights1.set(Relay.Value.kReverse);
		fancyLights2.set(Relay.Value.kOff);
	}
	
	public void turnOff(){
		fancyLights1.set(Relay.Value.kOff);
		fancyLights2.set(Relay.Value.kOff);
		
	}
}