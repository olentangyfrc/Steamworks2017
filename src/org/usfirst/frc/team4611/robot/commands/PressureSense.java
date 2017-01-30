package org.usfirst.frc.team4611.robot.commands;

import edu.wpi.first.wpilibj.AccumulatorResult;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class PressureSense
{
	public void init()
	{
		AnalogInput exampleAnalog = new AnalogInput(1);
		int bits;
		exampleAnalog.setOversampleBits(4);
		bits = exampleAnalog.getOversampleBits();
		exampleAnalog.setAverageBits(2);
		bits = exampleAnalog.getAverageBits();
//The above code shows an example of how to get and set the number of oversample bits and average bits on an analog channel

		AnalogInput.setGlobalSampleRate(62500);

		//AnalogInput exampleAnalog = new AnalogInput(0);
		int raw = exampleAnalog.getValue();
		double volts = exampleAnalog.getVoltage();
		int averageRaw = exampleAnalog.getAverageValue();
		double averageVolts = exampleAnalog.getAverageVoltage();

		//AnalogInput1 exampleAnalog = new AnalogInput1(0);
		exampleAnalog.setAccumulatorInitialValue(0);
		exampleAnalog.setAccumulatorCenter(2048);
		exampleAnalog.setAccumulatorDeadband(10);
		exampleAnalog.resetAccumulator();

		//AnalogInput exampleAnalog = new AnalogInput(0);
		long count = exampleAnalog.getAccumulatorCount();
		long value = exampleAnalog.getAccumulatorValue();
		AccumulatorResult result = new AccumulatorResult();
		exampleAnalog.getAccumulatorOutput(result);
		count = result.count;//.count()?
		value = result.value;//.value()?
		SmartDashboard.putNumber("Pressure Raw", raw);
		SmartDashboard.putNumber("Pressure volts", volts);
		SmartDashboard.putNumber("Pressure averageRaw", averageRaw);
		SmartDashboard.putNumber("Pressure averageVolts", averageVolts);
		SmartDashboard.putNumber("Accumulator count", count);
		SmartDashboard.putNumber("Accumulator value", value);
		
}

}