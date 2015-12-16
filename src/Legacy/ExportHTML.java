/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Legacy;

import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author ruben
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

	public String export(String text) {
		String aux = this.begin();
		aux += this.addText(text);
		aux += this.endFile();
		return aux;
	}

	private static String begin() {
		return "<!DOCTYPE> <html>   <head>       <title>Project LAPR3</title>       <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">       <link rel=\"icon\" type=\"image/ico\" href=\"http://www.isep.ipp.pt/favicon.ico\">   </head>   <body>       <div align=\"center\">       <img src=\"http://www.dei.isep.ipp.pt/images/topo_index.png\" alt=\"Logotipo ISEP\" >       </div>";
	}

	private String addText(String text) {
		String aux = " <div align=\"center\">  " + text + "   </div>";

		return aux;
	}

	private String endFile() {
		return "</body></html>";
	}

}
