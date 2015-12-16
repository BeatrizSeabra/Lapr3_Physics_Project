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
        
        public Double getSlopeForce(Vehicle vehicle){
            Double frictionForce = Physics.Math.getFrictionForce(vehicle,this.getSlope());
            Double vehicleForce = Physics.Math.getVehicleForce(vehicle);
            return vehicleForce-frictionForce;
        }

	@Override
	public String toString() {
		return "Segment " + this.name;
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

}
