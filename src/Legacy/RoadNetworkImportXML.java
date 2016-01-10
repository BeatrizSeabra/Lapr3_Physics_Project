/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Legacy;

import Model.Node;
import Model.Project;
import Model.RoadNetwork;
import Model.Section;
import Model.Segment;
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
public class RoadNetworkImportXML implements Import<Project> {

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

	@Override
	public List<Project> importData(String data) {
		List<Project> projects = new ArrayList();
		try {
			Project project = null;
			RoadNetwork roadNetwork = null;
			Double value = null;
			String[] info = null;
			Integer numberVehicles = null;
			String text = null, unit = null, road = null, typology = null, direction = null;
			Measure toll = null, windDirection = null, windSpeed = null, height = null, slope = null, length = null, maxVelocity = null, minVelocity = null;
			Node nodeBegin = null, nodeEnd = null;
			Section section = null;
			Segment segment = null;
			List<Segment> segments = null;
			XMLInputFactory factory = XMLInputFactory.newInstance();
			XMLStreamReader reader = factory.
				createXMLStreamReader(new StringReader(data));
			while (reader.hasNext()) {
				int event = reader.next();
				switch (event) {
					case XMLStreamConstants.START_ELEMENT: {
						switch (reader.getLocalName()) {
							case "Network":
								roadNetwork = new RoadNetwork();
								project = new Project();
								project.setName(reader.getAttributeValue(0).
									trim());
								project.setDescription(reader.
									getAttributeValue(1).trim());
								project.setRoadNetwork(roadNetwork);
								projects.add(project);
								break;
							case "node":
								roadNetwork.addNode(new Node(reader.
									getAttributeValue(0).trim()));
								break;
							case "road_section":
								section = new Section();
								nodeBegin = new Node(reader.getAttributeValue(0).
									trim());
								nodeEnd = new Node(reader.getAttributeValue(1).
									trim());
								break;
							case "segment_list":
								segments = new ArrayList();
								break;
							case "segment":
								segment = new Segment();
								segment.setName(reader.getAttributeValue(0).
									trim());
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
							case "road":
								road = text;
								break;
							case "typology":
								typology = text;
								break;
							case "direction":
								direction = text;
								break;
							case "toll":
								value = Util.toValue(text);
								unit = Util.toUnit(text);
								if (!unit.isEmpty()) {
									toll = new Measure(value, unit);
								} else {
									toll = new Measure(value, "€");
								}
								break;
							case "wind_direction":
								value = Util.toValue(text);
								unit = Util.toUnit(text);
								if (!unit.isEmpty()) {
									windDirection = new Measure(value, unit);
								} else {
									windDirection = new Measure(value, "°");
								}
								break;
							case "wind_speed":
								value = Util.toValue(text);
								unit = Util.toUnit(text);
								if (!unit.isEmpty()) {
									windSpeed = new Measure(value, unit);
								} else {
									windSpeed = new Measure(value, "km/h");
								}
								break;
							case "road_section":
								section.setRoad(road);
								section.setTypology(typology);
								section.setDirection(direction);
								section.setToll(toll);
								section.setWindDirection(windDirection);
								section.setWindSpeed(windSpeed);
								roadNetwork.
									addSection(nodeBegin, nodeEnd, section);
								break;
							case "height":
								value = Util.toValue(text);
								unit = Util.toUnit(text);
								if (!unit.isEmpty()) {
									height = new Measure(value, unit);
								} else {
									height = new Measure(value, "km");
								}
								break;
							case "slope":
								value = Util.toValue(text);
								unit = Util.toUnit(text);
								if (!unit.isEmpty()) {
									slope = new Measure(value, unit);
								} else {
									slope = new Measure(value, "%");
								}
								break;
							case "length":
								value = Util.toValue(text);
								unit = Util.toUnit(text);
								if (!unit.isEmpty()) {
									length = new Measure(value, unit);
								} else {
									length = new Measure(value, "km");
								}
								break;
							case "max_velocity":
								value = Util.toValue(text);
								unit = Util.toUnit(text);
								if (!unit.isEmpty()) {
									maxVelocity = new Measure(value, unit);
								} else {
									maxVelocity = new Measure(value, "km/h");
								}
								break;
							case "min_velocity":
								value = Util.toValue(text);
								unit = Util.toUnit(text);
								if (!unit.isEmpty()) {
									minVelocity = new Measure(value, unit);
								} else {
									minVelocity = new Measure(value, "km/h");
								}
								break;
							case "number_vehicles":
								numberVehicles = Util.toInteger(text);
								break;
							case "segment":
								segment.setHeight(height);
								segment.setSlope(slope);
								segment.setLength(length);
								segment.setMaxVelocity(maxVelocity);
								segment.setMinVelocity(minVelocity);
								segment.setNumberVehicles(numberVehicles);
								segments.add(segment);
								break;
							case "segment_list":
								for (Segment seg : segments) {
									section.addSegment(seg);
								}
								segments = null;
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
				setErrorMessage("The XML content contains errors that prevent the loading of data to the road networks list: " + ex);
			return null;
		}
		return projects;
	}

}
