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
    public Joystick shootJoy;
    public Button shootbut;
    public Button climbButton;
    public Button light;

    public Button feedbut;
    public static relaySpike lightSpike = new relaySpike(RobotMap.relayPort, Direction.kForward); //kForward uses only forward pin

    
    public OI() {
    	leftJoy = new Joystick(0);
        rightJoy = new Joystick(1);
        shootJoy = new Joystick(2);
        shootbut = new JoystickButton(leftJoy, 1);
    	shootbut.whileHeld (new SingleWheelShoot(RobotMap.singleShooterSpeed));
    	feedbut = new JoystickButton(rightJoy, 1);
    	feedbut.toggleWhenPressed(new MoveFeeder(RobotMap.Feederspeed));
    	climbButton = new JoystickButton(shootJoy, 1);
    	climbButton.whileHeld(new MoveClimber(RobotMap.ClimberSpeed));
    	light = new JoystickButton(leftJoy, 7);
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
