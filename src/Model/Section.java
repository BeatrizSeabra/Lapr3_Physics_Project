/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Physics.Measure;
import Physics.Measurement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class Section {

	private String road;
	private String typology;
	private String direction;
	private Measure toll;
	private Measure windDirection;
	private Measure windSpeed;
	private List<Segment> segments = new ArrayList();

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
	 * @return the typology
	 */
	public String getTypology() {
		return typology;
	}

	/**
	 * @param typology the typology to set
	 */
	public void setTypology(String typology) {
		this.typology = typology;
	}

	/**
	 * @return the direction
	 */
	public String getDirection() {
		return direction;
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(String direction) {
		this.direction = direction;
	}

	/**
	 * @return the toll
	 */
	public Measure getToll() {
		return toll;
	}

	/**
	 * @param toll the toll to set
	 */
	public void setToll(Measure toll) {
		this.toll = toll;
	}

	/**
	 * @return the windDirection
	 */
	public Measure getWindDirection() {
		return windDirection;
	}

	/**
	 * @param windDirection the windDirection to set
	 */
	public void setWindDirection(Measure windDirection) {
		this.windDirection = windDirection;
	}

	/**
	 * @return the windSpeed
	 */
	public Measure getWindSpeed() {
		return windSpeed;
	}

	/**
	 * @param windSpeed the windSpeed to set
	 */
	public void setWindSpeed(Measure windSpeed) {
		this.windSpeed = windSpeed;
	}

	/**
	 * @return the segments
	 */
	public List<Segment> getSegments() {
		return new ArrayList(this.segments);
	}

	public Boolean addSegment(Segment segment) {
		return this.segments.add(segment);
	}

	public Measure getTotalLength() {
		Measure measure = new Measure(0.0, "km");
		for (Segment segment : this.segments) {
			measure = Measurement.sum(measure, segment.getLength());
		}
		return measure;
	}

	public Measure getTotalForce(Vehicle vehicle) {
		Measure totalForce = new Measure(0.0, "N");
		for (Segment segment : this.segments) {
			Measurement.sum(totalForce, segment.getSlopeForce(vehicle));
		}
		return totalForce;
	}

	@Override
	public String toString() {
		return "Section | road: " + this.road + " | typology: " + this.typology + " | direction: " + this.direction + " | toll: " + this.toll + " | windDirection: " + this.windDirection + " | windSpeed: " + this.windSpeed;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Section other = (Section) obj;
		if (other == null) {
			return false;
		}
		return this.hashCode() == other.hashCode();
	}

	@Override
	public int hashCode() {
		int hash = 29 * this.getClass().hashCode();
		hash += 11 * this.road.hashCode();
		hash += 11 * this.typology.hashCode();
		hash += 11 * this.direction.hashCode();
		hash += 11 * this.toll.hashCode();
		hash += 11 * this.windDirection.hashCode();
		hash += 11 * this.windSpeed.hashCode();
		for (Segment segment : this.segments) {
			hash += 11 * segment.hashCode();
		}
		return hash;
	}

	public Section reverse() {
		Section section = new Section();
		section.setRoad(this.road);
		section.setTypology(this.typology);
		section.setDirection(this.direction);
		section.setToll(this.toll);
		section.setWindDirection(this.windDirection);
		section.setWindSpeed(Measurement.neg(this.windSpeed));
		List<Segment> segments = new ArrayList(this.segments);
		Collections.reverse(segments);
		for (Segment segment : segments) {
			section.addSegment(segment.reverse());
		}
		return section;
	}

}
