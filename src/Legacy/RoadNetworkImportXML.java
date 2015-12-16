/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Legacy;

import Model.Node;
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
public class RoadNetworkImportXML implements Import<RoadNetwork> {

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
	public List<RoadNetwork> importData(String data) {
		List<RoadNetwork> networks = new ArrayList();
		try {
			RoadNetwork roadNetwork = null;
			String text = null, road = null, typology = null, direction = null, windSpeedUnit = null, lengthUnit = null, maxVelocityUnit = null, minVelocityUnit = null;
			Double toll = null, windDirection = null, windSpeed = null, height = null, slope = null, length = null, rrc = null, maxVelocity = null, minVelocity = null, numberVehicles = null;
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
								roadNetwork.setName(reader.getAttributeValue(0).
									trim());
								roadNetwork.setDescription(reader.
									getAttributeValue(1).trim());
								networks.add(roadNetwork);
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
								toll = Util.toDouble(text);
								break;
							case "wind_direction":
								windDirection = Util.toDouble(text);
								break;
							case "wind_speed":
								String windSpeedData[] = text.split(" ");
								windSpeed = Util.toDouble(windSpeedData[0].
									trim());
								windSpeedUnit = windSpeedData[1].trim();
								break;
							case "road_section":
								section.setRoad(road);
								section.setTypology(typology);
								section.setDirection(direction);
								section.setToll(toll);
								section.setWindDirection(windDirection);
								section.
									setWindSpeed(new Measure(windSpeed, windSpeedUnit));
								roadNetwork.
									addSection(nodeBegin, nodeEnd, section);
								break;
							case "height":
								height = Util.toDouble(text);
								break;
							case "slope":
								slope = Util.toDouble(text.split("%")[0]);
								break;
							case "length":
								String lengthData[] = text.split(" ");
								length = Util.toDouble(lengthData[0]);
								lengthUnit = lengthData[1].trim();
								break;
							case "max_velocity":
								String maxVelocityData[] = text.split(" ");
								maxVelocity = Util.toDouble(maxVelocityData[0]);
								maxVelocityUnit = maxVelocityData[1].trim();
								break;
							case "min_velocity":
								String minVelocityData[] = text.split(" ");
								minVelocity = Util.toDouble(minVelocityData[0]);
								minVelocityUnit = minVelocityData[1].trim();
								break;
							case "number_vehicles":
								numberVehicles = Util.toDouble(text);
								break;
							case "segment":
								segment.setHeight(height);
								segment.setSlope(slope);
								segment.
									setLength(new Measure(length, lengthUnit));
								segment.
									setMaxVelocity(new Measure(maxVelocity, maxVelocityUnit));
								segment.
									setMinVelocity(new Measure(minVelocity, minVelocityUnit));
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
		return networks;
	}

}
