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
    public static int singleShooter = 21; //shooter talon port

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
    public static double singleShooterSpeed = 3600;
    public static double climberSpeed = 1;
    public static double agitateSpeed = 1;
    
    
    //Range values for ultrasonic sensor
    public static double ultraLowerBound = 90;
    public static double ultraUpperBound = 96;
    
    public static int cpr = 1440;
    public static double fValue = 1.5;
    public static double motionMagicP = 15;
    
    // Joystick
 	public static int leftJoystickPort = 0;
 	public static int rightJoystickPort = 1;
 	public static int shooterJoystickPort = 2;
 	public static double joystickCurve = 1;		// Strength of joystick curve. Here is the curve where j is the curve value and x is joystick:		j*x*x + (1-j)*x
 	public static double joystickDeadzone = .07;	// Joystick input has to me greater than this to drive the motors.
 	
 	// Constants specific to the bot
 	public static double maxRPM = 600;				// Mex RPM the bot should drive, used for calculations.
 	
 	// PID Values
 	public static double pForVelocity = 1;		// P and I while driving
 	public static double iForVelocity = 0;
 	public static double pForHoldingPosition = 20;	// P for lockdown mode
 	public static double fGain = 1023/(maxRPM/60/10*cpr);

}
	