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
    public Button agitateButton;
    public Button feedbut;
    public static relaySpike lightSpike = new relaySpike(RobotMap.relayPort, Direction.kForward); //kForward uses only forward pin
    public Button shootPiston;
    public Button onePiston;

    
    public OI() {
    	//joysticks
    	leftJoy = new Joystick(0);
        rightJoy = new Joystick(1);
        shootJoy = new Joystick(2);
        //shooter button
        shootbut = new JoystickButton(leftJoy, 1);
        shootbut.whileHeld(new SingleWheelShoot());
        //feeder button
    	feedbut = new JoystickButton(shootJoy, 4);
    	feedbut.toggleWhenPressed(new MoveFeeder());
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
        onePiston = new JoystickButton(rightJoy, 4);
        this.onePiston.toggleWhenPressed(new MoveOneSolenoid(Robot.testSol.Sole1));
        //agitate button
        agitateButton = new JoystickButton(shootJoy, 5);
        agitateButton.toggleWhenPressed(new MoveAgitator());
    }

    public double filter(double raw) //Modifies the joystick input to be something cleaner to output to motors.
    {
        if (Math.abs(raw) < .15) {
            return 0;				//Set a dead zone, to filter out noise
        } else {
            return  raw;		
        }
    }

}
