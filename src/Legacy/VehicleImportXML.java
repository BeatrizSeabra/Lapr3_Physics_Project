/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Legacy;

import Model.Regime;
import Model.Throttle;
import Model.Vehicle;
import Physics.Measure;
import System.Error;
import System.Util;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class VehicleImportXML implements Import<Vehicle> {

	@Override
	public String getExtension() {
		return "xml";
	}

	@Override
	public String getExtensionDescription() {
		return "XML Documents (*.xml)";
	}

	@Override
	public FileNameExtensionFilter getExtensionFilter() {
		return new FileNameExtensionFilter(this.getExtensionDescription(), this.
										   getExtension());
	}

	@Override
	public List<Vehicle> importData(String data) {
		List<Vehicle> vehicles = new ArrayList();
		String[] info = null;
		Vehicle vehicle = null;
		String text = null, unit = null;
		Double value = null;
		String segmentType = null;
		Integer gearId = null, throttleId = null;
		Throttle throttle = null;
		Regime regime = null;
		try {
			XMLInputFactory factory = XMLInputFactory.newInstance();
			XMLStreamReader reader = factory.
				createXMLStreamReader(new StringReader(data));
			while (reader.hasNext()) {
				int event = reader.next();
				switch (event) {
					case XMLStreamConstants.START_ELEMENT: {
						switch (reader.getLocalName()) {
							case "vehicle":
								vehicle = new Vehicle();
								vehicle.setName(reader.getAttributeValue(0).
									trim());
								vehicle.setDescription(reader.
									getAttributeValue(1).trim());
								vehicles.add(vehicle);
								break;
							case "gear":
								gearId = Integer.parseInt(reader.
									getAttributeValue(0).trim());
								break;
							case "throttle":
								throttle = new Throttle();
								text = reader.getAttributeValue(0).trim();
								value = Util.toValue(text);
								unit = Util.toUnit(text);
								if (!unit.isEmpty()) {
									throttle.
										setPercentage(new Measure(value, unit));
								} else {
									throttle.
										setPercentage(new Measure(value, "%"));
								}
								break;
							default:
								break;
						}
						break;
					}
					case XMLStreamConstants.CHARACTERS: {
						text = reader.getText().replaceAll("\"", "").trim();
						break;
					}
					case XMLStreamConstants.END_ELEMENT: {
						switch (reader.getLocalName()) {
							case "type":
								vehicle.setType(text);
								break;
							case "motorization":
								vehicle.setMotorization(text);
								break;
							case "fuel":
								vehicle.setFuel(text);
								break;
							case "mass":
								value = Util.toValue(text);
								unit = Util.toUnit(text);
								if (!unit.isEmpty()) {
									vehicle.setMass(new Measure(value, unit));
								} else {
									vehicle.setMass(new Measure(value, "kg"));
								}
								break;
							case "load":
								value = Util.toValue(text);
								unit = Util.toUnit(text);
								if (!unit.isEmpty()) {
									vehicle.setLoad(new Measure(value, unit));
								} else {
									vehicle.setLoad(new Measure(value, "kg"));
								}
								break;
							case "drag":
								value = Util.toValue(text);
								unit = Util.toUnit(text);
								if (!unit.isEmpty()) {
									vehicle.
										setDragCoefficient(new Measure(value, unit));
								} else {
									vehicle.
										setDragCoefficient(new Measure(value, "ratio"));
								}
								break;
							case "frontal_area":
								value = Util.toValue(text);
								unit = Util.toUnit(text);
								if (!unit.isEmpty()) {
									vehicle.
										setFrontalArea(new Measure(value, unit));
								} else {
									vehicle.
										setFrontalArea(new Measure(value, "m2"));
								}
								break;
							case "rrc":
								value = Util.toValue(text);
								unit = Util.toUnit(text);
								if (!unit.isEmpty()) {
									vehicle.
										setRollingRCoefficient(new Measure(value, unit));
								} else {
									vehicle.
										setRollingRCoefficient(new Measure(value, "ratio"));
								}
								break;
							case "wheel_size":
								value = Util.toValue(text);
								unit = Util.toUnit(text);
								if (!unit.isEmpty()) {
									vehicle.
										setWheelSize(new Measure(value, unit));
								} else {
									vehicle.
										setWheelSize(new Measure(value, "m"));
								}
								break;
							case "segment_type":
								segmentType = text;
								break;
							case "limit":
								value = Util.toValue(text);
								unit = Util.toUnit(text);
								if (!unit.isEmpty()) {
									vehicle.
										setVelocityLimits(segmentType, new Measure(value, unit));
								} else {
									vehicle.
										setVelocityLimits(segmentType, new Measure(value, "km/h"));
								}
								break;
							case "min_rpm":
								value = Util.toValue(text);
								unit = Util.toUnit(text);
								if (!unit.isEmpty()) {
									vehicle.setMinRPM(new Measure(value, unit));
								} else {
									vehicle.setMinRPM(new Measure(value, "rpm"));
								}
								break;
							case "max_rpm":
								value = Util.toValue(text);
								unit = Util.toUnit(text);
								if (!unit.isEmpty()) {
									vehicle.setMaxRPM(new Measure(value, unit));
								} else {
									vehicle.setMaxRPM(new Measure(value, "rpm"));
								}
								break;
							case "final_drive_ratio":
								value = Util.toValue(text);
								unit = Util.toUnit(text);
								if (!unit.isEmpty()) {
									vehicle.
										setFinalDriveRatio(new Measure(value, unit));
								} else {
									vehicle.
										setFinalDriveRatio(new Measure(value, "ratio"));
								}
								break;
							case "ratio":
								value = Util.toValue(text);
								unit = Util.toUnit(text);
								if (!unit.isEmpty()) {
									vehicle.
										setGear(gearId, new Measure(value, unit));
								} else {
									vehicle.
										setGear(gearId, new Measure(value, "ratio"));
								}
								break;
							case "torque":
								regime = new Regime();
								value = Util.toValue(text);
								unit = Util.toUnit(text);
								if (!unit.isEmpty()) {
									regime.setTorque(new Measure(value, unit));
								} else {
									regime.setTorque(new Measure(value, "Nm"));
								}
								break;
							case "rpm_low":
								value = Util.toValue(text);
								unit = Util.toUnit(text);
								if (!unit.isEmpty()) {
									regime.setRpmLow(new Measure(value, unit));
								} else {
									regime.setRpmLow(new Measure(value, "rpm"));
								}
								break;
							case "rpm_high":
								value = Util.toValue(text);
								unit = Util.toUnit(text);
								if (!unit.isEmpty()) {
									regime.setRpmHigh(new Measure(value, unit));
								} else {
									regime.setRpmHigh(new Measure(value, "rpm"));
								}
								break;
							case "SFC":
								value = Util.toValue(text);
								unit = Util.toUnit(text);
								if (!unit.isEmpty()) {
									regime.
										setFuelConsumption(new Measure(value, unit));
								} else {
									regime.
										setFuelConsumption(new Measure(value, "km/l"));
								}
								break;
							case "regime":
								throttle.addRegime(regime);
								break;
							case "throttle":
								vehicle.addThrottle(throttle);
								break;
							default:
								break;
						}
						break;
					}
					default:
						break;
				}
			}
		} catch (Exception ex) {
			Error.
				setErrorMessage("The XML content contains errors that prevent the loading of data to the vehicles list!");
			return null;
		}
		return vehicles;
	}

}
