/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Legacy;

import Model.Vehicle;
import System.Error;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class VehicleExportXML implements Export {

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
		Vehicle vehicle = (Vehicle) data;
		if (vehicle == null) {
			StringBuilder stringBuilder = new StringBuilder();
			// Preencher
			return stringBuilder.toString();
		}
		Error.
			setErrorMessage("Could not export to XML because the conversion Object to Vehicle failed.");
		return null;
	}

}
