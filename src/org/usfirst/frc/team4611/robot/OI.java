package org.usfirst.frc.team4611.robot;

import org.usfirst.frc.team4611.robot.commands.*;

import org.usfirst.frc.team4611.robot.commands.relaySpike;

import edu.wpi.first.wpilibj.Joystick;
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
    public Button agitateButtonForward;
    public Button agitateButtonBackward;
    public Button feedbutForward;
    public Button feedbutBackward;
    public static relaySpike lightSpike = new relaySpike(RobotMap.lightSpike, Direction.kForward); //kForward uses only forward pin
    public Button shootPiston;


    
    public OI() {
    	//joysticks
    	leftJoy = new Joystick(0);
        rightJoy = new Joystick(1);
        shootJoy = new Joystick(2);
        //shooter button
        shootbut = new JoystickButton(leftJoy, 1);
        shootbut.whileHeld(new SingleWheelShoot());
        //feeder button
    	feedbutForward = new JoystickButton(shootJoy, 4);
    	feedbutForward.toggleWhenPressed(new MoveFeeder(RobotMap.feederSpeed));
    	feedbutBackward = new JoystickButton(shootJoy, 5);
    	feedbutBackward.toggleWhenPressed(new MoveFeeder(-RobotMap.feederSpeed));
    	//climber button
    	climbButton = new JoystickButton(shootJoy, 1);
    	climbButton.whileHeld(new MoveClimber());
    	//activate lights
    	light = new JoystickButton(leftJoy, 7);
    	light.toggleWhenPressed(lightSpike);
    	//piston button
    	shootPiston = new JoystickButton(rightJoy, 1);
        this.shootPiston.toggleWhenPressed(new MoveTestSolenoid()); //when pressed, shoot piston
        //move only one piston button
        //agitate button
        agitateButtonForward = new JoystickButton(shootJoy, 3);
        agitateButtonForward.toggleWhenPressed(new MoveAgitator(RobotMap.agitateSpeed));
        agitateButtonBackward = new JoystickButton(shootJoy,2);
        agitateButtonBackward.toggleWhenPressed(new MoveAgitator(-RobotMap.agitateSpeed));

    }

    public double filter(double raw) //Modifies the joystick input to be something cleaner to output to motors.
    {
        if (Math.abs(raw) < .07) {
            return 0;				//Set a dead zone, to filter out noise
        } else {
            return  raw * 0.95; //Drivetrain motors are running at 95%, linear filter
        }
    }

}
