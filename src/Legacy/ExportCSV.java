/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Legacy;

import System.Error;
import java.util.List;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class ExportCSV implements Export {

	@Override
	public String getExtension() {
		return "csv";
	}

	@Override
	public String getExtensionDescription() {
		return "CSV Documents (*.csv)";
	}

	@Override
	public FileNameExtensionFilter getExtensionFilter() {
		return new FileNameExtensionFilter(this.getExtensionDescription(), this.
										   getExtension());
	}

	public String export(Object data) {
		List<String[]> dataList = (List<String[]>) data;
		if (dataList != null) {
			StringBuilder stringBuilderFinal = new StringBuilder();
			for (String[] line : dataList) {
				StringBuilder stringBuilder = new StringBuilder();
				for (String column : line) {
					stringBuilder.append(";");
					stringBuilder.append(column);
				}
				stringBuilderFinal.append(stringBuilder.toString().substring(1));
				stringBuilderFinal.append("\n");
			}
			return stringBuilderFinal.toString();
		}
		Error.
			setErrorMessage("Could not export to CSV because the conversion Object to List<String[]> failed.");
		return null;
	}

}
