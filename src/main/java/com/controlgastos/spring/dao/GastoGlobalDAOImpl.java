package com.controlgastos.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.controlgastos.spring.model.GastoGlobal;

@Repository
public class GastoGlobalDAOImpl implements GastoGlobalDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(GastoGlobalDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addGastoGlobal(GastoGlobal gg) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(gg);
		logger.info("Gasto global guardado con éxito, Gasto Global Details="+gg);
	}

	@Override
	public void updateGastoGlobal(GastoGlobal gg) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(gg);
		logger.info("Gasto Global actualizado con éxito, Gasto Global Details="+gg);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GastoGlobal> listGastoGlobal() {
		Session session = this.sessionFactory.getCurrentSession();
		List<GastoGlobal> gastoGlobalList = session.createQuery("from GastoGlobal").list();
		for(GastoGlobal gg : gastoGlobalList){
			logger.info("Gasto Global List::"+gg);
		}
		return gastoGlobalList;
	}

	@Override
	public GastoGlobal getGastoGlobalById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		GastoGlobal gg = (GastoGlobal) session.load(GastoGlobal.class, new Integer(id));
		logger.info("gasto Global cargado con exito, Gasto global details="+gg);
		return gg;
	}

	@Override
	public void removeGastoGlobal(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		GastoGlobal gg = (GastoGlobal) session.load(GastoGlobal.class, new Integer(id));
		if(null != gg){
			session.delete(gg);
		}
		logger.info("Gasto Global borrado con exito, Tipo de gasto details="+gg);
	}

}
