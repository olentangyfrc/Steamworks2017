package org.usfirst.frc.team4611.robot;

import edu.wpi.first.wpilibj.Relay;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    
	//Drive motor ports. They're numbered clockwise, starting with ten at the front right.
	public static int frontRightWheel = 10;
	public static int rearRightWheel = 11;
	public static int rearLeftWheel = 12;
	public static int frontLeftWheel = 13;

    //CAN Ports
    public static int powerdis = 1;
    public static int singleShooter = 20; //shooter talon port

    //speed variables
    //public static double shooterTargetSpeed = -3000.0;
    //Ultrasonic Sensor Port
    public static int ultraSonicPort = 3;
    public static int ultraSonicPort2 = 2;

    //shooter ports
    public static int Feeder= 4;
    public static int Climber = 6;
    public static int Agitator = 7;
    

	public static int fancyPort1 = 0;
	public static int fancyPort2 = 1;
   // public static int lightSpike = 3;
    

    //Pneumatic Ports. Two ports are required for a double solenoid
    public static int sole1Open = 1; //check ports
    public static int sole1Close = 0;
    //ports required for double solenoid #2
    public static int sole2Open = 2;
    public static int sole2Close = 3;
    
    
    //speed variables
    public static double feederSpeed = -0.75;
    public static double singleShooterSpeed = -3600;
    public static double climberSpeed = 1;
    public static double agitateSpeed = 1;
    
    
    //Range values for ultrasonic sensor
    public static double ultraLowerBound = 90;
    public static double ultraUpperBound = 96;
    
    public static int cpr = 1440;
    public static double fValue = 1.5;
    public static double motionMagicP = 12;

}
	