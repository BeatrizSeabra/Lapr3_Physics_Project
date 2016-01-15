/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Physics.Measure;
import Simulation.AnalysisMethod;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class Run {

	private Integer id = 0;
	private String name;
	private Measure time;
	private Measure timeStep;
	private AnalysisMethod method;
	private List<Step> steps = new ArrayList();
	private List<Drop> drops = new ArrayList();

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the time
	 */
	public Measure getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(Measure time) {
		this.time = time;
	}

	/**
	 * @return the timeStep
	 */
	public Measure getTimeStep() {
		return timeStep;
	}

	/**
	 * @param timeStep the timeStep to set
	 */
	public void setTimeStep(Measure timeStep) {
		this.timeStep = timeStep;
	}

	/**
	 * @return the method
	 */
	public AnalysisMethod getMethod() {
		return method;
	}

	/**
	 * @param method the method to set
	 */
	public void setMethod(AnalysisMethod method) {
		this.method = method;
	}

	/**
	 * @return the steps
	 */
	public List<Step> getSteps() {
		return steps;
	}

	/**
	 * @param steps the steps to set
	 */
	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}

	/**
	 * @return the drops
	 */
	public List<Drop> getDrops() {
		return drops;
	}

	/**
	 * @param drops the drops to set
	 */
	public void setDrops(List<Drop> drops) {
		this.drops = drops;
	}

	public Boolean addDrop(Drop drop) {
		return this.drops.add(drop);
	}

	@Override
	public String toString() {
		return "Run | name: " + this.name + " | time: " + this.time + " | time step: " + this.timeStep;
	}
}
