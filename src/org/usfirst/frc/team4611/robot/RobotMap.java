package org.usfirst.frc.team4611.robot;

import org.usfirst.frc.team4611.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    
	//Drive motor ports. They're numbered clockwise, starting with ten at the front right.
	public static int frontRightWheel = 1;
	public static int rearRightWheel = 2;
	public static int rearLeftWheel = 3;
	public static int frontLeftWheel = 4;
	
	public static RobotDrive driveTrain;
	
	public static Victor driveTrainFL;
	public static Victor driveTrainFR;
	public static Victor driveTrainBL;
	public static Victor driveTrainBR;
    
    public static double joystickCurve = 1; // Strength of joystick curve. Here is the curve where j is the curve value and x is joystick: j*x*x + (1-j)*x
 	public static double joystickDeadzone = .07; //Joystick input has to me greater than this to drive the motors.
 	
 	public static void init () {
		
		//PWM Ports
		//PWM ports are physically on the rio and the number on the port should match with the int in code
		driveTrainFL = new Victor(3);
		driveTrainFR = new Victor(0);
		driveTrainBL = new Victor(2);
		driveTrainBR = new Victor(1);
		
		//CAN Ports
		//CAN ports are decided via software in the roborio web interface 
		
		//Objects
		driveTrain =  new RobotDrive(driveTrainFL, driveTrainBL, driveTrainFR, driveTrainBR);
		
		//Constants
				
	}
}

	