/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Legacy;

import Model.RoadNetwork;
import java.util.ArrayList;
import java.util.List;

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
		return networks;
	}

}
