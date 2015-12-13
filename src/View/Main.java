/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Legacy.Legacy;
import Legacy.RoadNetworkImportXML;
import Model.RoadNetwork;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class Main {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		//new ApplicationGUI();
		String data = Legacy.readFile("TestSet01_Network.xml");
		RoadNetworkImportXML classe = new RoadNetworkImportXML();
		List<RoadNetwork> networks = classe.importData(data);
	}
}
