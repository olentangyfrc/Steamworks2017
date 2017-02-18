package org.usfirst.frc.team4611.robot.commands;

import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Direction;

public class FancyLightSet {
	public Relay fancyLights1;
	public Relay fancyLights2;
	
	/*	kOff - Turns both relay outputs off
	kForward - Sets the relay to forward (M+ @ 12V, M- @ GND)
	kReverse - Sets the relay to reverse (M+ @ GND, M- @ 12V)
	kOn - Sets both relay outputs on (M+ @ 12V, M- @ 12V).
	 */
	
	/**
	 * 
	 * 
	 * 
	 */
	
	public FancyLightSet(){
		fancyLights1 = new Relay(RobotMap.fancyPort1, Direction.kBoth);
		fancyLights2 = new Relay(RobotMap.fancyPort2, Direction.kBoth);
	}
	
	public void show(boolean inRange){
		if(inRange){
			makeGreen();
		}
		else{
			makeRed();
		}
	}
	public void showPickUp(boolean inRange){
		if(inRange){
			makeYellow();
		}else{
			makeRed();
		}
	}
	public void makeYellow(){
		fancyLights1.set(Relay.Value.kReverse);
		fancyLights2.set(Relay.Value.kForward);
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
	
	public void makeAmericaGreatAgain(){
		fancyLights1.set(Relay.Value.kReverse);
		fancyLights2.set(Relay.Value.kOff);
	}
	
	public void turnOff(){
		fancyLights1.set(Relay.Value.kOff);
		fancyLights2.set(Relay.Value.kOff);
		
	}
}
