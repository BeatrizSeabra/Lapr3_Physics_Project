/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Legacy;

import Model.Node;
import Model.Project;
import Model.Simulation;
import Model.Traffic;
import Model.Vehicle;
import Physics.Measure;
import System.Error;
import System.Util;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class SimulationImportXML implements Import<Simulation> {

	private Project project;

	@Override
	public String getExtension() {
		return "xml";
	}

	@Override
	public String getExtensionDescription() {
		return "XML Documents (*.xml)";
	}

	@Override
	public FileFilter getExtensionFilter() {
		return new FileNameExtensionFilter(this.getExtensionDescription(), this.
										   getExtension());
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public List<Simulation> importData(String data) {
		List<Simulation> simulations = new ArrayList();
		try {
			Simulation simulation = null;
			Double value = null;
			Node nodeStart = null, nodeEnd = null;
			Vehicle vehicle = null;
			String text = null, unit = null;
			Measure arrivalRate = null;
			XMLInputFactory factory = XMLInputFactory.newInstance();
			XMLStreamReader reader = factory.
				createXMLStreamReader(new StringReader(data));
			while (reader.hasNext()) {
				int event = reader.next();
				switch (event) {
					case XMLStreamConstants.START_ELEMENT: {
						switch (reader.getLocalName()) {
							case "Simulation":
								simulation = new Simulation();
								simulation.setName(reader.getAttributeValue(0).
									trim());
								simulation.setDescription(reader.
									getAttributeValue(1).trim());
								simulations.add(simulation);
								System.out.println(reader.getAttributeValue(0));
								System.out.println(reader.getAttributeValue(1));
								break;
							case "traffic_pattern":
								nodeStart = this.project.getRoadNetwork().
									getNode(reader.getAttributeValue(0));
								nodeEnd = this.project.getRoadNetwork().
									getNode(reader.getAttributeValue(1));
								System.out.println(reader.getAttributeValue(0));
								System.out.println(reader.getAttributeValue(1));
								break;
							default:
								break;
						}
						break;
					}
					case XMLStreamConstants.CHARACTERS: {
						text = reader.getText().replaceAll("\"", "").trim();
						if (!text.isEmpty()) {
							System.out.println(text);
						}
						break;
					}
					case XMLStreamConstants.END_ELEMENT: {
						switch (reader.getLocalName()) {
							case "vehicle":
								vehicle = this.project.getVehicle(text);
								break;
							case "arrival_rate":
								value = Util.toValue(text);
								unit = Util.toUnit(text);
								if (!unit.isEmpty()) {
									arrivalRate = new Measure(value, unit);
								} else {
									arrivalRate = new Measure(value, "/m");
								}
								break;
							case "traffic_pattern":
								if (nodeStart != null && nodeEnd != null && vehicle != null) {
									Traffic traffic = new Traffic();
									traffic.setNodeStart(nodeStart);
									traffic.setNodeEnd(nodeEnd);
									traffic.setVehicle(vehicle);
									traffic.setArrivalRate(arrivalRate);
									simulation.addTraffic(traffic);
								}
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
			System.out.println(ex);
			Error.
				setErrorMessage("The XML content contains errors that prevent the loading of data to the road networks list: " + ex);
			return null;
		}
		return simulations;
	}

}
