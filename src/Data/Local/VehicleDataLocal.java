/*
 * To change this license header, choose License Headers in Vehicle Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Local;

import Data.VehicleData;
import Model.Project;
import Model.Throttle;
import Model.Vehicle;
import Physics.Measure;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class VehicleDataLocal implements VehicleData {

	private List<Vehicle> list = new ArrayList();

	private Integer currentIndex = 0;

	private Integer getNextIndex() {
		currentIndex++;
		return this.currentIndex;
	}

	/**
	 *
	 * @param project
	 * @return
	 */
	@Override
	public Integer size(Project project) {
		return this.all(project).size();
	}

	/**
	 *
	 * @param project
	 * @return
	 */
	@Override
	public List<Vehicle> all(Project project) {
		return (List<Vehicle>) project.getVehicles();
	}

	/**
	 *
	 * @param project
	 * @param vehicle
	 * @return
	 */
	@Override
	public Boolean save(Project project, Vehicle vehicle) {
		if (vehicle.getId() == 0) {
			vehicle.setId(this.getNextIndex());
			project.addVehicle(vehicle);
			return this.list.add(vehicle);
		}
		Vehicle oldVehicle = this.get(project, vehicle);
		oldVehicle.setId(vehicle.getId());
		oldVehicle.setName(vehicle.getName());
		oldVehicle.setDescription(vehicle.getDescription());
		oldVehicle.setType(vehicle.getType());
		oldVehicle.setMotorization(vehicle.getMotorization());
		oldVehicle.setFuel(vehicle.getFuel());
		oldVehicle.setMass(vehicle.getMass());
		oldVehicle.setLoad(vehicle.getLoad());
		oldVehicle.setDragCoefficient(vehicle.getDragCoefficient());
		oldVehicle.setFrontalArea(vehicle.getFrontalArea());
		oldVehicle.setRollingRCoefficient(vehicle.getRollingRCoefficient());
		oldVehicle.setWheelSize(vehicle.getWheelSize());
		oldVehicle.setMinRPM(vehicle.getMinRPM());
		oldVehicle.setMaxRPM(vehicle.getMaxRPM());
		oldVehicle.setFinalDriveRatio(vehicle.getFinalDriveRatio());
		oldVehicle.setEnergyRegeneration(vehicle.getEnergyRegeneration());
		oldVehicle.getVelocityLimits().clear();
		oldVehicle.getGears().clear();
		oldVehicle.getThrottles().clear();

		Map<String, Measure> limits = vehicle.getVelocityLimits();
		for (String segmentType : limits.keySet()) {
			Measure velocityLimit = limits.get(segmentType);
			oldVehicle.setVelocityLimits(segmentType, velocityLimit);
		}
		Map<Integer, Measure> gears = vehicle.getGears();
		for (Integer number : gears.keySet()) {
			Measure ratio = gears.get(number);
			oldVehicle.setGear(number, ratio);
		}
		List<Throttle> throttles = vehicle.getThrottles();
		for (Throttle throttle : throttles) {
			oldVehicle.addThrottle(throttle);
		}
		return oldVehicle.equals(vehicle);
	}

	/**
	 *
	 * @param project
	 * @param vehicles
	 * @return
	 */
	@Override
	public Boolean save(Project project, List<Vehicle> vehicles) {
		for (Vehicle vehicle : vehicles) {
			this.save(project, vehicle);
		}
		return true;
	}

	/**
	 *
	 * @param project
	 * @param vehicle
	 * @return
	 */
	@Override
	public Vehicle get(Project project, Vehicle vehicle) {
		for (Vehicle vehicleList : this.list) {
			if (vehicleList.getId() == vehicle.getId() && project.getVehicles().
				contains(vehicleList)) {
				return vehicleList;
			}
		}
		return null;
	}

	/**
	 *
	 * @param project
	 * @param vehicle
	 * @return
	 */
	@Override
	public Boolean hasChanged(Project project, Vehicle vehicle) {
		Vehicle oldVehicle = this.get(project, vehicle);
		return !oldVehicle.equals(vehicle);
	}

}
