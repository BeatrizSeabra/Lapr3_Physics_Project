/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simulation;

import Model.Section;
import Model.Step;
import java.util.Deque;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class VehicleBot {

	private Deque<Section> sections;
	private List<Step> steps;
	private Integer timeStep;

	public VehicleBot(Deque<Section> sections, List<Step> steps,
					  Integer timeStep) {
		this.sections = sections;
		this.steps = steps;
		this.timeStep = timeStep;
	}

	public void step() {

	}

}
