/**
 * 
 */
package com.preciapps.stocker.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.InheritanceType;
import javax.persistence.DiscriminatorType;
import com.preciapps.stocker.model.Constants.BatteryTypes;

/**
 * @author joseantoniogarciadelsaz
 *
 */
@Entity
@Table(name = "perm_battery")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "battery_type",length=6, discriminatorType = DiscriminatorType.STRING)
public abstract class Battery implements Serializable {
	@Transient
	private static final long serialVersionUID = -8417485775067077771L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "identifier")
	private int identifier; 
	@Column(name = "battery_type", length=5,nullable = false, insertable = false, updatable = false)
	@Enumerated(EnumType.STRING)
	public BatteryTypes batteryType;
	@Column(name="serial",length=13)
	protected String serial="";
	
	
	public int getIdentifier() {
		return identifier;
	}
	public void setIdentifier(int identifier) {
		this.identifier = identifier;
	}
	public BatteryTypes getBatteryType() {
		return batteryType;
	}
	public void setBatteryType(BatteryTypes batteryType) {
		this.batteryType = batteryType;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
