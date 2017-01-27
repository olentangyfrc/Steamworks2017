package org.usfirst.frc.team4611.robot.subsystems;

import org.usfirst.frc.team4611.robot.Robot;
import org.usfirst.frc.team4611.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



public class measureEncoder extends Subsystem {

	private Encoder enc;
	private Victor tur;
	
	
	public measureEncoder(){
		enc = new Encoder(RobotMap.turretEncoderA, RobotMap.turretEncoderB, false, EncodingType.k2X);
		tur = new Victor(RobotMap.turretMotor);
		
	}
	
	
	public void adjust(double deg){
		tur.set(deg);
		
	}
	
	public void displayVal(){
		SmartDashboard.putNumber("raw", enc.getDistance());
		SmartDashboard.putNumber("degree", enc.getDistance());
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

