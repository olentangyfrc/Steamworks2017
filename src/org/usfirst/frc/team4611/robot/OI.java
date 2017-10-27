package org.usfirst.frc.team4611.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //INSTANTIATING JOYSTICKS AND BUTTONS

    //Instantiate Joysticks on ports 0 and 1.
    public Joystick leftJoy;
    public Joystick rightJoy;
    public Joystick shootJoy;
    
    public OI() {
    	//joysticks
    	leftJoy = new Joystick(RobotMap.leftJoystickPort);
        rightJoy = new Joystick(RobotMap.rightJoystickPort);
        shootJoy = new Joystick(RobotMap.shooterJoystickPort);
    }

    public double oldFilter(double raw) //Modifies the joystick input to be something cleaner to output to motors.
    {
        if (Math.abs(raw) < .07) {
            return 0;				//Set a dead zone, to filter out noise
        } else {
            return  raw; //Drivetrain motors are running at 100%, linear filter
        }
    }
    
    public double filter(double raw) // Applies a deadzone and curve
	 {
		 if (Math.abs(raw) < RobotMap.joystickDeadzone)
			 // If in the deadzone, set motor to 0
			 return 0;
		 else 
		 {
			 // Flip joystick input
			 raw = -raw;
			 
			 // Apply curve
			 return  RobotMap.joystickCurve * raw * Math.abs(raw) + (1-RobotMap.joystickCurve) * raw;  
		 }
	 }

}
