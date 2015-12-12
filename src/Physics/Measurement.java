/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Physics;

import Legacy.Legacy;
import System.Error;

/**
 *
 * @author LAPR3_20152016_G27
 */
public abstract class Measurement {

	static public Measure convertMeasure(Measure measure, String unit) {
		if (measure.getUnit().equalsIgnoreCase(unit)) {
			return new Measure(measure.getValue(), unit);
		}
		for (String[] data : Legacy.importScalesMeasures()) {
			if (data[0].equalsIgnoreCase(measure.getUnit()) && data[1].
				equalsIgnoreCase(unit)) {
				return new Measure(measure.getValue() * Double.
					parseDouble(data[2]), unit);
			}
		}
		Error.
			setErrorMessage("The conversion was not possible because there is no file in the relationship between units!");
		return null;
	}

	static public Boolean sumMeasures(Measure measure, Measure measureSum) {
		if (!measure.getUnit().equalsIgnoreCase(measureSum.getUnit())) {
			return null;
		}
		measureSum = Measurement.convertMeasure(measureSum, measure.getUnit());
		if (measureSum == null) {
			return null;
		}
		measure.setValue(measure.getValue() + measureSum.getValue());
		return null;
	}

}
