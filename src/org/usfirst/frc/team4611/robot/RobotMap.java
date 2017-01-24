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
    //tank drive
    
    public static int leftShooter = 4;
    public static int rightShooter = 5;
    //dual wheel shooter
    public static int singleShooter = 6;
    //single wheel shooter
    public static int turretMotor = 7;
    //Turret Motor
    
    public static int encoderReset = 2;
    
    public static int rightLimit = 3;
    public static int leftLimit = 2;
    
    public static int channelA = 0;
    public static int channelB = 1;
    
    
}
