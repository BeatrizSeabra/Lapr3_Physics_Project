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
public class ExportHTML implements Export {

	@Override
	public String getExtension() {
		return "html";
	}

	@Override
	public String getExtensionDescription() {
		return "HTML Documents (*.html)";
	}

	@Override
	public FileNameExtensionFilter getExtensionFilter() {
		return new FileNameExtensionFilter(this.getExtensionDescription(), this.
										   getExtension());
	}

	public String export(Object data) {
		List<String[]> dataList = (List<String[]>) data;
		if (dataList != null) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(this.start());
			stringBuilder.append(this.tabela(dataList));
			stringBuilder.append(this.end());
			return stringBuilder.toString();
		}
		Error.
			setErrorMessage("Could not export to HTML because the conversion Object to List<String[]> failed.");
		return null;
	}

	private String start() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<!DOCTYPE html>");
		stringBuilder.append("<html>");
		stringBuilder.append("    <head>");
		stringBuilder.append("        <title>");
		stringBuilder.append("            Export File HTML");
		stringBuilder.append("        </title>\n");
		stringBuilder.
			append("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		stringBuilder.
			append("        <link rel=\"icon\" type=\"image/ico\" href=\"http://www.isep.ipp.pt/favicon.ico\">");
		stringBuilder.append("    </head>");
		stringBuilder.append("    <body>");
		stringBuilder.append("        <div>");
		stringBuilder.
			append("            <img src=\"http://www.dei.isep.ipp.pt/images/topo_index.png\" alt=\"Logotipo ISEP\">");
		stringBuilder.append("        </div>");
		stringBuilder.append("        <hr>");
		stringBuilder.append("        <div>");
		return stringBuilder.toString();
	}

	private String tabela(List<String[]> data) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("            <TABLE>");
		for (String[] line : data) {
			stringBuilder.append("                <TR>");
			for (String column : line) {
				stringBuilder.
					append("                    <TD align='center'>&nbsp;").
					append(column).append("&nbsp;</TD>");
			}
			stringBuilder.append("                </TR>");
		}
		stringBuilder.append("            </TABLE>");
		stringBuilder.append("            <br>");
		return stringBuilder.toString();
	}

	private String end() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("        </div>");
		stringBuilder.append("        <hr>");
		stringBuilder.append("    </body>");
		stringBuilder.append("</html>");
		return stringBuilder.toString();
	}

}
