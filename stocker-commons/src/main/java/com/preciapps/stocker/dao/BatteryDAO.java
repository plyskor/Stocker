/**
 * 
 */
package com.preciapps.stocker.dao;

import org.springframework.stereotype.Repository;

import com.preciapps.stocker.dao.inter.BatteryDAOInterface;
import com.preciapps.stocker.model.Battery;

/**
 * @author joseantoniogarciadelsaz
 *
 */
@Repository
public class BatteryDAO extends AbstractGenericDAO<Battery,Integer> implements BatteryDAOInterface{

	public BatteryDAO() {
		super();
	}

}
