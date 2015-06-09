package pojo;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Record entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see pojo.Record
 * @author MyEclipse Persistence Tools
 */

public class RecordDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(RecordDAO.class);
	// property constants
	public static final String REC_ORI = "recOri";
	public static final String REC_DES = "recDes";
	public static final String REC_VALUE = "recValue";

	public void save(Record transientInstance) {
		log.debug("saving Record instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Record persistentInstance) {
		log.debug("deleting Record instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Record findById(java.lang.Integer id) {
		log.debug("getting Record instance with id: " + id);
		try {
			Record instance = (Record) getSession().get("pojo.Record", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Record instance) {
		log.debug("finding Record instance by example");
		try {
			List results = getSession().createCriteria("pojo.Record").add(
					Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Record instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Record as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPropertys(String[]propertyName,Object[] value){    
	    StringBuffer sqlBuffer = new StringBuffer(); 
	    sqlBuffer.append("from Record as model\n");  
	    int len=propertyName.length;  
	    List list=new ArrayList();  
	    boolean first=true;  
	    for(int i=0;i< len;i++){  
	    	if(value[i]!=null){  
	    		if(first){      
	    			sqlBuffer.append(" where "+ "model."+ propertyName[i] + "= ?\n");      
	    			list.add(value[i]);  
	    			first=false;  
	    		}else{      
	    			sqlBuffer.append(" and "+ "model."+ propertyName[i] + "= ?\n");      
	    			list.add(value[i]);  
	    		}  
	    	}  
	    }  
	    
	    try {
	    	Query queryObject = getSession().createQuery(sqlBuffer.toString());
	    	for(int i=0;i< list.size();i++){    
	    		queryObject.setParameter(i, list.get(i));   
	    	}  
	    	list=queryObject.list();  
	    	return list;  
	    } catch (RuntimeException re) {  
	    	log.error("find by property name failed", re);  
	    	throw re;  
	    }  
	 
	}
	
	public List findIn(List<User> ori){
		List list=new ArrayList();
		String ori_args="";
//		String des_args="";
		for(int i=0;i<ori.size()-1;i++)
			ori_args+=ori.get(i).getUId()+",";
		ori_args+=ori.get(ori.size()-1).getUId();
//		for(int i=0;i<des.length-1;i++)
//			des_args+=des[i]+",";
//		des_args+=des[des.length-1];
		String sql=String.format("from Record as model where model.recOri in(%s) or model.recDes in(%s)", ori_args,ori_args);
		 try {
		    	Query queryObject = getSession().createQuery(sql);
		    	list=queryObject.list();  
		    	return list;  
		    } catch (RuntimeException re) {  
		    	log.error("find by property name failed", re);  
		    	throw re;  
		    }  
	}
	
	
	public List findByRecOri(Object recOri) {
		return findByProperty(REC_ORI, recOri);
	}

	public List findByRecDes(Object recDes) {
		return findByProperty(REC_DES, recDes);
	}

	public List findByRecValue(Object recValue) {
		return findByProperty(REC_VALUE, recValue);
	}

	public List findAll() {
		log.debug("finding all Record instances");
		try {
			String queryString = "from Record";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Record merge(Record detachedInstance) {
		log.debug("merging Record instance");
		try {
			Record result = (Record) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Record instance) {
		log.debug("attaching dirty Record instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Record instance) {
		log.debug("attaching clean Record instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}