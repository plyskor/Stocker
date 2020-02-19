/**
 * 
 */
package com.preciapps.stocker.model;

/**
 * @author joseantoniogarciadelsaz
 *
 */
public class Constants {
	public enum BatteryTypes {
		STAND(Values.TYPE_BATTERY_STANDARD);
		private BatteryTypes(String type) {
			
		}
		public static class Values {
			// Available battery types
			public static final String TYPE_BATTERY_STANDARD = "STAND";
		}
	}
}
