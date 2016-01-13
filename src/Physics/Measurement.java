/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Physics;

import Legacy.Legacy;
import System.Error;
import System.Settings;

/**
 *
 * @author LAPR3_20152016_G27
 */
public abstract class Measurement {

	private static String keyScalesMeasuresFilePath = "ScalesMeasuresFilePath";

	/**
	 *
	 * @return
	 */
	static public String getScalesMeasuresFilePath() {
		return Settings.getOption(Measurement.keyScalesMeasuresFilePath);
	}

	/**
	 *
	 * @param measure
	 * @param unit
	 * @return
	 */
	static public Measure convert(Measure measure, String unit) {
		if (measure == null || unit == null) {
			Error.
				setErrorMessage("The conversion '" + measure + "' to '" + unit + "' was not possible data null!");
			return null;
		}
		if (measure.getUnit().equalsIgnoreCase(unit)) {
			return new Measure(measure.getValue(), unit);
		}
		Double ratio = Legacy.
			importScalesMeasures(Measurement.getScalesMeasuresFilePath()).
			get(measure.getUnit() + unit);
		if (ratio == null) {
			Error.
				setErrorMessage("The conversion '" + measure + "' to '" + unit + "' was not possible because there is no file in the relationship between units!");
			return null;
		}
		ratio = ratio * measure.getValue();
		return new Measure(ratio, unit);
	}

	/**
	 *
	 * @param measureA
	 * @param measureB
	 * @return
	 */
	static public Measure sum(Measure measureA, Measure measureB) {
		measureB = Measurement.convert(measureB, measureA.getUnit());
		if (measureB == null) {
			return null;
		}
		return new Measure(measureA.getValue() + measureB.getValue(), measureA.
						   getUnit());
	}

	/**
	 *
	 * @param measureA
	 * @param measureB
	 * @return
	 */
	public static Measure minus(Measure measureA, Measure measureB) {
		measureB = Measurement.convert(measureB, measureA.getUnit());
		if (measureB == null) {
			return null;
		}
		return new Measure(measureA.getValue() - measureB.getValue(), measureA.
						   getUnit());
	}

	/**
	 *
	 * @param measure
	 * @return
	 */
	public static Measure neg(Measure measure) {
		if (measure == null) {
			return null;
		}
		return new Measure(measure.getValue() * -1, measure.getUnit());
	}

	/**
	 *
	 * @param measure
	 * @return
	 */
	public static Measure module(Measure measure) {
		if (measure.getValue() < 0) {
			measure = Measurement.neg(measure);
		}
		return measure;
	}

}
