/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Physics.Measure;
import Physics.Measurement;
import java.util.Collections;
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
	private Measure dragCoefficient;
	private Measure rollingRCoefficient;
	private Measure wheelSize;
	private Map<String, Measure> velocityLimits = new HashMap();
	private Measure torque;
	private Measure RPM;
	private Measure comsumption;
	private Measure minRPM;
	private Measure maxRPM;
	private Measure finalDriveRatio;
	private Map<Integer, Measure> gears = new HashMap();

	public Boolean setVelocityLimits(String segmentType, Measure velocityLimit) {
		return this.getVelocityLimits().put(segmentType, velocityLimit) != null;
	}

	public Measure getVelocityLimits(String segmentType) {
		return this.getVelocityLimits().get(segmentType);
	}

	public Boolean setGear(Integer number, Measure ratio) {
		return this.getGears().put(number, ratio) != null;
	}

	public Measure getGear(Integer number) {
		return this.getGears().get(number);
	}

	public Measure getVelocity(Integer gear) {
		Double wheelSize = Measurement.convert(this.wheelSize, "m").getValue();
		Double RPM = Measurement.convert(this.RPM, "rps").getValue();
		Double finalDriveRatio = Measurement.
			convert(this.finalDriveRatio, "ratio").getValue();
		Double gearValue = Measurement.convert(this.getGear(gear), "ratio").
			getValue();
		Measure result = new Measure((2 * Math.PI * wheelSize * RPM) / (finalDriveRatio * gearValue), "m/s");
		return Measurement.convert(result, "km/h");
	}

	public Measure getMaxVelocity() {
		return this.getVelocity(Collections.max(this.gears.keySet()));
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
	public Measure getDragCoefficient() {
		return dragCoefficient;
	}

	/**
	 * @param dragCoefficient the dragCoefficient to set
	 */
	public void setDragCoefficient(Measure dragCoefficient) {
		this.dragCoefficient = dragCoefficient;
	}

	/**
	 * @return the rollingCcoefficient
	 */
	public Measure getRollingRCoefficient() {
		return rollingRCoefficient;
	}

	/**
	 * @param rollingRcoefficient
	 */
	public void setRollingRCoefficient(Measure rollingRcoefficient) {
		this.rollingRCoefficient = rollingRcoefficient;
	}

	/**
	 * @return the wheelSize
	 */
	public Measure getWheelSize() {
		return wheelSize;
	}

	/**
	 * @param wheelSize the wheelSize to set
	 */
	public void setWheelSize(Measure wheelSize) {
		this.wheelSize = wheelSize;
	}

	/**
	 * @return the torque
	 */
	public Measure getTorque() {
		return torque;
	}

	/**
	 * @param torque the torque to set
	 */
	public void setTorque(Measure torque) {
		this.torque = torque;
	}

	/**
	 * @return the RPM
	 */
	public Measure getRPM() {
		return RPM;
	}

	/**
	 * @param RPM the RPM to set
	 */
	public void setRPM(Measure RPM) {
		this.RPM = RPM;
	}

	/**
	 * @return the comsumption
	 */
	public Measure getComsumption() {
		return comsumption;
	}

	/**
	 * @param comsumption the comsumption to set
	 */
	public void setComsumption(Measure comsumption) {
		this.comsumption = comsumption;
	}

	/**
	 * @return the minRPM
	 */
	public Measure getMinRPM() {
		return minRPM;
	}

	/**
	 * @param minRPM the minRPM to set
	 */
	public void setMinRPM(Measure minRPM) {
		this.minRPM = minRPM;
	}

	/**
	 * @return the maxRPM
	 */
	public Measure getMaxRPM() {
		return maxRPM;
	}

	/**
	 * @param maxRPM the maxRPM to set
	 */
	public void setMaxRPM(Measure maxRPM) {
		this.maxRPM = maxRPM;
	}

	/**
	 * @return the finalDriveRatio
	 */
	public Measure getFinalDriveRatio() {
		return finalDriveRatio;
	}

	/**
	 * @param finalDriveRatio the finalDriveRatio to set
	 */
	public void setFinalDriveRatio(Measure finalDriveRatio) {
		this.finalDriveRatio = finalDriveRatio;
	}

	/**
	 * @return the velocityLimits
	 */
	public Map<String, Measure> getVelocityLimits() {
		return velocityLimits;
	}

	/**
	 * @return the gears
	 */
	public Map<Integer, Measure> getGears() {
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
		for (Entry<String, Measure> entity : this.velocityLimits.entrySet()) {
			hash += 7 * entity.getKey().hashCode();
			hash += 7 * entity.getValue().hashCode();
		}
		for (Entry<Integer, Measure> entity : this.gears.entrySet()) {
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
		for (Entry<String, Measure> entity : this.getVelocityLimits().entrySet()) {
			vehicle.setVelocityLimits(entity.getKey(), entity.getValue());
		}
		for (Entry<Integer, Measure> entity : this.getGears().entrySet()) {
			vehicle.setGear(entity.getKey(), entity.getValue());
		}
		return vehicle;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder("Vehicle | name: " + this.name + " | description: " + this.description + " | type: " + this.type + " | motorization: " + this.motorization + " | fuel: " + this.fuel + " | mass: " + this.mass + " | load: " + this.load + " | drag: " + this.dragCoefficient + " | rrc: " + this.rollingRCoefficient + " | wheelSize: " + this.wheelSize + " | torque: " + this.torque + " | RPM: " + this.RPM + " | comsumption: " + this.comsumption + " | minRPM: " + this.minRPM + " | maxRPM: " + this.maxRPM + " | finalDrive: " + this.finalDriveRatio);
		for (Entry<Integer, Measure> entry : this.gears.entrySet()) {
			stringBuilder.append(" | gear" + entry.getKey() + ": " + entry.
				getValue());
		}
		for (Entry<String, Measure> entry : this.velocityLimits.entrySet()) {
			stringBuilder.append(" | limit" + entry.getKey() + ": " + entry.
				getValue());
		}
		return stringBuilder.toString();
	}

	/*
	 private Integer id;
	 private String name;
	 private String description;
	 private String type;
	 private String motorization;
	 private String fuel;
	 private Measure mass;
	 private Measure load;
	 private Measure dragCoefficient;
	 private Measure rollingRCoefficient;
	 private Measure wheelSize;
	 private Map<String, Measure> velocityLimits = new HashMap();
	 private Measure torque;
	 private Measure RPM;
	 private Measure comsumption;
	 private Measure minRPM;
	 private Measure maxRPM;
	 private Measure finalDriveRatio;
	 */
	public Integer getCurrentGear() {
		return 1;
	}

	public Measure getFrontalArea() {
		return new Measure(100.0, "m2");
	}

	public Measure getCurrentVelocity() {
		return Measurement.convert(new Measure(60.0, "km/h"), "m/s");
	}

}
