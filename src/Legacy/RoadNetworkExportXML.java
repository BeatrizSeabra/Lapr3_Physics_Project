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
import System.Error;
import java.util.Deque;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class RoadNetworkExportXML implements Export {

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

	public String export(Object data) {
		Project project = (Project) data;
		RoadNetwork roadNetwork = project.getRoadNetwork().getOrigin();
		if (project != null) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
			stringBuilder.append("<Network id=\"");
			stringBuilder.append(project.getName());
			stringBuilder.append("\"description=\"");
			stringBuilder.append(project.getDescription());
			stringBuilder.append("\">\n");
			stringBuilder.append("\t<node_list>\n");
			for (Node node : roadNetwork.getNodes()) {
				stringBuilder.append("\t\t<node id=\"");
				stringBuilder.append(node.getName());
				stringBuilder.append("\"/>\n");
			}
			stringBuilder.append("	</node_list>");
			stringBuilder.append("	<section_list>");
			for (Section section : roadNetwork.getSections()) {
				Deque<Node> nodes = roadNetwork.getExtremeNodes(section);
				stringBuilder.append("		<road_section begin=\"");
				stringBuilder.append(nodes.getFirst().getName());
				stringBuilder.append("\" end=\"");
				stringBuilder.append(nodes.getLast().getName());
				stringBuilder.append("\">\n");
				stringBuilder.append("			<road>");
				stringBuilder.append(section.getRoad());
				stringBuilder.append("</road>\n");
				stringBuilder.append("			<typology>");
				stringBuilder.append(section.getTypology());
				stringBuilder.append("</typology>\n");
				stringBuilder.append("			<direction>");
				stringBuilder.append(section.getDirection());
				stringBuilder.append("</direction>\n");
				stringBuilder.append("			<toll>");
				stringBuilder.append(section.getToll().getValue());
				stringBuilder.append(" ");
				stringBuilder.append(section.getToll().getUnit());
				stringBuilder.append("</toll>\n");
				stringBuilder.append("			<wind_direction>");
				stringBuilder.append(section.getWindDirection().getValue()).
					append(" ");
				stringBuilder.append(section.getWindDirection().getUnit());
				stringBuilder.append("</wind_direction>\n");
				stringBuilder.append("			<wind_speed>");
				stringBuilder.append(section.getWindSpeed().getValue()).
					append(" ");
				stringBuilder.append(section.getWindSpeed().getUnit());
				stringBuilder.append("</wind_speed>\n");
				stringBuilder.append("			<segment_list>");
				for (Segment segment : section.getSegments()) {
					stringBuilder.append("			<segment id=\"");
					stringBuilder.append(segment.getName());
					stringBuilder.append("\">\n");
					stringBuilder.append("			<height>");
					stringBuilder.append(segment.getHeight().getValue()).
						append(" ");
					stringBuilder.append(segment.getHeight().getUnit());
					stringBuilder.append("</height>\n");
					stringBuilder.append("			<slope>");
					stringBuilder.append(segment.getSlope().getValue()).
						append(" ");
					stringBuilder.append(segment.getSlope().getUnit());
					stringBuilder.append("</slope>\n");
					stringBuilder.append("			<length>");
					stringBuilder.append(segment.getLength().getValue()).
						append(" ");
					stringBuilder.append(segment.getLength().getUnit());
					stringBuilder.append("</length>\n");
					stringBuilder.append("			<max_velocity>");
					stringBuilder.append(segment.getMaxVelocity().getValue()).
						append(" ");
					stringBuilder.append(segment.getMaxVelocity().getUnit());
					stringBuilder.append("</max_velocity>\n");
					stringBuilder.append("			<min_velocity>");
					stringBuilder.append(segment.getMinVelocity().getValue()).
						append(" ");
					stringBuilder.append(segment.getMinVelocity().getUnit());
					stringBuilder.append("</min_velocity>\n");
					stringBuilder.append("			<number_vehicles>");
					stringBuilder.append(segment.getNumberVehicles());
					stringBuilder.append("</number_vehicles>\n");
					stringBuilder.append("				</segment>\n");
				}
				stringBuilder.append("			</segment_list>\n");
			}
			stringBuilder.append("		</road_section>\n");
			stringBuilder.append("	</section_list>\n");
			stringBuilder.append("</Network>");
			return stringBuilder.toString();
		}
		Error.
			setErrorMessage("Could not export to XML because the conversion Object to Project failed.");
		return null;
	}

}
