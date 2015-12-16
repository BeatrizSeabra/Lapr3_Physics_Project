/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Map;

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
	private Double mass;
	private Double load;
	private Double dragCoefficient;
        private Double rollingCcoefficient;
        private Double wheelSize;
        private Map<String,Double> velocityLimits;
        private Double torque;
        private Double rpm;
        private Double comsumption;
        private Double minRPM;
        private Double maxRPM;
        private Map<Integer,Double> gears;
        
        
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
	 * @return the mass
	 */
	public Double getMass() {
		return mass;
	}

	/**
	 * @param mass the mass to set
	 */
	public void setMass(Double mass) {
		this.mass = mass;
	}

	/**
	 * @return the load
	 */
	public Double getLoad() {
		return load;
	}

	/**
	 * @param load the load to set
	 */
	public void setLoad(Double load) {
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
		hash += 11 * this.type.hashCode();
		hash += 11 * this.motorization.hashCode();
		hash += 11 * this.mass.hashCode();
		hash += 11 * this.load.hashCode();
		hash += 11 * this.dragCoefficient.hashCode();
		return hash;
	}

	@Override
	public String toString() {
		return this.name;
	}

	@Override
	public Vehicle clone() {
		Vehicle vehicle = new Vehicle();
		vehicle.setId(this.id);
		vehicle.setName(this.name);
		vehicle.setType(this.type);
		vehicle.setMotorization(this.motorization);
		vehicle.setMass(this.mass);
		vehicle.setLoad(this.load);
		vehicle.setDragCoefficient(this.dragCoefficient);
		return vehicle;
	}

    public String getDescription() {
        return description;
    }

    public String getFuel() {
        return fuel;
    }

    public Double getRollingCcoefficient() {
        return rollingCcoefficient;
    }

    public Double getWheelSize() {
        return wheelSize;
    }

    public Map<String,Double> getVelocityLimits() {
        return velocityLimits;
    }

    public Double getTorque() {
        return torque;
    }

    public Double getRpm() {
        return rpm;
    }

    public Double getComsumption() {
        return comsumption;
    }

    public Double getMinRPM() {
        return minRPM;
    }

    public Double getMaxRPM() {
        return maxRPM;
    }

    public Map<Integer,Double> getGears() {
        return gears;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public void setRollingCcoefficient(Double rollingCcoefficient) {
        this.rollingCcoefficient = rollingCcoefficient;
    }

    public void setWheelSize(Double wheelSize) {
        this.wheelSize = wheelSize;
    }

    public void setVelocityLimits(Map<String,Double> velocityLimits) {
        this.velocityLimits = velocityLimits;
    }

    public void setTorque(Double torque) {
        this.torque = torque;
    }

    public void setRpm(Double rpm) {
        this.rpm = rpm;
    }

    public void setComsumption(Double comsumption) {
        this.comsumption = comsumption;
    }

    public void setMinRPM(Double minRPM) {
        this.minRPM = minRPM;
    }

    public void setMaxRPM(Double maxRPM) {
        this.maxRPM = maxRPM;
    }

    public void setGears(Map<Integer,Double> gears) {
        this.gears = gears;
    }

}
