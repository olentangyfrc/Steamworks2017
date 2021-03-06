
package org.usfirst.frc.team4611.robot;


import org.usfirst.frc.team4611.robot.subsystems.*;


//import org.usfirst.frc.team4611.robot.subsystems.Motor;
//import org.usfirst.frc.team4611.robot.subsystems.VisionTank;


import org.usfirst.frc.team4611.robot.OI;


import edu.wpi.cscore.VideoCamera;
import edu.wpi.cscore.VideoSource;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.NamedSendable;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4611.robot.commands.RetractSolenoid;
import org.usfirst.frc.team4611.robot.commands.MoveFeeder;
import org.usfirst.frc.team4611.robot.commands.ExtendSolenoid;
import org.usfirst.frc.team4611.robot.commands.UltrasonicRange;
import org.usfirst.frc.team4611.robot.commands.relaySpike;
import org.usfirst.frc.team4611.robot.commands.StartCenter;
import org.usfirst.frc.team4611.robot.commands.StartDefaultAuton;
import org.usfirst.frc.team4611.robot.commands.StartLeft;
import org.usfirst.frc.team4611.robot.commands.StartRight;
import org.usfirst.frc.team4611.robot.commands.TestEncoderDriveBlock;
import org.usfirst.frc.team4611.robot.commands.FancyLightSet;
import org.usfirst.frc.team4611.robot.commands.ultraDrive;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	// public static final ExampleSubsystem exampleSubsystem = new
	// ExampleSubsystem();
	public static OI oi;
	public static DriveTrain driveT;

	public static SingleWheelShooter sw;
	public static Climber cl;
	public static Agitator ag;
	public static UltrasonicRange ultra;
	public static Gyro gy;

	public UltrasonicRange ultra2;
	public static FancyLightSet fl;
    public boolean lightsGreen;

	public static Feeder fe;
	public static Solenoid testSol;
	public static Timer time;
	public static relaySpike spike;
	
	public int autoTime;

	public static boolean dir = false;

	public static Preferences prefs ;
	Command autonomousCommand;
	SendableChooser chooser;

	public static NetworkTable table;

	CameraServer server;
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */

	@Override
	public void robotInit() {
		// Initializes camera feed on driver station
		// server = CameraServer.getInstance();
		// server.setQuality(50);
		 //server.startAutomaticCapture();
		driveT = new DriveTrain(); 
		sw = new SingleWheelShooter();
		fe = new Feeder();
		fl = new FancyLightSet();
		cl = new Climber();
		testSol = new Solenoid(); 
		ag = new Agitator();
		oi = new OI();
		Robot.driveT.masterLeft.setEncPosition(0);
		Robot.driveT.masterRight.setEncPosition(0);
		ultra = new UltrasonicRange(RobotMap.ultraSonicPort, "Ultrasonic Range 1", "in range 1");
		spike = new relaySpike(2 , Relay.Direction.kForward);
		gy = new Gyro();
		System.out.println("Calibrating gyro. Can't touch this. Do, do do do. Do do. Do do. Can't touch this.");
		System.out.println("But seriously, if the bot is moved right now, auto will NOT work.");
		Robot.gy.gyro.calibrate();
		System.out.println("I'm safe to touch.");
		this.chooser = new SendableChooser();
		 	this.chooser.addDefault("ALEX DONT SELECT THIS", new StartDefaultAuton());
		 	this.chooser.addObject("Left of Airship ", new StartLeft());
		 	this.chooser.addObject("Middle of Airship ", new StartCenter());
	        this.chooser.addObject("Right of Airship ",new StartRight());
	        SmartDashboard.putData("Auto Chooser ", this.chooser);
	    Robot.fl.makeGreen();
		//this.autonomousCommand = new RunAuton(startPosition.RIGHT);
		
		prefs = Preferences.getInstance();
		// table = NetworkTable.getTable("GRIP/data"); //Network tables to pull
		// VA data to roborio. Not currently in use		
		 //table = NetworkTable.getTable("GRIP/data"); //Network tables to pull
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
	}

	@Override
	public void disabledPeriodic() {
		Robot.fl.makeRed();
		Scheduler.getInstance().run();
		this.autonomousCommand = (Command) this.chooser.getSelected();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		// schedule the autonomous command (example)
		//alliance = ds.getAlliance();
		autoTime = 0;
		spike.start();	
		gy.gyro.reset();
		//if (autonomousCommand != null) 
			//autonomousCommand.start();
		this.autonomousCommand = (Command) this.chooser.getSelected();
		autonomousCommand.start();
		
		}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		ultra.ultrasonicMeasurement();
		Robot.fl.makeGreen();
		Scheduler.getInstance().run();
		//System.out.println("Left Rotations: " + Robot.driveT.masterLeft.getPosition());
		//System.out.println("Right Rotations: " + Robot.driveT.masterRight.getPosition());
		
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		//spike = new relaySpike(0 , Relay.Direction.kReverse);
		//spike.start();
		//ag.agitate(RobotMap.agitateSpeed);
		if (this.autonomousCommand != null) {
			this.autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control
	 */
	public static int tracker = 0;
	
	double lastFrame = 0;
	public static double lastTime = 0;
	@Override

	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		LiveWindow.run();
		Robot.fl.makeGreen();
		//ultra.ultrasonicMeasurement();
		//lightsGreen = ultra.getInRange();
        //fl.show(lightsGreen, ultra.roundedInches < 90);
        //System.out.println("Left Rotations: " + Robot.driveT.masterLeft.getPosition());
		//System.out.println("Right Rotations: " + Robot.driveT.masterRight.getPosition());
        //System.out.println("Angle: " + Robot.gy.gyro.getAngle());	//Debugging for gyroscope
	}
        
		/*double currentFrame = table2.getNumber("FrameRate", 0.0);
		
		Scheduler.getInstance().run();	
		ultra.ultrasonicMeasurement();
		}
	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
	
	
	
}
