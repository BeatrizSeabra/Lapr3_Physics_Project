/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Physics.Measure;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class Throttle implements Comparable<Throttle> {

	private Integer id = 0;
	private Measure percentage;
	private List<Regime> regimes = new ArrayList();

	public Boolean addRegime(Regime regime) {
		return this.regimes.add(regime);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the percentage
	 */
	public Measure getPercentage() {
		return percentage;
	}

	/**
	 * @param percentage the percentage to set
	 */
	public void setPercentage(Measure percentage) {
		this.percentage = percentage;
	}

	/**
	 * @return the regimes
	 */
	public List<Regime> getRegimes() {
		return regimes;
	}

	/**
	 * @param regimes the regimes to set
	 */
	public void setRegimes(List<Regime> regimes) {
		this.regimes = regimes;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Throttle other = (Throttle) obj;
		if (other == null) {
			return false;
		}
		return this.hashCode() == other.hashCode();
	}

	@Override
	public int hashCode() {
		int hash = 29 * this.getClass().hashCode();
		hash += 11 * this.id.hashCode();
		hash += 11 * this.percentage.hashCode();
		for (Regime regime : this.getRegimes()) {
			hash += 7 * regime.hashCode();
		}
		return hash;
	}

	@Override
	protected Throttle clone() {
		Throttle throttle = new Throttle();
		throttle.setId(this.id);
		throttle.setPercentage(this.percentage.clone());
		for (Regime regime : this.regimes) {
			throttle.addRegime(regime.clone());
		}
		return throttle;
	}

	@Override
	public int compareTo(Throttle throttle) {
		return this.percentage.compareTo(throttle.percentage);
	}

}
