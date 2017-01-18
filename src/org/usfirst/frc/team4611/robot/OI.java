package org.usfirst.frc.team4611.robot;


//import org.usfirst.frc.team4611.robot.commands.ButtonFast;
//import org.usfirst.frc.team4611.robot.commands.ButtonMed;
//import org.usfirst.frc.team4611.robot.commands.ButtonSlow;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //INSTANTIATING JOYSTICKS AND BUTTONS

    //Instantiate Joysticks on ports 0 and 1.
    public Joystick leftJoy = new Joystick(0);
    public Joystick rightJoy = new Joystick(1);
    public Button slow= new JoystickButton(leftJoy, 4);
	public Button med = new JoystickButton(leftJoy, 3);
	public Button fast= new JoystickButton(leftJoy, 5);
    
    public OI() {
    	//this.slow.whileHeld(new ButtonSlow());
		//this.med.whileHeld(new ButtonMed());
		//this.fast.whileHeld(new ButtonFast());

    }

    public double filter(double raw) //Modifies the joystick input to be something cleaner to output to motors.
    {
        if (Math.abs(raw) < .15) {
            return 0;				//Set a dead zone, to filter out noise
        } else {
            return  raw * 0.7;		//Cut power output down to 70%, to make drive happy
        }
    }

}
