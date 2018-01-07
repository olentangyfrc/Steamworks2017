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
    /*not sure if our controller will be recognized as an xbox controller because ours is a gamepad
     * but the xbox controller class has better methods if it does not work then we will switch it
     * to a gamepad before doing that check drivetrain code*/
    
    public OI() {
    	//joysticks and controllers
    	controller = new XboxController(0);
    	
    	
        //buttons / axis NOT NEEDED FOR CONTROLLER cannot instantiate buttons must use get commands from xboxcontroller or gamepad class
    	
    }

    public double filter(double raw) 
	 {
    	if (Math.abs(raw) < .20) {
            return 0; //If the value passed is less than 20% ignore it. This is reffered to as a deadzone
        } else {
            return  raw * 0.1; //Set the output to a ceratin percent of of the input
        }
	 }

}
