/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Legacy;

import Model.Node;
import Model.Road;
import Model.RoadNetwork;
import Model.Section;
import Model.Segment;
import Physics.Measure;
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
public class RoadNetworkImportXML implements RoadNetworkImport {

	@Override
	public String getExtension() {
		return "xml";
	}

	@Override
	public List<RoadNetwork> importData(String data) {
		List<RoadNetwork> networks = new ArrayList();
		try {
			String text = "", idNetwork = "", networkDescription = "", idNode = "", roadBegin = "", roadEnd = "",
				segmentId = "", roadName = "", typology = "", direction = "", toll = "", wind_direction = "", wind_speed = "",
				height = "", slope = "", length = "", rrc = "", max_velocity = "", min_velocity = "", number_vehicles = "";
			ArrayList<Node> listNodes = null;
			ArrayList<Segment> listSegments = null;
			ArrayList<Section> listSections = null;
			RoadNetwork roadNetwork = null;
			Node node = null;
			Road road = null;
			Section section = null;
			Segment segment = null;
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
								idNetwork = reader.getAttributeValue(0);
								networkDescription = reader.getAttributeValue(1);
								break;
							case "node_list":
								listNodes = new ArrayList();
							case "node":
								idNode = reader.getAttributeValue(0);
								node = new Node();
								node.setName(idNode);
								roadNetwork.addNode(node);
								break;
							case "section_list":
								listSections = new ArrayList();
								break;
							case "road_section":
								roadNetwork = null;
								section = null;
								roadBegin = reader.getAttributeValue(0);
								roadEnd = reader.getAttributeValue(1);
								break;
							case "road":
								road = null;
								roadName = "";
								break;
							case "typology":
								typology = "";
								break;
							case "direction":
								direction = "";
								break;
							case "toll":
								toll = "";
								break;
							case "wind_direction":
								wind_direction = "";
								break;
							case "wind_speed":
								wind_speed = "";
								break;
							case "segment_list":
								listSegments = new ArrayList();
								break;
							case "segment":
								segment = null;
								segmentId = reader.getAttributeValue(0);
								break;
							case "height":
								height = "";
								break;
							case "slope":
								slope = "";
								break;
							case "length":
								length = "";
								break;
							case "rrc":
								rrc = "";
								break;
							case "max_velocity":
								max_velocity = "";
								break;
							case "min_velocity":
								min_velocity = "";
								break;
							case "number_vehicles":
								number_vehicles = "";
								break;
						}
						break;
					}
					case XMLStreamConstants.CHARACTERS: {
						text = reader.getText().trim();
						break;
					}
					case XMLStreamConstants.END_ELEMENT: {
						switch (reader.getLocalName()) {
							case "road":
								roadName = text;
								road = new Road();
								road.setName(roadName);
								break;
							case "typology":
								typology = text;
								break;
							case "direction":
								direction = text;
								break;
							case "toll":
								toll = text;
								break;
							case "wind_direction":
								wind_direction = text;
								break;
							case "wind_speed":
								wind_speed = text;
								break;
							case "height":
								height = text;
								break;
							case "slope":
								slope = text;
								break;
							case "length":
								length = text;
								break;
							case "rrc":
								rrc = text;
								break;
							case "max_velocity":
								max_velocity = text;
								break;
							case "min_velocity":
								min_velocity = text;
								break;
							case "number_vehicles":
								number_vehicles = text;
								break;
							case "segment":
								segment = new Segment();
								segment.setName(segmentId);
								segment.setHeight(Double.parseDouble(height));
								slope = slope.substring(0, slope.length() - 1);
								segment.setSlope(Double.parseDouble(slope));
								String[] auxiliar = length.split(" ");
								segment.setLength(new Measure(Double.
									parseDouble(auxiliar[0]), auxiliar[1]));
								segment.setRrc(Double.parseDouble(rrc));
								auxiliar = max_velocity.split(" ");
								segment.setMaxVelocity(new Measure(Double.
									parseDouble(auxiliar[0]), auxiliar[1]));
								auxiliar = min_velocity.split(" ");
								segment.setMinVelocity(new Measure(Double.
									parseDouble(auxiliar[0]), auxiliar[1]));
								segment.setNumberVehicles(Double.
									parseDouble(number_vehicles));
								listSegments.add(segment);
								break;
							case "road_section":
								section = new Section();
								road = new Road();
								road.setName(roadName);
								section.setRoad(road.getName());
								section.setTypology(typology);
								section.setDirection(direction);
								section.setToll(Double.parseDouble(toll));
								section.setWindDirection(Double.
									parseDouble(wind_direction));
								auxiliar = wind_speed.split(" ");
								section.setWindSpeed(new Measure(Double.
									parseDouble(auxiliar[0]), auxiliar[1]));
								for (Segment seg : listSegments) {
									section.addSegment(seg);
								}
								listSections.add(section);
								roadNetwork = new RoadNetwork();
								Node nodeBegin = new Node();
								nodeBegin.setName(roadBegin);
								Node nodeEnd = new Node();
								nodeEnd.setName(roadEnd);
								roadNetwork.
									addSection(nodeBegin, nodeEnd, section);
								break;
						}
						break;
					}
				}
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return networks;
	}
}
