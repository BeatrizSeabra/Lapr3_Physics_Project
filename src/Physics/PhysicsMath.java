/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Physics;

import Model.Regime;
import Model.Segment;
import Model.Throttle;
import Model.Vehicle;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class PhysicsMath {

	public static final Measure gravity = new Measure(9.80665, "m/s2");
	public static final Measure airDensity = new Measure(1.225, "kg/m3");
	private static Random random = new Random();

	public static Double exponentialDistributionRandom(int averagePerPeriod) {
		return -Math.log(PhysicsMath.random.nextDouble()) / (1.0 / averagePerPeriod);
	}

	public static Measure engineCarForce(Measure torque, Measure finalDrive,
										 Measure gearRatio, Measure radiusTire) {
		torque = Measurement.convert(torque, "Nm");
		finalDrive = Measurement.convert(finalDrive, "ratio");
		gearRatio = Measurement.convert(gearRatio, "ratio");
		radiusTire = Measurement.convert(radiusTire, "m");
		Double value = (0.0) / radiusTire.getValue();
		return new Measure(value, "N");
	}

	public static Measure rollingResistanceForce(Measure rollingResistance,
												 Measure mass) {
		rollingResistance = Measurement.convert(rollingResistance, "ratio");
		mass = Measurement.convert(mass, "kg");
		Measure gravity = Measurement.convert(PhysicsMath.gravity, "m/s2");
		Double value = rollingResistance.getValue() * mass.getValue() * gravity.
			getValue();
		return new Measure(value, "N");
	}

	public static Measure airResistanceForce(Measure dragCoefficient,
											 Measure frontalArea,
											 Measure relativeSpeed) {
		dragCoefficient = Measurement.convert(dragCoefficient, "ratio");
		frontalArea = Measurement.convert(frontalArea, "m2");
		relativeSpeed = Measurement.convert(relativeSpeed, "m/s");
		Measure airDensity = Measurement.
			convert(PhysicsMath.airDensity, "kg/m3");
		Double value = 0.5 * dragCoefficient.getValue() * frontalArea.
			getValue() * airDensity.getValue() * Math.pow(relativeSpeed.
				getValue(), 2);
		return new Measure(value, "N");
	}

	public static Measure relativeSpeed(Measure carSpeed, Measure windSpeed,
										Measure windDirection) {
		carSpeed = Measurement.module(Measurement.convert(carSpeed, "m/s"));
		windSpeed = Measurement.module(Measurement.convert(windSpeed, "m/s"));
		windDirection = Measurement.convert(windDirection, "°");
		Double value = carSpeed.getValue() + windSpeed.getValue() * Math.
			cos(windDirection.getValue());
		return Measurement.module(new Measure(value, "m/s"));
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
		Double normal = PhysicsMath.getTotalMass(vehicle) * PhysicsMath.gravity.
			getValue();
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
			getFrontalArea().getValue() * PhysicsMath.airDensity.getValue() * Math.
			pow(vehicle.getCurrentVelocity().getValue(), 2.0);
		force = force - aux1 - aux2;
		return force;
	}

	public static Double getTorque(Vehicle vehicle) {
		Double frictionTorque = PhysicsMath.getNormal(vehicle) * vehicle.
			getRollingRCoefficient().getValue() * vehicle.getWheelSize().
			getValue();
		Throttle throttle = Collections.max(vehicle.getThrottles());
		Comparator<Regime> comparator = new Comparator<Regime>() {
			public int compare(Regime regimeA, Regime regimeB) {
				return Double.compare(regimeA.getTorque().getValue(), regimeB.
									  getTorque().getValue());
			}
		};
		Regime regime = Collections.max(throttle.getRegimes(), comparator);
		Double totalTorque = regime.getTorque().getValue() - frictionTorque;
		return totalTorque;
	}

}
