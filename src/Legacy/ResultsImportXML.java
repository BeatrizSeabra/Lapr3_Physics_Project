/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Legacy;

import Model.Drop;
import Model.Run;
import Model.Step;
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
public class ResultsImportXML implements Import<Run> {

	/**
	 *
	 * @return
	 */
	@Override
	public String getExtension() {
		return "xml";
	}

	/**
	 *
	 * @return
	 */
	@Override
	public String getExtensionDescription() {
		return "XML Documents (*.xml)";
	}

	/**
	 *
	 * @return
	 */
	@Override
	public FileFilter getExtensionFilter() {
		return new FileNameExtensionFilter(this.getExtensionDescription(), this.
										   getExtension());
	}

	/**
	 *
	 * @param data
	 * @return
	 */
	@Override
	public List<Run> importData(String data) {
		List<Run> runs = new ArrayList();
		try {
			Run run = null;
			String text = null, unit = null, vehicle = null, start = null, end = null, road = null, segment = null, dropVehicle = null, startNode = null, endNode = null;
			Measure entry = null, out = null, power = null, speed = null, relative = null, car = null, rolling = null, air = null, gravity = null, time = null;
			Double value = null;
			Step step = null;
			Drop drop = null;
			XMLInputFactory factory = XMLInputFactory.newInstance();
			XMLStreamReader reader = factory.
				createXMLStreamReader(new StringReader(data));
			while (reader.hasNext()) {
				int event = reader.next();
				switch (event) {
					case XMLStreamConstants.START_ELEMENT: {
						switch (reader.getLocalName()) {
							case "results":
								run = new Run();
								break;
							case "step":
								step = new Step();
								break;
							case "drop":
								drop = new Drop();
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
							case "idRun":
								Integer idRun = Util.toInteger(text);
								if (idRun != null) {
									run.setId(idRun);
								}
								break;
							case "idStep":
								Integer idStep = Util.toInteger(text);
								if (idStep != null) {
									step.setId(idStep);
								}
								break;
							case "idDrop":
								Integer idDrop = Util.toInteger(text);
								if (idDrop != null) {
									drop.setId(idDrop);
								}
								break;
							case "step":
								step.setVehicle(vehicle);
								step.setNodeStart(start);
								step.setNodeEnd(end);
								step.setRoad(road);
								step.setSegment(segment);
								step.setTimeEntry(entry);
								step.setTimeOut(out);
								step.setCarPower(power);
								step.setCarSpeed(speed);
								step.setSpeedRelative(relative);
								step.setCarForce(car);
								step.setRollingForce(rolling);
								step.setAirForce(air);
								step.setGravityForce(gravity);
								run.getSteps().add(step);
								break;
							case "vehicle":
								vehicle = text;
								break;
							case "start":
								start = text;
								break;
							case "end":
								end = text;
								break;
							case "road":
								road = text;
								break;
							case "segment":
								segment = text;
								break;
							case "entry":
								value = Util.toValue(text);
								unit = Util.toUnit(text);
								if (!unit.isEmpty()) {
									entry = new Measure(value, unit);
								} else {
									entry = new Measure(value, "s");
								}
								break;
							case "out":
								value = Util.toValue(text);
								unit = Util.toUnit(text);
								if (!unit.isEmpty()) {
									out = new Measure(value, unit);
								} else {
									out = new Measure(value, "s");
								}
								break;
							case "power":
								value = Util.toValue(text);
								unit = Util.toUnit(text);
								if (!unit.isEmpty()) {
									power = new Measure(value, unit);
								} else {
									power = new Measure(value, "J/s");
								}
								break;
							case "speed":
								value = Util.toValue(text);
								unit = Util.toUnit(text);
								if (!unit.isEmpty()) {
									speed = new Measure(value, unit);
								} else {
									speed = new Measure(value, "km/h");
								}
								break;
							case "relative":
								value = Util.toValue(text);
								unit = Util.toUnit(text);
								if (!unit.isEmpty()) {
									relative = new Measure(value, unit);
								} else {
									relative = new Measure(value, "km/h");
								}
								break;
							case "car":
								value = Util.toValue(text);
								unit = Util.toUnit(text);
								if (!unit.isEmpty()) {
									car = new Measure(value, unit);
								} else {
									car = new Measure(value, "N");
								}
								break;
							case "rolling":
								value = Util.toValue(text);
								unit = Util.toUnit(text);
								if (!unit.isEmpty()) {
									rolling = new Measure(value, unit);
								} else {
									rolling = new Measure(value, "N");
								}
								break;
							case "air":
								value = Util.toValue(text);
								unit = Util.toUnit(text);
								if (!unit.isEmpty()) {
									air = new Measure(value, unit);
								} else {
									air = new Measure(value, "N");
								}
								break;
							case "gravity":
								value = Util.toValue(text);
								unit = Util.toUnit(text);
								if (!unit.isEmpty()) {
									gravity = new Measure(value, unit);
								} else {
									gravity = new Measure(value, "N");
								}
								break;
							case "dropVehicle":
								dropVehicle = text;
								break;
							case "nodestart":
								startNode = text;
								break;
							case "nodeend":
								endNode = text;
								break;
							case "time":
								value = Util.toValue(text);
								unit = Util.toUnit(text);
								if (!unit.isEmpty()) {
									time = new Measure(value, unit);
								} else {
									time = new Measure(value, "s");
								}
								break;
							case "drop":
								drop.setVehicle(dropVehicle);
								drop.setNodeStart(startNode);
								drop.setNodeEnd(endNode);
								drop.setTime(time);
								run.getDrops().add(drop);
								break;
							case "results":
								runs.add(run);
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
		return runs;
	}

}
