package org.usfirst.frc.team4320.robot.subsystems;

import org.usfirst.frc.team4320.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PneumaticsControl extends Subsystem {
	private Compressor compressor;
	private AnalogInput pressureSensor;
	private static PneumaticsControl instance;
	private boolean state;
	public static PneumaticsControl getInstance(){
		if(instance == null)
			instance = new PneumaticsControl();
		return instance;
	}
	private PneumaticsControl(){
		pressureSensor = new AnalogInput(RobotMap.PRESSURE_SENSOR_PORT);
		compressor = new Compressor();
	}
	/*
	 * sets the compressor state
	 * true - on
	 * false - off
	 */
	public void setComressorState(boolean state){
			compressor.setClosedLoopControl(state);
			this.state = state;
	}
	public boolean getCompressorState(){
		return state;
	}
	/*
	 * returns the compressor pressure
	 */
	public double getCompressorPressure(){
		return 250*(pressureSensor.getValue()/5)-25;
		/*
		 * Calculation based on REV robotics manufacture instructions.
		 * formulas can be found here : http://www.revrobotics.com/content/docs/REV-11-1107-DS.pdf
		 */
	}
	public void reportStatus(){
		SmartDashboard.putNumber("System Pressure", getCompressorPressure());
	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
