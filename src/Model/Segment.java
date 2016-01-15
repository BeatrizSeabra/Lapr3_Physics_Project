/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Physics.Measure;
import Physics.Measurement;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class Segment {

	private String name;
	private Measure height;
	private Measure slope;
	private Measure length;
	private Measure maxVelocity;
	private Measure minVelocity;
	private Integer numberVehicles = 0;
	private Integer vehicles = 0;

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
	public Measure getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(Measure height) {
		this.height = height;
	}

	/**
	 * @return the slope
	 */
	public Measure getSlope() {
		return slope;
	}

	/**
	 * @param slope the slope to set
	 */
	public void setSlope(Measure slope) {
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
	public Integer getNumberVehicles() {
		return numberVehicles;
	}

	/**
	 * @param numberVehicles the numberVehicles to set
	 */
	public void setNumberVehicles(Integer numberVehicles) {
		this.numberVehicles = numberVehicles;
	}

	/**
	 * @return the vehicles
	 */
	public Integer getVehicles() {
		return vehicles;
	}

	/**
	 * @param vehicles the vehicles to set
	 */
	public void setVehicles(Integer vehicles) {
		this.vehicles = vehicles;
	}

	@Override
	public String toString() {
		return "Segment | name: " + this.name + " | height: " + this.height + " | slope: " + this.slope + " | length: " + this.length + " | maxVelocity: " + this.maxVelocity + " | minVelocity: " + this.minVelocity + " | numberVehicles: " + this.numberVehicles;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Segment other = (Segment) obj;
		if (other == null) {
			return false;
		}
		return this.hashCode() == other.hashCode();
	}

	@Override
	public int hashCode() {
		int hash = 29 * this.getClass().hashCode();
		hash += 11 * this.name.hashCode();
		hash += 11 * this.height.hashCode();
		hash += 11 * this.slope.hashCode();
		hash += 11 * this.length.hashCode();
		hash += 11 * this.maxVelocity.hashCode();
		hash += 11 * this.minVelocity.hashCode();
		hash += 11 * this.numberVehicles.hashCode();
		return hash;
	}

	/**
	 *
	 * @return
	 */
	public Segment reverse() {
		Segment segment = new Segment();
		segment.setName(this.name);
		segment.setHeight(this.height);
		segment.setSlope(Measurement.neg(this.slope));
		segment.setLength(this.length);
		segment.setMaxVelocity(this.maxVelocity);
		segment.setMinVelocity(this.minVelocity);
		segment.setNumberVehicles(this.numberVehicles);
		return segment;
	}

}
