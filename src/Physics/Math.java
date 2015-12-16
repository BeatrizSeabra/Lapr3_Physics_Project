/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Physics;

import Model.Segment;
import Model.Vehicle;

/**
 *
 * @author Biia
 */
public class Math {

	private static Double getGravity() {
		return 9.80665;
	}

	public static Double getFrictionForce(Vehicle vehicle, Segment segment) {
		Double frictionForce = Measurement.sum(vehicle.getMass(), vehicle.
											   getLoad()).getValue();
		frictionForce = frictionForce * Math.getGravity();
		return 0.0;
	}

	public static Double getVehicleForce(Vehicle vehicle) {
		return 0.0;
	}

}
