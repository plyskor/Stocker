/**
 * 
 */
package com.preciapps.stocker.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

import com.preciapps.stocker.model.Constants.BatteryTypes;

/**
 * @author joseantoniogarciadelsaz
 *
 */
@Entity
@DiscriminatorValue(value=BatteryTypes.Values.TYPE_BATTERY_STANDARD)
public class StandardBattery extends Battery {

	public StandardBattery(String capacity, String resistance, String leakage, String ocv,
			String brand, String structure, String message, String stage, String serial) {
		super(BatteryTypes.STAND, capacity, resistance, leakage, ocv, brand, structure, message, stage, serial);
	}
	public StandardBattery() {
		super();
	}
	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = -4212024644012626354L;

}
