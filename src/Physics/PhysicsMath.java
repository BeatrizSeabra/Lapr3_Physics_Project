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
 * @author LAPR3_20152016_G27
 */
public class PhysicsMath {

	private static final Measure gravity = new Measure(9.80665, "m/s2");
	private static final Measure airDensity = new Measure(1.225, "kg/m3");

	private static Measure getGravity() {
		return gravity;
	}

	private static Measure getAirDensity() {
		return airDensity;
	}

	public static Double getFrictionForce(Vehicle vehicle, Segment segment) {
		Double sinAngle = segment.getSlope().getValue();
		Measure convert;
		convert = Measurement.convert(segment.getLength(), "m");
		sinAngle = sinAngle * (convert.getValue() / 100);
		sinAngle = sinAngle / Measurement.convert(segment.getLength(), "m").
			getValue();
		Double frictionForce = PhysicsMath.getNormal(vehicle) * sinAngle;
		return frictionForce;
	}

	public static Double getTotalMass(Vehicle vehicle) {
		Measure mass = Measurement.convert(vehicle.getMass(), "kg");
		mass = Measurement.sum(mass, vehicle.getLoad());
		return mass.getValue();
	}

	public static Double getNormal(Vehicle vehicle) {
		Double normal = PhysicsMath.getTotalMass(vehicle) * PhysicsMath.
			getGravity().getValue();
		return normal;
	}

	public static Double getVehicleForce(Vehicle vehicle) {
		Double force = PhysicsMath.getTorque(vehicle) * vehicle.
			getFinalDriveRatio().getValue() * vehicle.getGear(vehicle.
				getCurrentGear()).getValue();
		force = force / vehicle.getWheelSize().getValue();
		Double aux1 = vehicle.getRollingRCoefficient().getValue() * PhysicsMath.
			getNormal(vehicle);
		Double aux2 = 0.5 * vehicle.getDragCoefficient().getValue() * vehicle.
			getFrontalArea().getValue() * PhysicsMath.getAirDensity().getValue() * Math.
			pow(vehicle.getCurrentVelocity().getValue(), 2.0);
		force = force - aux1 - aux2;
		return force;
	}

	public static Double getTorque(Vehicle vehicle) {
		Double frictionTorque = PhysicsMath.getNormal(vehicle) * vehicle.
			getRollingRCoefficient().getValue() * vehicle.getWheelSize().
			getValue();
		Double totalTorque = vehicle.getTorque().getValue() - frictionTorque;
		return totalTorque;
	}

}
