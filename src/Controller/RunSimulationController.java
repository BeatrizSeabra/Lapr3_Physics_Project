/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Simulation;
import Physics.Measure;
import Physics.Measurement;
import Simulation.AnalysisMethod;
import Simulation.Simulator;
import System.Settings;
import System.Util;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class RunSimulationController {

	private Simulation simulation;
	private Simulator simulator;
	private List<AnalysisMethod> analysisMethods;

	/**
	 *
	 * @return
	 */
	public boolean initiation() {
		this.simulation = ContextController.getOpenSimulation();
		this.simulator = new Simulator();
		return true;
	}

	public List<AnalysisMethod> getAnalysisMethods() {
		if (this.analysisMethods == null) {
			this.analysisMethods = new ArrayList();
			List<Object> methods = Settings.loadAllClass(Settings.
				getOptions("AnalysisMethodClass"));
			for (Object objectMethod : methods) {
				AnalysisMethod methodClass = (AnalysisMethod) objectMethod;
				if (methodClass != null) {
					this.analysisMethods.add(methodClass);
				}
			}
		}
		return this.analysisMethods;
	}

	public Boolean run(String name, String time, String timeStep, int method) {
		Double timeValue = Util.toValue(time);
		String timeUnit = Util.toUnit(time);
		Double timeStepValue = Util.toValue(timeStep);
		String timeStepUnit = Util.toUnit(timeStep);
		Measure timeMeasure = Measurement.
			convert(new Measure(timeValue, timeUnit), "s");
		Measure timeStepMeasure = Measurement.
			convert(new Measure(timeStepValue, timeStepUnit), "s");
		if (timeMeasure != null && timeStepMeasure != null) {
			this.simulator.
				setData(this.simulation, name, timeMeasure, timeStepMeasure, this.analysisMethods.
						get(method));
			this.simulator.run();
			return true;
		}
		return false;
	}

	/**
	 * @return the active
	 */
	public Boolean getActive() {
		return this.simulator.getActive();
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.simulator.setActive(active);
	}

	/**
	 * @return the pause
	 */
	public Boolean getPause() {
		return this.simulator.getPause();
	}

	/**
	 * @param pause the pause to set
	 */
	public void setPause(Boolean pause) {
		this.simulator.setPause(pause);
	}

}
