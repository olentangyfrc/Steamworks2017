package org.usfirst.frc.team4611.robot;


import edu.wpi.first.wpilibj.Joystick;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
            //INSTANTIATING JOYSTICKS AND BUTTONS:

    //Driver Station joysticks
    public Joystick leftJoy = new Joystick(0);
    public Joystick rightJoy = new Joystick(1);
    
    
    public OI() {
        //Runs the wheels backwards while the wheel shooter is down WHILEHELD
        
     

        //this.lowerArm.whenPressed(new ArmAuto(false));
        //this.raiseArm.whenPressed(new ArmAuto(true));
        //this.reverse.whenPressed(new ToggleCommand());
        //new ShooterWheelsMove(RobotMap.feedingWheelShooterSpeed));//not sure if this will work
        //this.combineLoading.whenPressed(new FeedingPosition()); //not sure if this will work
        //wheelShoot.whenPressed(new WheelShoot());
        //wheelReverse.whileHeld(new WheelReverse());
    }

    public double filter(double raw) //used to cut interference
    {
        if (Math.abs(raw) < .15) {
            return 0;
        } else {
            return  raw * 0.7;
        }
    }

}
