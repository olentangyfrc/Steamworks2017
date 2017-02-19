
package org.usfirst.frc.team4611.robot;


import org.usfirst.frc.team4611.robot.subsystems.*;


//import org.usfirst.frc.team4611.robot.subsystems.Motor;
//import org.usfirst.frc.team4611.robot.subsystems.VisionTank;
import org.usfirst.frc.team4611.robot.subsystems.leftSide;
import org.usfirst.frc.team4611.robot.subsystems.rightSide;
import org.usfirst.frc.team4611.robot.OI;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.NamedSendable;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4611.robot.commands.MoveFeeder;
import org.usfirst.frc.team4611.robot.commands.UltrasonicRange;
import org.usfirst.frc.team4611.robot.commands.FancyLightSet;

//import org.usfirst.frc.team4611.robot.commands.MoveTestSolenoid;
//import org.usfirst.frc.team4611.robot.subsystems.TestSolenoid;

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
	public static leftSide leftS; 
	public static rightSide rightS;

	public static SingleWheelShooter sw;
	public static Climber cl;
	public static Agitator ag;
	public UltrasonicRange ultra;
	public UltrasonicRange ultra2;
	public FancyLightSet fl;
    public boolean lightsGreen;

	public static Feeder fe;
	public static TestSolenoid testSol;
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
		// server.startAutomaticCapture("cam1");
		leftS = new leftSide();
		rightS = new rightSide();
		sw = new SingleWheelShooter();
		fe = new Feeder();
		fl = new FancyLightSet();
		cl = new Climber();
		testSol = new TestSolenoid(); 
		ag = new Agitator();
		oi = new OI();
		
		ultra = new UltrasonicRange(RobotMap.ultraSonicPort, "Ultrasonic Range 1", "in range 1");
		ultra2 = new UltrasonicRange(RobotMap.ultraSonicPort2, "Ultrasonic Range 2", "in range 2");

		prefs = Preferences.getInstance();
		 
		this.chooser = new SendableChooser(); //SmartDashboard

		// this.autonomousCommand = new autonomousCommandGroup();
		// table = NetworkTable.getTable("GRIP/data"); //Network tables to pull
		// VA data to roborio. Not currently in use		
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
		Scheduler.getInstance().run();
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

		this.autonomousCommand = (Command) this.chooser.getSelected();
		if (this.autonomousCommand != null) {
			this.autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (this.autonomousCommand != null) {
			this.autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		LiveWindow.run();
		ultra.ultrasonicMeasurement();
		ultra2.ultrasonicMeasurement();
		sw.getEncoderMeasure();
		lightsGreen = ultra.getInRange() || ultra2.getInRange();
        fl.show(lightsGreen, false);
    }

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
