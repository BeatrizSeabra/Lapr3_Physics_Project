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

	static public String getScalesMeasuresFilePath() {
		return Settings.getOption(Measurement.keyScalesMeasuresFilePath);
	}

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

	static public Measure sum(Measure measureA, Measure measureB) {
		measureB = Measurement.convert(measureB, measureA.getUnit());
		if (measureB == null) {
			return null;
		}
		return new Measure(measureA.getValue() + measureB.getValue(), measureA.
						   getUnit());
	}

	public static Measure minus(Measure measureA, Measure measureB) {
		measureB = Measurement.convert(measureB, measureA.getUnit());
		if (measureB == null) {
			return null;
		}
		return new Measure(measureA.getValue() - measureB.getValue(), measureA.
						   getUnit());
	}

	public static Measure neg(Measure measure) {
		if (measure == null) {
			return null;
		}
		return new Measure(measure.getValue() * -1, measure.getUnit());
	}

}
