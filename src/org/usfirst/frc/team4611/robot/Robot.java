
package org.usfirst.frc.team4611.robot;


import org.usfirst.frc.team4611.robot.subsystems.*;

//import org.usfirst.frc.team4611.robot.subsystems.Motor;
//import org.usfirst.frc.team4611.robot.subsystems.VisionTank;
import org.usfirst.frc.team4611.robot.subsystems.leftSide;
import org.usfirst.frc.team4611.robot.subsystems.rightSide;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.NamedSendable;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4611.robot.commands.UltrasonicRange;
import org.usfirst.frc.team4611.robot.commands.Gyro;
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
	public UltrasonicRange ultra;
	public Gyro gy;
	public static boolean dir = false;
	
	CANTalon _talon = new CANTalon(48);	
	Joystick _joy = new Joystick(0);	
	StringBuilder _sb = new StringBuilder();
	private FeedbackDevice shooterEncoder;
	int _loops = 0;
	boolean _lastButton1 = false;
	double targetPositionRotations;

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
		oi = new OI();

		prefs = Preferences.getInstance();
		 
		this.chooser = new SendableChooser(); //SmartDashboard

		// this.autonomousCommand = new autonomousCommandGroup();
		// table = NetworkTable.getTable("GRIP/data"); //Network tables to pull
		// VA data to roborio. Not currently in use
		
		/* lets grab the 360 degree position of the MagEncoder's absolute position */
		int absolutePosition = _talon.getPulseWidthPosition() & 0xFFF; /* mask out the bottom12 bits, we don't care about the wrap arounds */
        /* use the low level API to set the quad encoder signal */
        _talon.setEncPosition(absolutePosition);
        
        /* choose the sensor and sensor direction */
        shooterEncoder = (FeedbackDevice.QuadEncoder);
        _talon.setFeedbackDevice(shooterEncoder);
        _talon.reverseSensor(true);
        _talon.configEncoderCodesPerRev(20);

        /* set the peak and nominal outputs, 12V means full */
        _talon.configNominalOutputVoltage(+0f, -0f);
        _talon.configPeakOutputVoltage(+12f, -12f);
        /* set the allowable closed-loop error,
         * Closed-Loop output will be neutral within this range.
         * See Table in Section 17.2.1 for native units per rotation. 
         */
        _talon.setAllowableClosedLoopErr(0); /* always servo */
        /* set closed loop gains in slot0 */
        _talon.setProfile(0);
        _talon.setF(-5.115);
        _talon.setP(0.0);
        _talon.setI(0.0); 
        _talon.setD(0.0);          
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
		ultra = new UltrasonicRange();
		gy = new Gyro();

	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		// LiveWindow.run();
		ultra.ultrasonicMeasurement();
		sw.getEncoderMeasure();
		
		/* get gamepad axis */
    	double leftZstick = _joy.getAxis(AxisType.kZ);
    	double motorOutput = _talon.getOutputVoltage() / _talon.getBusVoltage();
    	//boolean button1 = _joy.getRawButton(1);
    	//boolean button2 = _joy.getRawButton(2);
    	/* prepare line to print */
		_sb.append("\tout:");
		_sb.append(motorOutput);
        _sb.append("\tspd:");
        _sb.append(_talon.getSpeed());
        
        /* on button1 press enter closed-loop mode on target position */
        if(true || _joy.getRawButton(1)) {
        	//double targetSpeed = leftZstick * -3950;
        	double targetSpeed = -1500;
        	_talon.changeControlMode(TalonControlMode.Speed);
        	_talon.set(targetSpeed); 	
        	
        	//_sb.append("\taxis");
        	_sb.append(leftZstick);
        	_sb.append("\terr:");
        	_sb.append(_talon.getClosedLoopError());
        	_sb.append("\ttrg:");
        	_sb.append(-targetSpeed);
        }
        else {
        	_talon.changeControlMode(TalonControlMode.PercentVbus);
        	_talon.set(-0.5);
        }
        if(++_loops >= 10) {
        	_loops = 0;
        	System.out.println(_sb.toString());
        }
        _sb.setLength(0);
    }

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
