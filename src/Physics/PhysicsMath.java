/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Physics;

import java.util.Random;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class PhysicsMath {

	/**
	 *
	 */
	public static final Measure gravity = new Measure(9.80665, "m/s2");

	/**
	 *
	 */
	public static final Measure airDensity = new Measure(1.225, "kg/m3");

	/**
	 *
	 */
	public static final Measure specificEnergyGasoline = new Measure(44400.0, "J/g");

	/**
	 *
	 */
	public static final Measure specificEnergyDiesel = new Measure(48000.0, "J/g");

	/**
	 *
	 */
	public static final Random random = new Random();

	/**
	 *
	 * @param averagePerPeriod
	 * @return
	 */
	public static Double exponentialDistributionRandom(Double averagePerPeriod) {
		return -Math.log(PhysicsMath.random.nextDouble()) / (1.0 / averagePerPeriod);
	}

	/**
	 *
	 * @param power
	 * @param fuelConsumption
	 * @return
	 */
	public static Measure realPowerGasoline(Measure power,
											Measure fuelConsumption) {
		power = Measurement.convert(power, "J/s");
		fuelConsumption = Measurement.convert(fuelConsumption, "g/J");
		Measure specificEnergy = Measurement.
			convert(PhysicsMath.specificEnergyGasoline, "J/g");
		Double value = power.getValue() * fuelConsumption.getValue() * specificEnergy.
			getValue();
		return new Measure(value, "J/s");
	}

	/**
	 *
	 * @param power
	 * @param fuelConsumption
	 * @return
	 */
	public static Measure realPowerDiesel(Measure power, Measure fuelConsumption) {
		power = Measurement.convert(power, "J/s");
		fuelConsumption = Measurement.convert(fuelConsumption, "g/J");
		Measure specificEnergy = Measurement.
			convert(PhysicsMath.specificEnergyDiesel, "J/g");
		Double value = power.getValue() * fuelConsumption.getValue() * specificEnergy.
			getValue();
		return new Measure(value, "J/s");
	}

	/**
	 *
	 * @param torque
	 * @param rotations
	 * @param gearRatio
	 * @return
	 */
	public static Measure engineCarPower(Measure torque, Measure rotations,
										 Measure gearRatio) {
		rotations = Measurement.convert(rotations, "rps");
		Measure torqueEngineSpeed = PhysicsMath.
			torqueEngineSpeed(torque, rotations, gearRatio);
		Double value = 2 * Math.PI * torqueEngineSpeed.getValue() * rotations.
			getValue();
		return new Measure(value, "J/s");
	}

	/**
	 *
	 * @param mass
	 * @param slope
	 * @return
	 */
	public static Measure gravityForce(Measure mass, Measure slope) {
		mass = Measurement.convert(mass, "kg");
		Measure gravity = Measurement.convert(PhysicsMath.gravity, "m/s2");
		Measure angle = PhysicsMath.angle(slope);
		Double value = mass.getValue() * gravity.getValue() * Math.sin(angle.
			getValue());
		return new Measure(value, "N");
	}

	/**
	 *
	 * @param torque
	 * @param finalDrive
	 * @param rotations
	 * @param gearRatio
	 * @param radiusTire
	 * @return
	 */
	public static Measure engineCarForce(Measure torque, Measure finalDrive,
										 Measure rotations, Measure gearRatio,
										 Measure radiusTire) {
		torque = Measurement.convert(torque, "Nm");
		finalDrive = Measurement.convert(finalDrive, "ratio");
		gearRatio = Measurement.convert(gearRatio, "ratio");
		radiusTire = Measurement.convert(radiusTire, "m");
		Measure torqueEngineSpeed = PhysicsMath.
			torqueEngineSpeed(torque, rotations, gearRatio);
		Double value = (torqueEngineSpeed.getValue() * finalDrive.getValue() * gearRatio.
			getValue()) / radiusTire.getValue();
		return new Measure(value, "N");
	}

	/**
	 *
	 * @param torque
	 * @param rotations
	 * @param gearRatio
	 * @return
	 */
	public static Measure torqueEngineSpeed(Measure torque, Measure rotations,
											Measure gearRatio) {
		torque = Measurement.convert(torque, "Nm");
		rotations = Measurement.convert(rotations, "rps");
		gearRatio = Measurement.convert(gearRatio, "ratio");
		Double value = (torque.getValue() / rotations.getValue()) * gearRatio.
			getValue(); // Esta por cada 1 RPS
		//Double value = (torque.getValue() / rotations.getValue()) * (gearRatio.getValue() * 1000 / 60); // Esta por cada 1000 RPM
		return new Measure(value, "Nm");
	}

	/**
	 *
	 * @param rollingResistance
	 * @param mass
	 * @param slope
	 * @return
	 */
	public static Measure rollingResistanceForce(Measure rollingResistance,
												 Measure mass, Measure slope) {
		rollingResistance = Measurement.convert(rollingResistance, "ratio");
		mass = Measurement.convert(mass, "kg");
		Measure gravity = Measurement.convert(PhysicsMath.gravity, "m/s2");
		Measure angle = PhysicsMath.angle(slope);
		Double value = rollingResistance.getValue() * mass.getValue() * gravity.
			getValue() * Math.cos(angle.getValue());
		return new Measure(value, "N");
	}

	/**
	 *
	 * @param dragCoefficient
	 * @param frontalArea
	 * @param relativeSpeed
	 * @return
	 */
	public static Measure airResistanceForce(Measure dragCoefficient,
											 Measure frontalArea,
											 Measure relativeSpeed) {
		dragCoefficient = Measurement.convert(dragCoefficient, "ratio");
		frontalArea = Measurement.convert(frontalArea, "m2");
		relativeSpeed = Measurement.convert(relativeSpeed, "m/s");
		Measure airDensity = Measurement.
			convert(PhysicsMath.airDensity, "kg/m3");
		Double value = 0.5 * dragCoefficient.getValue() * frontalArea.getValue() * airDensity.
			getValue() * Math.pow(relativeSpeed.getValue(), 2);
		return new Measure(value, "N");
	}

	/**
	 *
	 * @param acceleration
	 * @param mass
	 * @param coefficientInertial
	 * @return
	 */
	public static Measure inertiaResistanceForce(Measure acceleration,
												 Measure mass,
												 Measure coefficientInertial) {
		acceleration = Measurement.convert(acceleration, "m/s2");
		mass = Measurement.convert(mass, "kg");
		coefficientInertial = Measurement.convert(coefficientInertial, "ratio");
		Double value = acceleration.getValue() * mass.getValue() * coefficientInertial.
			getValue();
		return new Measure(value, "N");
	}

	/**
	 *
	 * @param carSpeed
	 * @param windSpeed
	 * @param windDirection
	 * @return
	 */
	public static Measure relativeSpeed(Measure carSpeed, Measure windSpeed,
										Measure windDirection) {
		carSpeed = Measurement.module(Measurement.convert(carSpeed, "m/s"));
		windSpeed = Measurement.module(Measurement.convert(windSpeed, "m/s"));
		windDirection = Measurement.convert(windDirection, "°");
		Double value = carSpeed.getValue() + windSpeed.getValue() * Math.
			cos(windDirection.getValue());
		return Measurement.module(new Measure(value, "m/s"));
	}

	/**
	 *
	 * @param radiusTire
	 * @param rotations
	 * @param finalDrive
	 * @param gearRatio
	 * @return
	 */
	public static Measure carSpeed(Measure radiusTire, Measure rotations,
								   Measure finalDrive, Measure gearRatio) {
		radiusTire = Measurement.module(Measurement.convert(radiusTire, "m"));
		rotations = Measurement.module(Measurement.convert(rotations, "rps"));
		finalDrive = Measurement.convert(finalDrive, "ratio");
		gearRatio = Measurement.convert(gearRatio, "ratio");
		Double value = (2 * Math.PI * radiusTire.getValue() * rotations.
			getValue()) / (finalDrive.getValue() * gearRatio.getValue());
		return Measurement.module(new Measure(value, "m/s"));
	}

	/**
	 *
	 * @param slope
	 * @return
	 */
	public static Measure angle(Measure slope) {
		slope = Measurement.convert(slope, "%");
		Double value = Math.toDegrees(Math.atan(slope.getValue() / 100.0));
		return Measurement.module(new Measure(value, "°"));
	}

}
