package org.usfirst.frc.team4611.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    
	//Drive motor ports. They're numbered clockwise, starting with zero at the front right.
    public static int frontRightWheel = 0;
    public static int backRightWheel = 1;
    public static int backLeftWheel = 2;
    public static int frontLeftWheel = 3;
    //shooter ports
    public static int Feeder= 4;
    public static int singleShooter = 5;

    //speed variables
    public static final double singleShooterSpeed = 0.5;
    public static final double Feederspeed = -0.5;

}
	