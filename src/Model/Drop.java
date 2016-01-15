/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class Drop {

	private String vehicle;
	private String nodeStart;
	private String nodeEnd;
	private String time;

	public Drop(String vehicle, String nodeStart, String nodeEnd, String time) {
		this.vehicle = vehicle;
		this.nodeStart = nodeStart;
		this.nodeEnd = nodeEnd;
		this.time = time;
	}

	/**
	 * @return the vehicle
	 */
	public String getVehicle() {
		return vehicle;
	}

	/**
	 * @param vehicle the vehicle to set
	 */
	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

	/**
	 * @return the nodeStart
	 */
	public String getNodeStart() {
		return nodeStart;
	}

	/**
	 * @param nodeStart the nodeStart to set
	 */
	public void setNodeStart(String nodeStart) {
		this.nodeStart = nodeStart;
	}

	/**
	 * @return the nodeEnd
	 */
	public String getNodeEnd() {
		return nodeEnd;
	}

	/**
	 * @param nodeEnd the nodeEnd to set
	 */
	public void setNodeEnd(String nodeEnd) {
		this.nodeEnd = nodeEnd;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}

}
