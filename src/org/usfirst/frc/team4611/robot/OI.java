package org.usfirst.frc.team4611.robot;

import org.usfirst.frc.team4611.robot.commands.*;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay.Direction;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //INSTANTIATING JOYSTICKS AND BUTTONS

    //Instantiate Joysticks on ports 0 and 1.
    public XboxController controller;
    
    public OI() {
    	//joysticks
    	controller = new XboxController(0);
        //buttons / axis
    	
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
