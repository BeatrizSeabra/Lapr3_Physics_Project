/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Legacy;

import Model.Regime;
import Model.Throttle;
import Model.Vehicle;
import Physics.Measure;
import System.Error;
import java.util.Map;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class VehicleExportXML implements Export {

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
		Vehicle vehicle = (Vehicle) data;
		if (vehicle != null) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
			stringBuilder.append("<vehicle_list>\n");
			stringBuilder.append("\t<vehicle name=\"");
			stringBuilder.append(vehicle.getName());
			stringBuilder.append("\" description=\"");
			stringBuilder.append(vehicle.getDescription());
			stringBuilder.append("\">\n");
			stringBuilder.append("\t\t<type>");
			stringBuilder.append(vehicle.getType());
			stringBuilder.append("</type>\n");
			stringBuilder.append("\t\t<motorization>");
			stringBuilder.append(vehicle.getMotorization());
			stringBuilder.append("</motorization>\n");
			stringBuilder.append("\t\t<fuel>");
			stringBuilder.append(vehicle.getFuel());
			stringBuilder.append("</fuel>\n");
			stringBuilder.append("\t\t<mass>");
			stringBuilder.append(vehicle.getMass().getValue()).append(" ");
			stringBuilder.append(vehicle.getMass().getUnit());
			stringBuilder.append("</mass>\n");
			stringBuilder.append("\t\t<load>");
			stringBuilder.append(vehicle.getLoad().getValue()).append(" ");
			stringBuilder.append(vehicle.getLoad().getUnit());
			stringBuilder.append("</load>\n");
			stringBuilder.append("\t\t<drag>");
			stringBuilder.append(vehicle.getDragCoefficient().getValue()).
				append(" ");
			stringBuilder.append(vehicle.getDragCoefficient().getUnit());
			stringBuilder.append("</drag>\n");
			stringBuilder.append("\t\t<frontal_area>");
			stringBuilder.append(vehicle.getFrontalArea().getValue()).
				append(" ");
			stringBuilder.append(vehicle.getFrontalArea().getUnit());
			stringBuilder.append("</frontal_area>\n");
			stringBuilder.append("\t\t<rrc>");
			stringBuilder.append(vehicle.getRollingRCoefficient().getValue()).
				append(" ");
			stringBuilder.append(vehicle.getRollingRCoefficient().getUnit());
			stringBuilder.append("</rrc>\n");
			stringBuilder.append("\t\t<wheel_size>");
			stringBuilder.append(vehicle.getWheelSize().getValue()).append(" ");
			stringBuilder.append(vehicle.getWheelSize().getUnit());
			stringBuilder.append("</wheel_size>\n");
			stringBuilder.append("\t\t<velocity_limit_list>\n");
			for (Map.Entry<String, Measure> velocityLimits : vehicle.
				getVelocityLimits().entrySet()) {
				stringBuilder.append("\t\t\t<velocity_limit>\n");
				stringBuilder.append("\t\t\t\t<segment_type>");
				stringBuilder.append(velocityLimits.getKey());
				stringBuilder.append("</segment_type>\n");
				stringBuilder.append("\t\t\t\t<limit>");
				stringBuilder.append(velocityLimits.getValue().getValue()).
					append(" ");
				stringBuilder.append(velocityLimits.getValue().getUnit());
				stringBuilder.append("</limit>\n");
				stringBuilder.append("\t\t\t</velocity_limit>\n");
			}
			stringBuilder.append("\t\t</velocity_limit_list>\n");
			stringBuilder.append("\t\t<energy>\n");
			stringBuilder.append("\t\t\t<min_rpm>");
			stringBuilder.append(vehicle.getMinRPM().getValue()).append(" ");
			stringBuilder.append(vehicle.getMinRPM().getUnit());
			stringBuilder.append("</min_rpm>\n");
			stringBuilder.append("\t\t\t<max_rpm>");
			stringBuilder.append(vehicle.getMaxRPM().getValue()).append(" ");
			stringBuilder.append(vehicle.getMaxRPM().getUnit());
			stringBuilder.append("</max_rpm>\n");
			stringBuilder.append("\t\t\t<final_drive_ratio>");
			stringBuilder.append(vehicle.getFinalDriveRatio().getValue()).
				append(" ");
			stringBuilder.append(vehicle.getFinalDriveRatio().getUnit());
			stringBuilder.append("</final_drive_ratio>\n");
			stringBuilder.append("\t\t\t<gear_list>");
			for (Map.Entry<Integer, Measure> gear : vehicle.getGears().
				entrySet()) {
				stringBuilder.append("\t\t\t\t<gear id=\"");
				stringBuilder.append(gear.getKey());
				stringBuilder.append("\">\n");
				stringBuilder.append("\t\t\t\t<ratio>");
				stringBuilder.append(gear.getValue().getValue()).append(" ");
				stringBuilder.append(gear.getValue().getUnit());
				stringBuilder.append("</ratio>\n");
				stringBuilder.append("\t\t\t\t</gear>\n");
			}
			stringBuilder.append("\t\t\t</gear_list>\n");
			stringBuilder.append("\t\t\t<throttle_list>\n");
			for (Throttle throttle : vehicle.getThrottles()) {
				stringBuilder.append("\t\t\t\t<throttle id=\"");
				stringBuilder.append(throttle.getPercentage().getValue()).
					append(" ");
				stringBuilder.append(throttle.getPercentage().getUnit());
				stringBuilder.append("\">\n");
				for (Regime regime : throttle.getRegimes()) {
					stringBuilder.append("\t\t\t\t\t<regime>\n");
					stringBuilder.append("\t\t\t\t\t\t<torque>");
					stringBuilder.append(regime.getTorque().getValue()).
						append(" ");
					stringBuilder.append(regime.getTorque().getUnit());
					stringBuilder.append("</torque>\n");
					stringBuilder.append("\t\t\t\t\t\t<rpm_low>");
					stringBuilder.append(regime.getRpmLow().getValue()).
						append(" ");
					stringBuilder.append(regime.getRpmLow().getUnit());
					stringBuilder.append("</rpm_low>\n");
					stringBuilder.append("\t\t\t\t\t\t<rpm_high>");
					stringBuilder.append(regime.getRpmHigh().getValue()).
						append(" ");
					stringBuilder.append(regime.getRpmHigh().getUnit());
					stringBuilder.append("</rpm_high>\n");
					stringBuilder.append("\t\t\t\t\t\t<SFC>");
					stringBuilder.append(regime.getFuelConsumption().getValue()).
						append(" ");
					stringBuilder.append(regime.getFuelConsumption().getUnit());
					stringBuilder.append("</SFC>\n");
					stringBuilder.append("\t\t\t\t\t</regime>\n");
				}
				stringBuilder.append("\t\t\t\t</throttle>\n");
			}
			stringBuilder.append("\t\t\t</throttle_list>\n");
			stringBuilder.append("\t\t</energy>\n");
			stringBuilder.append("\t</vehicle>\n");
			stringBuilder.append("</vehicle_list>\n");
			return stringBuilder.toString();
		}
		Error.
			setErrorMessage("Could not export to XML because the conversion Object to Vehicle failed.");
		return null;
	}

}
