package com.controlgastos.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.controlgastos.spring.model.TipoIngreso;

@Repository
public class TipoIngresoDAOImpl implements TipoIngresoDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(TipoIngresoDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addTipoIngreso(TipoIngreso t) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(t);
		logger.info("Tipo de ingreso guardado con éxito, Tipo de Ingreso Details="+t);
	}

	@Override
	public void updateTipoIngreso(TipoIngreso t) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(t);
		logger.info("Tipo de ingreso cargado con éxito, Tipo de ingreso Details="+t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoIngreso> listTipoIngreso() {
		Session session = this.sessionFactory.getCurrentSession();
		List<TipoIngreso> tipoIngresoList = session.createQuery("from TipoIngreso").list();
		for(TipoIngreso p : tipoIngresoList){
			logger.info("Tipo Ingreso List::"+p);
		}
		return tipoIngresoList;
	}

	@Override
	public TipoIngreso getTipoIngresoById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		TipoIngreso t = (TipoIngreso) session.load(TipoIngreso.class, new Integer(id));
		logger.info("Tipo de ingreso cargado con exito, Tipo de ingreso details="+t);
		return t;
	}

	@Override
	public void removeTipoIngreso(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		TipoIngreso t = (TipoIngreso) session.load(TipoIngreso.class, new Integer(id));
		if(null != t){
			session.delete(t);
		}
		logger.info("Tipo de ingreso borrado con exito, Tipo de ingreso details="+t);
	}

}
