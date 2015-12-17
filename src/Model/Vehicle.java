/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Physics.Measure;
import Physics.Measurement;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class Vehicle {

	private Integer id;
	private String name;
	private String description;
	private String type;
	private String motorization;
	private String fuel;
	private Measure mass;
	private Measure load;
	private Double dragCoefficient;
	private Double rollingRCoefficient;
	private Double wheelSize;
	private Map<String, Double> velocityLimits = new HashMap();
	private Double torque;
	private Double RPM;
	private Double comsumption;
	private Double minRPM;
	private Double maxRPM;
	private Double finalDriveRatio;
	private Map<Integer, Double> gears = new HashMap();

	public Boolean setVelocityLimits(String segmentType, Double velocityLimit) {
		return this.getVelocityLimits().put(segmentType, velocityLimit) != null;
	}

	public Double getVelocityLimits(String segmentType) {
		return this.getVelocityLimits().get(segmentType);
	}

	public Boolean setGear(Integer number, Double ratio) {
		return this.getGears().put(number, ratio) != null;
	}

	public Double getGear(Integer number) {
		return this.getGears().get(number);
	}

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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the motorization
	 */
	public String getMotorization() {
		return motorization;
	}

	/**
	 * @param motorization the motorization to set
	 */
	public void setMotorization(String motorization) {
		this.motorization = motorization;
	}

	/**
	 * @return the fuel
	 */
	public String getFuel() {
		return fuel;
	}

	/**
	 * @param fuel the fuel to set
	 */
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	/**
	 * @return the mass
	 */
	public Measure getMass() {
		return mass;
	}

	/**
	 * @param mass the mass to set
	 */
	public void setMass(Measure mass) {
		this.mass = mass;
	}

	/**
	 * @return the load
	 */
	public Measure getLoad() {
		return load;
	}

	/**
	 * @param load the load to set
	 */
	public void setLoad(Measure load) {
		this.load = load;
	}

	/**
	 * @return the dragCoefficient
	 */
	public Double getDragCoefficient() {
		return dragCoefficient;
	}

	/**
	 * @param dragCoefficient the dragCoefficient to set
	 */
	public void setDragCoefficient(Double dragCoefficient) {
		this.dragCoefficient = dragCoefficient;
	}

	/**
	 * @return the rollingCcoefficient
	 */
	public Double getRollingRCoefficient() {
		return rollingRCoefficient;
	}

	/**
         * @param rollingRcoefficient
	 */
	public void setRollingRCoefficient(Double rollingRcoefficient) {
		this.rollingRCoefficient = rollingRcoefficient;
	}

	/**
	 * @return the wheelSize
	 */
	public Double getWheelSize() {
		return wheelSize;
	}

	/**
	 * @param wheelSize the wheelSize to set
	 */
	public void setWheelSize(Double wheelSize) {
		this.wheelSize = wheelSize;
	}

	/**
	 * @return the torque
	 */
	public Double getTorque() {
		return torque;
	}

	/**
	 * @param torque the torque to set
	 */
	public void setTorque(Double torque) {
		this.torque = torque;
	}

	/**
	 * @return the RPM
	 */
	public Double getRPM() {
		return RPM;
	}

	/**
	 * @param RPM the RPM to set
	 */
	public void setRPM(Double RPM) {
		this.RPM = RPM;
	}

	/**
	 * @return the comsumption
	 */
	public Double getComsumption() {
		return comsumption;
	}

	/**
	 * @param comsumption the comsumption to set
	 */
	public void setComsumption(Double comsumption) {
		this.comsumption = comsumption;
	}

	/**
	 * @return the minRPM
	 */
	public Double getMinRPM() {
		return minRPM;
	}

	/**
	 * @param minRPM the minRPM to set
	 */
	public void setMinRPM(Double minRPM) {
		this.minRPM = minRPM;
	}

	/**
	 * @return the maxRPM
	 */
	public Double getMaxRPM() {
		return maxRPM;
	}

	/**
	 * @param maxRPM the maxRPM to set
	 */
	public void setMaxRPM(Double maxRPM) {
		this.maxRPM = maxRPM;
	}

	/**
	 * @return the finalDriveRatio
	 */
	public Double getFinalDriveRatio() {
		return finalDriveRatio;
	}

	/**
	 * @param finalDriveRatio the finalDriveRatio to set
	 */
	public void setFinalDriveRatio(Double finalDriveRatio) {
		this.finalDriveRatio = finalDriveRatio;
	}

	/**
	 * @return the velocityLimits
	 */
	public Map<String, Double> getVelocityLimits() {
		return velocityLimits;
	}

	/**
	 * @return the gears
	 */
	public Map<Integer, Double> getGears() {
		return gears;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Vehicle other = (Vehicle) obj;
		if (other == null) {
			return false;
		}
		return this.hashCode() == other.hashCode();
	}

	@Override
	public int hashCode() {
		int hash = 29 * this.getClass().hashCode();
		hash += 11 * this.id.hashCode();
		hash += 11 * this.name.hashCode();
		hash += 11 * this.description.hashCode();
		hash += 11 * this.type.hashCode();
		hash += 11 * this.motorization.hashCode();
		hash += 11 * this.fuel.hashCode();
		hash += 11 * this.mass.hashCode();
		hash += 11 * this.load.hashCode();
		hash += 11 * this.dragCoefficient.hashCode();
		hash += 11 * this.rollingRCoefficient.hashCode();
		hash += 11 * this.wheelSize.hashCode();
		hash += 11 * this.torque.hashCode();
		hash += 11 * this.RPM.hashCode();
		hash += 11 * this.comsumption.hashCode();
		hash += 11 * this.minRPM.hashCode();
		hash += 11 * this.maxRPM.hashCode();
		hash += 11 * this.finalDriveRatio.hashCode();
		for (Entry<String, Double> entity : this.velocityLimits.entrySet()) {
			hash += 7 * entity.getKey().hashCode();
			hash += 7 * entity.getValue().hashCode();
		}
		for (Entry<Integer, Double> entity : this.gears.entrySet()) {
			hash += 7 * entity.getKey().hashCode();
			hash += 7 * entity.getValue().hashCode();
		}
		return hash;
	}

	@Override
	public Vehicle clone() {
		Vehicle vehicle = new Vehicle();
		vehicle.setId(this.id);
		vehicle.setName(this.name);
		vehicle.setDescription(this.description);
		vehicle.setType(this.type);
		vehicle.setMotorization(this.motorization);
		vehicle.setFuel(this.fuel);
		vehicle.setMass(this.mass);
		vehicle.setLoad(this.load);
		vehicle.setDragCoefficient(this.dragCoefficient);
		vehicle.setRollingRCoefficient(this.rollingRCoefficient);
		vehicle.setWheelSize(this.wheelSize);
		vehicle.setTorque(this.torque);
		vehicle.setRPM(this.RPM);
		vehicle.setComsumption(this.comsumption);
		vehicle.setMinRPM(this.minRPM);
		vehicle.setMaxRPM(this.maxRPM);
		vehicle.setFinalDriveRatio(this.finalDriveRatio);
		for (Entry<String, Double> entity : this.getVelocityLimits().entrySet()) {
			vehicle.setVelocityLimits(entity.getKey(), entity.getValue());
		}
		for (Entry<Integer, Double> entity : this.getGears().entrySet()) {
			vehicle.setGear(entity.getKey(), entity.getValue());
		}
		return vehicle;
	}

	@Override
	public String toString() {
		return this.name;
	}

    public Integer getCurrentGear() {
        return 1;
    }
    public Double getFrontalArea(){
        return 1.0;
    }
    public Measure getCurrentVelocity(){
        return Measurement.convert(new Measure(60.0, "km/h"), "m/s");
    }

}
