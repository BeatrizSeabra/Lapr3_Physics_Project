/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Oracle;

import Data.ProjectData;
import Data.Repository;
import Data.SimulationData;
import Data.VehicleData;
import System.Error;
import System.Settings;
import java.sql.CallableStatement;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class RepositoryOracle implements Repository {

	private OracleDataSource oracleDataSource;
	private Connection connection;

	private ProjectData projactData;
	private VehicleData vehicleData;
	private SimulationData simulationData;

	public RepositoryOracle() {
		try {
			this.oracleDataSource = new OracleDataSource();
			this.oracleDataSource.setURL(Settings.getOption("Oracle"));
			this.connection = this.oracleDataSource.getConnection();
			this.projactData = new ProjectDataOracle(this.connection);
			this.vehicleData = new VehicleDataOracle(this.connection);
			this.simulationData = new SimulationDataOracle(this.connection);
		} catch (Exception ex) {
			Error.setErrorMessage("Oracle Database does not start:" + ex);
		}
	}

	public Integer getNextIndex() {
		try {
			CallableStatement callableStatement = connection.
				prepareCall("BEGIN GETNEXTINDEX(?); END;");
			callableStatement.registerOutParameter(1, OracleTypes.NUMBER);
			callableStatement.execute();
			return callableStatement.getInt(1);
		} catch (Exception ex) {
			Error.
				setErrorMessage("Oracle Database does not execute GETNEXTINDEX:" + ex);
			return null;
		}
	}

	@Override
	public ProjectData getProjectData() {
		return this.projactData;
	}

	@Override
	public VehicleData getVehicleData() {
		return this.vehicleData;
	}

	@Override
	public SimulationData getSimulationData() {
		return this.simulationData;
	}

}
