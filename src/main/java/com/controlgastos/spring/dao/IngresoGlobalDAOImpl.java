package com.controlgastos.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.controlgastos.spring.model.IngresoGlobal;

@Repository
public class IngresoGlobalDAOImpl implements IngresoGlobalDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(IngresoGlobalDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addIngresoGlobal(IngresoGlobal ig) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(ig);
		logger.info("Ingreso global guardado con éxito, Ingreso Global Details="+ig);
	}

	@Override
	public void updateIngresoGlobal(IngresoGlobal ig) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(ig);
		logger.info("Ingreso Global actualizado con éxito, Ingreso Global Details="+ig);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IngresoGlobal> listIngresoGlobal() {
		Session session = this.sessionFactory.getCurrentSession();
		List<IngresoGlobal> ingresoGlobalList = session.createQuery("from IngresoGlobal").list();
		for(IngresoGlobal ig : ingresoGlobalList){
			logger.info("Ingreso Global List::"+ig);
		}
		return ingresoGlobalList;
	}

	@Override
	public IngresoGlobal getIngresoGlobalById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		IngresoGlobal ig = (IngresoGlobal) session.load(IngresoGlobal.class, new Integer(id));
		logger.info("Ingreso Global cargado con exito, Tipo de ingreso details="+ig);
		return ig;
	}

	@Override
	public void removeIngresoGlobal(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		IngresoGlobal ig = (IngresoGlobal) session.load(IngresoGlobal.class, new Integer(id));
		if(null != ig){
			session.delete(ig);
		}
		logger.info("Ingreso Global borrado con exito, Tipo de gasto details="+ig);
	}

}
