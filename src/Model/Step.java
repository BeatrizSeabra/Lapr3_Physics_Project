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
public class Step {

	private String vehicle;
	private String nodeStart;
	private String nodeEnd;
	private String road;
	private String segment;
	private String timeEntry;
	private String timeOut;
	private String carPower;
	private String carSpeed;
	private String speedRelative;
	private String carForce;
	private String rollingForce;
	private String airForce;
	private String gravityForce;

	public Step(String vehicle, String nodeStart, String nodeEnd, String road,
				String segment, String timeEntry, String timeOut,
				String carPower, String carSpeed, String speedRelative,
				String carForce, String rollingForce, String airForce,
				String gravityForce) {
		this.vehicle = vehicle;
		this.nodeStart = nodeStart;
		this.nodeEnd = nodeEnd;
		this.road = road;
		this.segment = segment;
		this.timeEntry = timeEntry;
		this.timeOut = timeOut;
		this.carPower = carPower;
		this.carSpeed = carSpeed;
		this.speedRelative = speedRelative;
		this.carForce = carForce;
		this.rollingForce = rollingForce;
		this.airForce = airForce;
		this.gravityForce = gravityForce;
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
	 * @return the road
	 */
	public String getRoad() {
		return road;
	}

	/**
	 * @param road the road to set
	 */
	public void setRoad(String road) {
		this.road = road;
	}

	/**
	 * @return the segment
	 */
	public String getSegment() {
		return segment;
	}

	/**
	 * @param segment the segment to set
	 */
	public void setSegment(String segment) {
		this.segment = segment;
	}

	/**
	 * @return the timeEntry
	 */
	public String getTimeEntry() {
		return timeEntry;
	}

	/**
	 * @param timeEntry the timeEntry to set
	 */
	public void setTimeEntry(String timeEntry) {
		this.timeEntry = timeEntry;
	}

	/**
	 * @return the timeOut
	 */
	public String getTimeOut() {
		return timeOut;
	}

	/**
	 * @param timeOut the timeOut to set
	 */
	public void setTimeOut(String timeOut) {
		this.timeOut = timeOut;
	}

	/**
	 * @return the carPower
	 */
	public String getCarPower() {
		return carPower;
	}

	/**
	 * @param carPower the carPower to set
	 */
	public void setCarPower(String carPower) {
		this.carPower = carPower;
	}

	/**
	 * @return the carSpeed
	 */
	public String getCarSpeed() {
		return carSpeed;
	}

	/**
	 * @param carSpeed the carSpeed to set
	 */
	public void setCarSpeed(String carSpeed) {
		this.carSpeed = carSpeed;
	}

	/**
	 * @return the speedRelative
	 */
	public String getSpeedRelative() {
		return speedRelative;
	}

	/**
	 * @param speedRelative the speedRelative to set
	 */
	public void setSpeedRelative(String speedRelative) {
		this.speedRelative = speedRelative;
	}

	/**
	 * @return the carForce
	 */
	public String getCarForce() {
		return carForce;
	}

	/**
	 * @param carForce the carForce to set
	 */
	public void setCarForce(String carForce) {
		this.carForce = carForce;
	}

	/**
	 * @return the rollingForce
	 */
	public String getRollingForce() {
		return rollingForce;
	}

	/**
	 * @param rollingForce the rollingForce to set
	 */
	public void setRollingForce(String rollingForce) {
		this.rollingForce = rollingForce;
	}

	/**
	 * @return the airForce
	 */
	public String getAirForce() {
		return airForce;
	}

	/**
	 * @param airForce the airForce to set
	 */
	public void setAirForce(String airForce) {
		this.airForce = airForce;
	}

	/**
	 * @return the gravityForce
	 */
	public String getGravityForce() {
		return gravityForce;
	}

	/**
	 * @param gravityForce the gravityForce to set
	 */
	public void setGravityForce(String gravityForce) {
		this.gravityForce = gravityForce;
	}

}
