package org.usfirst.frc.team4611.robot;

import edu.wpi.first.wpilibj.Relay;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    
	//Tank drive motor ports. They're numbered clockwise, starting with zero at the front right.
    //public static int frontRightWheel = 0;
    //public static int backRightWheel = 1;
    //public static int backLeftWheel = 2;
    //public static int frontLeftWheel = 3;
    
    //Mecanum drive ports, connected to PWMs
    public static int mech1 = 3;//front left
    public static int mech2 = 2;//rear left
    public static int mech3 = 0;//front right
    public static int mech4 = 1;//rear right

    //Ultrasonic Sensor Port
    public static int ultraSonicPort = 3;
    public static int ultraSonicPort2 = 2;
    //Pressure Sensor Port
    public static int PressurePort = 1;

    //shooter ports
    public static int Feeder= 4;
    public static int singleShooter = 5;
    public static int Climber = 6;
    public static int Agitator = 7;

    //speed variables

    public static double Feederspeed;
    public static double singleShooterSpeed;
    public static double climberSpeed;
    public static double agitateSpeed = 0.5;
    

    public static int relayPort = 3;
	public static int fancyPort1 = 0;
	public static int fancyPort2 = 1;


    //Pneumatic Ports. Two ports are required for a double solenoid
    public static int sole1Open = 1; //check ports
    public static int sole1Close = 0;
    //ports required for double solenoid #2
    public static int sole2Open = 2;
    public static int sole2Close = 3;
    
}
	