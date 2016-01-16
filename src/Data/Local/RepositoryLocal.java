/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Local;

import Data.ProjectData;
import Data.Repository;
import Data.RunData;
import Data.SimulationData;
import Data.VehicleData;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class RepositoryLocal implements Repository {

	private ProjectData projactData = new ProjectDataLocal();
	private VehicleData vehicleData = new VehicleDataLocal();
	private SimulationData simulationData = new SimulationDataLocal();
	private RunData runData = new RunDataLocal();

	/**
	 *
	 * @return
	 */
	@Override
	public ProjectData getProjectData() {
		return this.projactData;
	}

	/**
	 *
	 * @return
	 */
	@Override
	public VehicleData getVehicleData() {
		return this.vehicleData;
	}

	/**
	 *
	 * @return
	 */
	@Override
	public SimulationData getSimulationData() {
		return this.simulationData;
	}

	/**
	 *
	 * @return
	 */
	@Override
	public RunData getRunData() {
		return this.runData;
	}

}
