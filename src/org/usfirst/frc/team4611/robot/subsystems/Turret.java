package org.usfirst.frc.team4611.robot.subsystems;

import org.usfirst.frc.team4611.robot.RobotMap;
import org.usfirst.frc.team4611.robot.commands.EncoderMeasure;
import org.usfirst.frc.team4611.robot.commands.LimitSwitch;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Turret extends Subsystem{
	private LimitSwitch ls;
	
	private EncoderMeasure e;
	
	public Turret(){
		ls = new LimitSwitch(true);
		t = new Victor(RobotMap.encoderMotor);
		e = new EncoderMeasure();
		
		
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
