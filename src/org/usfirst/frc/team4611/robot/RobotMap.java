package org.usfirst.frc.team4611.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    
	//Drive motor ports. They're numbered counter clockwise, starting with 0 at the back right.
    public static int backRightWheel = 0;
    public static int frontRightWheel = 1;
    public static int frontLeftWheel = 2;
    public static int backLeftWheel = 3;
    

    //Pneumatic Ports. Two ports are required for a double solenoid
    public static int sole1Open = 1; 
    public static int sole1Close = 0;
    
    // Joystick
 	public static int leftJoystickPort = 0;
 	public static int rightJoystickPort = 1;
 	public static int shooterJoystickPort = 2;
 	public static double joystickCurve = 1; // Strength of joystick curve. Here is the curve where j is the curve value and x is joystick: j*x*x + (1-j)*x
 	public static double joystickDeadzone = .07; //Joystick input has to me greater than this to drive the motors.
 	
}
	