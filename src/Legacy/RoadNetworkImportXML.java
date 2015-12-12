/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Legacy;

import Model.RoadNetwork;
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
			String text = "", road = "", typology = "", direction = "", toll = "", wind_direction = "", wind_speed = "",
				height = "", slope = "", length = "", rrc = "", max_velocity = "", min_velocity = "", number_vehicles = "";
			XMLInputFactory factory = XMLInputFactory.newInstance();
			XMLStreamReader reader = factory.
				createXMLStreamReader(new StringReader(data));
			while (reader.hasNext()) {
				int event = reader.next();
				switch (event) {
					case XMLStreamConstants.START_ELEMENT: {
						switch (reader.getLocalName()) {
							case "section_list":
								System.out.println("Section List:");
								break;
							case "road_section":
								System.out.println("Road Section:");
								break;
							// Secção dos roads
							case "road":
								road = "";
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
							//Secção dos segments
							case "segment_list":
								System.out.
									println("Road: " + road
										+ "\ntypology: " + typology
										+ "\ndirection: " + direction
										+ "\nToll: " + toll
										+ "\nWind diretion: " + wind_direction
										+ "\nWind Speed: " + wind_speed);
								System.out.println("Lista Segments:");
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
							// Secção dos roads
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
								toll = text;
								break;
							case "wind_direction":
								wind_direction = text;
								break;
							case "wind_speed":
								wind_speed = text;
								break;
							//Secção dos segments
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
								System.out.
									println("Segment: \nHeight: " + height + "\nSlope: " + slope
										+ "\nLength: " + length + "\nRCC: " + rrc + "\nMax V: "
										+ max_velocity + "\nMin V: " + min_velocity + "\nNumber veichles: "
										+ number_vehicles);
								break;
							case "segment_list":
								System.out.println();
								break;
							case "road_section":
								System.out.println();
								break;
							case "section_list":
								System.out.println();
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
