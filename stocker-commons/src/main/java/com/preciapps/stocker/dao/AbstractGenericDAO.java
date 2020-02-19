/**
 * 
 */
package com.preciapps.stocker.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.preciapps.stocker.dao.inter.GenericDAOInterface;

/**
 * @author joseantoniogarciadelsaz
 *
 */
@SuppressWarnings("unchecked")
@Repository
public abstract class AbstractGenericDAO<V extends Serializable, K extends Serializable>
		implements GenericDAOInterface<V, K> {
	@Autowired
    private SessionFactory sessionFactory;
     
    protected Class<V> daoType;
 
	public AbstractGenericDAO() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        daoType = (Class<V>) pt.getActualTypeArguments()[0];
    }
     
    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }
    
    public void saveOrUpdate(V entity) {
        currentSession().saveOrUpdate(entity);
    } 
    
    public void persist(V entity) {
        currentSession().save(entity);
    }
    
    public boolean existsAny(K id) {
    	V entity = find(id);
    	return (entity==null) ? false : true;
    }
    
    public void update(V entity) {
        currentSession().saveOrUpdate(entity);
    }
     
    
    public void delete(V entity) {
        currentSession().delete(entity);
    }
    
    public void detach(V entity) {
        currentSession().detach(entity);
    }
    
    public void detachList(List<V> entityList) {
		if(entityList==null)return;
		for(V entity : entityList) {
			currentSession().detach(entity);
		}
    }
    
    public void merge(V entity) {
        currentSession().merge(entity);
    }
     
    
    public V find(K key) {
        return currentSession().get(daoType, key);
    }
    
    public List<V> getAll() {
        return currentSession().createQuery("from "+daoType.getName()).list(); 
    }
    
	public void refresh(V entity) {
		currentSession().refresh(entity);
	}
    
    public void deleteById(K idDB) {
		V entity = find(idDB);
		if(entity!=null)delete(entity);
	}
    
    public void deleteAll() {
		List<V> entityList = getAll();
		for (V entity : entityList) {
			delete(entity);
		}
	}
    
    public void persistList(List<V> entityList) {
		if(entityList==null)return;
		for(V entity : entityList) {
			persist(entity);
		}
	}
    
    public void deleteList(List<V> entityList) {
		if(entityList==null)return;
		for(V entity : entityList) {
			delete(entity);
		}
	}
    
	public void initialize(Object lazyObject) {
		Hibernate.initialize(lazyObject);
	}
	
	public void flush() {
		currentSession().flush();
	}

}
