/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Physics.Measure;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class Segment {

	private String name;
	private Double height;
	private Double slope;
	private Measure length;
	private Double rrc;
	private Measure maxVelocity;
	private Measure minVelocity;
	private Double numberVehicles;

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
	 * @return the height
	 */
	public Double getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(Double height) {
		this.height = height;
	}

	/**
	 * @return the slope
	 */
	public Double getSlope() {
		return slope;
	}

	/**
	 * @param slope the slope to set
	 */
	public void setSlope(Double slope) {
		this.slope = slope;
	}

	/**
	 * @return the length
	 */
	public Measure getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(Measure length) {
		this.length = length;
	}

	/**
	 * @return the rrc
	 */
	public Double getRrc() {
		return rrc;
	}

	/**
	 * @param rrc the rrc to set
	 */
	public void setRrc(Double rrc) {
		this.rrc = rrc;
	}

	/**
	 * @return the maxVelocity
	 */
	public Measure getMaxVelocity() {
		return maxVelocity;
	}

	/**
	 * @param maxVelocity the maxVelocity to set
	 */
	public void setMaxVelocity(Measure maxVelocity) {
		this.maxVelocity = maxVelocity;
	}

	/**
	 * @return the minVelocity
	 */
	public Measure getMinVelocity() {
		return minVelocity;
	}

	/**
	 * @param minVelocity the minVelocity to set
	 */
	public void setMinVelocity(Measure minVelocity) {
		this.minVelocity = minVelocity;
	}

	/**
	 * @return the numberVehicles
	 */
	public Double getNumberVehicles() {
		return numberVehicles;
	}

	/**
	 * @param numberVehicles the numberVehicles to set
	 */
	public void setNumberVehicles(Double numberVehicles) {
		this.numberVehicles = numberVehicles;
	}

}
