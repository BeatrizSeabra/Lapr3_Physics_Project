/*
 * To change this license header, choose License Headers in Vehicle Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Model.Vehicle;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class VehicleDataLocal implements VehicleData {

	private List<Vehicle> list = new ArrayList();
	private Integer currentIndex = 0;

	private Integer getNextIndex() {
		this.currentIndex++;
		return this.currentIndex;
	}

	@Override
	public Vehicle newInstance() {
		Vehicle vehicle = new Vehicle();
		vehicle.setId(this.getNextIndex());
		return vehicle;
	}

	@Override
	public Integer size() {
		return this.list.size();
	}

	@Override
	public List<Vehicle> all() {
		return new ArrayList(this.list);
	}

	@Override
	public Boolean save(Vehicle vehicle) {
		for (int i = 0; i < this.size(); i++) {
			if (this.list.get(i).getId() == vehicle.getId()) {
				return this.list.set(i, vehicle.clone()) != null;
			}
		}
		return this.list.add(vehicle);
	}

	@Override
	public Vehicle copy(Vehicle vehicle) {
		return vehicle.clone();
	}

	@Override
	public Vehicle clone(Vehicle vehicle) {
		Vehicle newVehicle = this.copy(vehicle);
		newVehicle.setId(this.getNextIndex());
		return newVehicle;
	}

	@Override
	public Vehicle get(Integer id) {
		for (Vehicle vehicle : this.list) {
			if (vehicle.getId() == id) {
				return this.copy(vehicle);
			}
		}
		return null;
	}

	@Override
	public Boolean hasChanged(Vehicle vehicle) {
		Vehicle oldVehicle = this.get(vehicle.getId());
		return !oldVehicle.equals(vehicle);
	}

}
