/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Physics.Measure;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class Drop {

	private Integer id = 0;
	private String vehicle;
	private String nodeStart;
	private String nodeEnd;
	private Measure time;

	/**
	 * @return the vehicle
	 */
	public String getVehicle() {
		return this.vehicle;
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
		return this.nodeStart;
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
		return this.nodeEnd;
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
	public Measure getTime() {
		return this.time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(Measure time) {
		this.time = time;
	}

	/**
	 * @return the vector string
	 */
	public String[] getResult() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(vehicle);
		stringBuffer.append(";");
		stringBuffer.append(nodeStart);
		stringBuffer.append(";");
		stringBuffer.append(nodeEnd);
		stringBuffer.append(";");
		stringBuffer.append(time);
		return stringBuffer.toString().split(";");
	}

	static public String[] getLegend() {
		return "Vehicle;Node Start;Node End;Time Drop".split(";");
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Drop other = (Drop) obj;
		if (other == null) {
			return false;
		}
		return this.hashCode() == other.hashCode();
	}

	@Override
	public int hashCode() {
		int hash = 29 * this.getClass().hashCode();
		hash += 11 * this.getVehicle().hashCode();
		hash += 11 * this.getNodeStart().hashCode();
		hash += 11 * this.getNodeEnd().hashCode();
		hash += 11 * this.getTime().hashCode();
		return hash;
	}

	@Override
	public String toString() {
		return "Drop | vehicle: " + this.vehicle + " | node start: " + this.nodeStart + " | node end: " + this.nodeEnd + " | time: " + this.time;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
}
