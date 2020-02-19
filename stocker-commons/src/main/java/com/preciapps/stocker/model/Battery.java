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
	@Column(name="capacity",length=13)
	protected String capacity="";
	@Column(name="resistance",length=13)
	protected String resistance="";
	@Column(name="leakage",length=13)
	protected String leakage="";
	@Column(name="ocv",length=13)
	protected String ocv="";
	@Column(name="brand",length=13)
	protected String brand="";
	@Column(name="structure",length=13)
	protected String structure="";
	@Column(name="message",length=255)
	protected String message="";
	@Column(name="stage",length=13)
	protected String stage="";
	@Column(name="serial",length=13)
	protected String serial="";
	
	public Battery(BatteryTypes batteryType, String capacity, String resistance, String leakage, String ocv,
			String brand, String structure, String message, String stage, String serial) {
		super();
		this.batteryType = batteryType;
		this.capacity = capacity;
		this.resistance = resistance;
		this.leakage = leakage;
		this.ocv = ocv;
		this.brand = brand;
		this.structure = structure;
		this.message = message;
		this.stage = stage;
		this.serial = serial;
	}
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
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	public String getResistance() {
		return resistance;
	}
	public void setResistance(String resistance) {
		this.resistance = resistance;
	}
	public String getLeakage() {
		return leakage;
	}
	public void setLeakage(String leakage) {
		this.leakage = leakage;
	}
	public String getOcv() {
		return ocv;
	}
	public void setOcv(String ocv) {
		this.ocv = ocv;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getStructure() {
		return structure;
	}
	public void setStructure(String structure) {
		this.structure = structure;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	
}
