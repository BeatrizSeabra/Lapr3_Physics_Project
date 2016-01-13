/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Physics;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class Measure implements Comparable<Measure> {

	private Double value = 0.0;
	private String unit = "ratio";

	/**
	 *
	 * @param value
	 * @param unit
	 */
	public Measure(Double value, String unit) {
		if (value == null) {
			this.value = 0.0;
		} else {
			this.value = value;
		}
		if (unit.isEmpty()) {
			this.unit = "ratio";
		} else {
			this.unit = unit;
		}
	}

	/**
	 * @return the value
	 */
	public Double getValue() {
		return this.value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(Double value) {
		this.value = value;
	}

	/**
	 * @return the unit
	 */
	public String getUnit() {
		return this.unit;
	}

	/**
	 * @param unit the unit to set
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Measure other = (Measure) obj;
		if (other == null) {
			return false;
		}
		return this.hashCode() == other.hashCode();
	}

	@Override
	public int hashCode() {
		int hash = 29 * this.getClass().hashCode();
		hash += 11 * this.value.hashCode();
		hash += 11 * this.unit.hashCode();
		return hash;
	}

	@Override
	public String toString() {
		return new StringBuilder(String.format("%.2f", this.value)).append(" ").
			append(unit).toString();
	}

	@Override
	public int compareTo(Measure measure) {
		measure = Measurement.convert(measure, this.unit);
		return this.value.compareTo(measure.getValue());
	}

	@Override
	public Measure clone() {
		return new Measure(this.value, this.unit);
	}

}
