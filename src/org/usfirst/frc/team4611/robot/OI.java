package org.usfirst.frc.team4611.robot;

import org.usfirst.frc.team4611.robot.commands.*;

import org.usfirst.frc.team4611.robot.commands.relaySpike;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Direction;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //INSTANTIATING JOYSTICKS AND BUTTONS

    //Instantiate Joysticks on ports 0 and 1.
    public Joystick leftJoy;
    public Joystick rightJoy;
    public Button shootbut;
    public Button light = new JoystickButton(leftJoy, 6);

    public Button feedbut;
    public static relaySpike lightSpike = new relaySpike(RobotMap.relayPort, Direction.kForward); //kForward uses only forward pin

    
    public OI() {
    	leftJoy = new Joystick(0);
        rightJoy = new Joystick(1);
        shootbut = new JoystickButton(leftJoy, 1);
    	shootbut.whileHeld (new SingleWheelShoot());
    	feedbut = new JoystickButton(rightJoy, 1);
    	feedbut.toggleWhenPressed(new MoveFeeder(RobotMap.Feederspeed));
    	light.toggleWhenPressed(lightSpike);

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
