/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Legacy;

import Data.Data;
import Model.Vehicle;
import System.Error;
import System.Util;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class VehicleImportXML implements VehicleImport {

	@Override
	public String getExtension() {
		return "xml";
	}

	@Override
	public List<Vehicle> importData(String data) {
		List<Vehicle> vehicles = new ArrayList();
		Vehicle vehicle = null;
		String text = null;
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
								vehicles.add(vehicle);
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
								vehicle.
									setType(text);
								break;
							case "motorization":
								vehicle.setMotorization(text);
								break;
							case "mass":
								vehicle.setMass(Util.toDouble(text));
								break;
							case "load":
								vehicle.setLoad(Util.toDouble(text));
								break;
							case "drag_coefficient":
								vehicle.setDragCoefficient(Util.toDouble(text));
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
