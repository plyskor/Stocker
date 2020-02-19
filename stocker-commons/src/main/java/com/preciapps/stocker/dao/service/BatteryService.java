/**
 * 
 */
package com.preciapps.stocker.dao.service;

/**
 * @author joseantoniogarciadelsaz
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.preciapps.stocker.dao.AbstractGenericDAO;
import com.preciapps.stocker.dao.BatteryDAO;
import com.preciapps.stocker.dao.service.inter.BatteryServiceInterface;
import com.preciapps.stocker.model.Battery;



/**
 * @author Jose Antonio García del Saz
 *
 */
@Service
public class BatteryService extends GenericService<Battery, Integer> implements BatteryServiceInterface{
	private BatteryDAO batteryDAO;
    public BatteryService(){
    	super();
    }
    @Autowired
    public BatteryService(
            AbstractGenericDAO<Battery, Integer> genericDao) {
        super(genericDao);
        this.batteryDAO = (BatteryDAO) genericDao;
    }
   

}