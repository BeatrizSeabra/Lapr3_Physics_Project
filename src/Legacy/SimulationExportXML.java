/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Legacy;

import Model.Simulation;
import Model.Traffic;
import System.Error;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class SimulationExportXML implements Export {

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
	public FileNameExtensionFilter getExtensionFilter() {
		return new FileNameExtensionFilter(this.getExtensionDescription(), this.
										   getExtension());
	}

	/**
	 *
	 * @param data
	 * @return
	 */
	public String export(Object data) {
		Simulation simulation = (Simulation) data;
		if (simulation != null) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
			stringBuilder.append("<Simulation id=\"");
			stringBuilder.append(simulation.getName());
			stringBuilder.append("\" description=\"");
			stringBuilder.append(simulation.getDescription());
			stringBuilder.append("\">\n");
			stringBuilder.append("\t<traffic_list>\n");
			for (Traffic traffic : simulation.getTraffics()) {
				stringBuilder.append("\t\t<traffic_pattern begin=\"");
				stringBuilder.append(traffic.getNodeStart().getName());
				stringBuilder.append("\" end=\"");
				stringBuilder.append(traffic.getNodeEnd().getName());
				stringBuilder.append("\">\n");
				stringBuilder.append("\t\t\t<vehicle>");
				stringBuilder.append(traffic.getVehicle().getName());
				stringBuilder.append("</vehicle>\n");
				stringBuilder.append("\t\t\t<arrival_rate>");
				stringBuilder.append(traffic.getArrivalRate().getValue()).
					append(" 1");
				stringBuilder.append(traffic.getArrivalRate().getUnit());
				stringBuilder.append("</arrival_rate>\n");
				stringBuilder.append("\t\t</traffic_pattern>\n");
			}
			stringBuilder.append("\t</traffic_list>\n");
			stringBuilder.append("</Simulation>");
			return stringBuilder.toString();
		}
		Error.
			setErrorMessage("Could not export to XML because the conversion Object to Simulation failed.");
		return null;
	}

}
