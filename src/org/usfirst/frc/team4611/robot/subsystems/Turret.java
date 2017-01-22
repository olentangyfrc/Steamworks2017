package org.usfirst.frc.team4611.robot.subsystems;

import org.usfirst.frc.team4611.robot.RobotMap;
import org.usfirst.frc.team4611.robot.commands.EncoderMeasure;
import org.usfirst.frc.team4611.robot.commands.LimitSwitch;
import org.usfirst.frc.team4611.robot.commands.moveTurret;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Turret extends Subsystem{
	private DigitalInput l;
	private Victor t;
	private Encoder e;
	
	public Turret(){
		l = new DigitalInput(RobotMap.encoderReset);
		t = new Victor(RobotMap.turretMotor);
		e = new Encoder(RobotMap.channelA, RobotMap.channelB, false, Encoder.EncodingType.k2X);
		
		
	}
	/*
	 * Dear Monkeys
	 * 
	 * It's 1am and I'm writing instructions on how to this class works. 
	 * 
	 * it all boils down to specialMove(), pay attention to it
	 * 
	 * as long as our limitswitch is not hit, let's move normally
	 * 
	 * once the switch is hit, you enter the else statement. 
	 * this part should prevent moving the turret farther than the boundary. 
	 * 
	 * each of the ifs is saying "unless the driver gives speed that would turn the turret away from the boundary, dont move"
	 * 
	 * the only thing i don't know is what direction true and false are. i assume true is clockwise, but if you call getEncoderMeasure from Robot.java
	 * the direction should print out to the smartdash.
	 * 
	 * figure it out, this shouldn't be too difficult if it doesnt work
	 * 
	 * I believe in you monkeys
	 * -Baru, Best PROgrammer in the world
	 * 
	 * PS fuck github for wiping my code and making me write this a second time over
	 */
	
	public void specialMove(double speed){
		if(isClosed() == false){
			t.set(speed);
		}
		else{
			if(speed < 0 && e.getDirection() == true){
				t.set(speed);
			}
			if(speed > 0 && e.getDirection() == false){
				t.set(speed);
			}
		}
	}
	
	public boolean isClosed(){
		
		return l.get();
		
	}
	public void getEncoderMeasure() {
		
		//encoder.setMaxPeriod(.1);
		//encoder.setMinRate(10);
		//encoder.setDistancePerPulse(5);
		//encoder.setReverseDirection(true);
		double eRate = e.getRate();
		int eRaw = e.getRaw();
		boolean eDirection= e.getDirection();
		double eDistance= e.getDistance();
		
		SmartDashboard.putNumber("Enconder rate", eRate);
		SmartDashboard.putNumber("Enconder raw", eRaw);
		SmartDashboard.putNumber("Encoder distance", eDistance);
		SmartDashboard.putBoolean("Direction", eDirection);
		
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		this.setDefaultCommand(new moveTurret());
		
	}

}
