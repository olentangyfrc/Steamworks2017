package org.usfirst.frc.team4611.robot.commands;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.BitSet;
import java.util.TimerTask;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.Timer;

public class ADXRS450Gyro {
	
	static final int DATA_SIZE = 4; //4 bytes = 32 bits
	static final byte PARITY_BIT = (byte) 0x01; //parity check on first bit
	static final byte STATUS_MASK = (byte) 0x0C;
	static final byte FIRST_BYTE_DATA_MASK = (byte)  0x03; //mask to find sensor data bits on first byte
	static final byte THIRD_BYTE_DATA_MASK = (byte) 0xFC; //mask to find sensor data bits on third byte
	static final byte READ_COMMAND = (byte) 0x20; //0010 0000

	//angle integration
	public volatile double currentRate;
	private volatile double lastRate;
	public volatile double deltaTime;
	public volatile double currentTime;
	private volatile double lastTime;
	private volatile double angle;
	public volatile double driftRate;
	public volatile double accumulatedRate;

	//calibration loop
	private volatile boolean calibrate;
	private volatile boolean stopCalibrating;
	private volatile boolean firstLoop;
	public volatile double timeElapsed;
	private volatile boolean calCompleted;
	private static double CALIBRATION_PERIOD = 10.0; //seconds

	private SPI spi;

	//debugging binary messages
	String binRate;
	String binMessage;

	//thread executor
	private java.util.Timer executor;
	private long period;

	public  ADXRS450Gyro() {
		//run at 333Hz loop
		this.period = (long)3;

		spi = new SPI(Port.kOnboardCS0);
		spi.setClockRate(4000000); //4 MHz (rRIO max, gyro can go high)
		spi.setClockActiveHigh();
		spi.setChipSelectActiveLow();
		spi.setMSBFirst();

		currentRate = 0.0;
		driftRate = 0.0;

		lastTime = 0;
		currentTime = 0;
		lastRate = 0;
		deltaTime = 0;
		accumulatedRate = 0;

		calibrate();

		reset();
		
	}
	public final void calibrate() {
		calibrate = true;
		firstLoop = true;
		stopCalibrating = false;
		calCompleted = false;
		}
	
	public final void reset() {
		angle = 0;
		}
	
	public void startThread() {
		this.executor = new java.util.Timer();
		this.executor.schedule(new GyroUpdateTask(this), 0L, this.period);
		}
	
	public double getAngle() {
		return angle;
		}
	
	private class GyroUpdateTask extends TimerTask {
		private ADXRS450Gyro g;

		private GyroUpdateTask(ADXRS450Gyro g) {
			if (g == null) {
				throw new NullPointerException("Gyro pointer null");
			}
			this.g = g;
		}

		/**
		 * Called periodically in its own thread
		 */
		public void run() {
			g.update();
		}
	}

	public void update() {
		if(lastTime == 0) {
			lastTime = Timer.getFPGATimestamp();
		}

		currentTime = Timer.getFPGATimestamp();
		deltaTime = currentTime - lastTime;

		//TODO: see if we can fix low-pass filter to stop drift
		//low-pass filter
		//remove until it can be further tested. Yields incorrect results
		//if(Math.abs(currentRate) < 2)
		//	currentRate = 0;

		angle += (currentRate - driftRate) * deltaTime;

		/*
		 * Periodically update our drift rate by normalizing out drift
		 * while the robot is not moving.
		 * This code is re-entrant and can be stopped at any time
		 *   (e.g. if a match starts).
		 */
		if(calibrate) {
			if(firstLoop) {
				driftRate = 0.0;
				accumulatedRate = 0.0;
				timeElapsed = 0.0;
				firstLoop = false;
			}

			timeElapsed += deltaTime;
			accumulatedRate += currentRate * deltaTime;
			driftRate = accumulatedRate / timeElapsed; //angle/S

			if (timeElapsed >= CALIBRATION_PERIOD || stopCalibrating) {
				//finish calibration sequence
				calibrate = false;
				reset();

				calCompleted = true;
				System.out.println("Accumulated Offset: " + driftRate
						+ "\tDelta Time: " + timeElapsed);
			}
		}

		lastRate = currentRate;
		lastTime = currentTime;
	}

		
}