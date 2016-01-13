/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Physics.Measure;
import Physics.Measurement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class Vehicle {

	private Integer id = 0;
	private String name;
	private String description;
	private String type;
	private String motorization;
	private String fuel;
	private Measure mass;
	private Measure load;
	private Measure dragCoefficient;
	private Measure frontalArea;
	private Measure rollingRCoefficient;
	private Measure wheelSize;
	private Measure minRPM;
	private Measure maxRPM;
	private Measure finalDriveRatio;
	private Measure energyRegeneration = new Measure(0.0, "ratio");
	private Map<String, Measure> velocityLimits = new HashMap();
	private Map<Integer, Measure> gears = new HashMap();
	private List<Throttle> throttles = new ArrayList();

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

	public Boolean addThrottle(Throttle throttle) {
		return this.throttles.add(throttle);
	}

	public Throttle getThrottle(Integer index) {
		return this.getThrottles().get(index);
	}

	public Measure getVelocity(Integer gear) {
		Double wheelSize = Measurement.convert(this.wheelSize, "m").getValue();
		Double RPM = Measurement.convert(this.maxRPM, "rps").getValue();
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
	 * @return the frontalArea
	 */
	public Measure getFrontalArea() {
		return frontalArea;
	}

	/**
	 * @param frontalArea the frontalArea to set
	 */
	public void setFrontalArea(Measure frontalArea) {
		this.frontalArea = frontalArea;
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

	public Measure getEnergyRegeneration() {
		return energyRegeneration;
	}

	public void setEnergyRegeneration(Measure energyRegeneration) {
		this.energyRegeneration = energyRegeneration;
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

	/**
	 * @return the throttles
	 */
	public List<Throttle> getThrottles() {
		return throttles;
	}

	/**
	 * @param throttles the throttles to set
	 */
	public void setThrottles(List<Throttle> throttles) {
		this.throttles = throttles;
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
		hash += 11 * this.frontalArea.hashCode();
		hash += 11 * this.rollingRCoefficient.hashCode();
		hash += 11 * this.wheelSize.hashCode();
		hash += 11 * this.minRPM.hashCode();
		hash += 11 * this.maxRPM.hashCode();
		hash += 11 * this.finalDriveRatio.hashCode();
		hash += 11 * this.energyRegeneration.hashCode();
		for (Entry<String, Measure> entity : this.velocityLimits.entrySet()) {
			hash += 7 * entity.getKey().hashCode();
			hash += 7 * entity.getValue().hashCode();
		}
		for (Entry<Integer, Measure> entity : this.gears.entrySet()) {
			hash += 7 * entity.getKey().hashCode();
			hash += 7 * entity.getValue().hashCode();
		}
		for (Throttle throttle : this.throttles) {
			hash += 7 * throttle.hashCode();
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
		vehicle.setMass(this.mass.clone());
		vehicle.setLoad(this.load.clone());
		vehicle.setDragCoefficient(this.dragCoefficient.clone());
		vehicle.setFrontalArea(this.frontalArea.clone());
		vehicle.setRollingRCoefficient(this.rollingRCoefficient.clone());
		vehicle.setWheelSize(this.wheelSize.clone());
		vehicle.setMinRPM(this.minRPM.clone());
		vehicle.setMaxRPM(this.maxRPM.clone());
		vehicle.setFinalDriveRatio(this.finalDriveRatio.clone());
		vehicle.setFinalDriveRatio(this.finalDriveRatio.clone());
		for (Entry<String, Measure> entity : this.getVelocityLimits().entrySet()) {
			vehicle.
				setVelocityLimits(entity.getKey(), entity.getValue().clone());
		}
		for (Entry<Integer, Measure> entity : this.getGears().entrySet()) {
			vehicle.setGear(entity.getKey(), entity.getValue().clone());
		}
		for (Throttle throttle : this.getThrottles()) {
			vehicle.addThrottle(throttle.clone());
		}
		return vehicle;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder("Vehicle | name: ").
			append(this.name).append(" | description: ").
			append(this.description).append(" | type: ").append(this.type).
			append(" | motorization: ").append(this.motorization).
			append(" | fuel: ").append(this.fuel).append(" | mass: ").
			append(this.mass).append(" | load: ").append(this.load).
			append(" | drag: ").append(this.dragCoefficient).append(" | rrc: ").
			append(this.rollingRCoefficient).append(" | wheelSize: ").
			append(this.wheelSize).append(" | minRPM: ").append(this.minRPM).
			append(" | maxRPM: ").append(this.maxRPM).append(" | finalDrive: ").
			append(this.finalDriveRatio).append(" | energyRegeneration: ").
			append(this.energyRegeneration);
		for (Entry<Integer, Measure> entry : this.gears.entrySet()) {
			stringBuilder.append(" | gear").append(entry.getKey()).append(": ").
				append(entry.getValue());
		}
		for (Entry<String, Measure> entry : this.velocityLimits.entrySet()) {
			stringBuilder.append(" | limit").append(entry.getKey()).append(": ").
				append(entry.getValue());
		}
		for (Throttle throttle : this.getThrottles()) {
			stringBuilder.append(" | throttle" + throttle);
		}
		return stringBuilder.toString();
	}

	public Integer getCurrentGear() {
		return 1;
	}

	public Measure getCurrentVelocity() {
		return Measurement.convert(new Measure(60.0, "km/h"), "m/s");

	}

}
