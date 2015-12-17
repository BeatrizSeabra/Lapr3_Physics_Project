/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Legacy;

import Data.Data;
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
		Vehicle vehicle = null;
		String text = null;
		Double mass = null;
		String massType = null;
		Double load = null;
		String loadType = null;
		String segmentType = null;
		Integer gearId = null;
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
								vehicle = Data.getVehicleData().newInstance();
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
								String massData[] = text.split(" ");
								mass = Util.toDouble(massData[0].trim());
								massType = massData[1].trim();
								vehicle.setMass(new Measure(mass, massType));
								break;
							case "load":
								String loadData[] = text.split(" ");
								load = Util.toDouble(loadData[0].trim());
								loadType = loadData[1].trim();
								vehicle.setLoad(new Measure(load, loadType));
								break;
							case "drag":
								vehicle.setDragCoefficient(Util.toDouble(text));
								break;
							case "rrc":
								vehicle.setRollingRCoefficient(Util.
									toDouble(text));
								break;
							case "wheel_size":
								vehicle.setWheelSize(Util.toDouble(text));
								break;
							case "segment_type":
								segmentType = text;
								break;
							case "limit":
								vehicle.setVelocityLimits(segmentType, Util.
														  toDouble(text));
								break;
							case "torque":
								vehicle.setTorque(Util.toDouble(text));
								break;
							case "rpm":
								vehicle.setRPM(Util.toDouble(text));
								break;
							case "consumption":
								vehicle.setComsumption(Util.toDouble(text));
								break;
							case "min_rpm":
								vehicle.setMinRPM(Util.toDouble(text));
								break;
							case "max_rpm":
								vehicle.setMaxRPM(Util.toDouble(text));
								break;
							case "final_drive_ratio":
								vehicle.setFinalDriveRatio(Util.toDouble(text));
								break;
							case "ratio":
								vehicle.setGear(gearId, Util.toDouble(text));
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
