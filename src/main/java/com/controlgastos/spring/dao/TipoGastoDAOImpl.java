package com.controlgastos.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.controlgastos.spring.model.TipoGasto;

@Repository
public class TipoGastoDAOImpl implements TipoGastoDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(TipoGastoDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addTipoGasto(TipoGasto t) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(t);
		logger.info("Tipo de gasto guardado con éxito, Tipo de Ingreso Details="+t);
	}

	@Override
	public void updateTipoGasto(TipoGasto t) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(t);
		logger.info("Tipo de gasto actualizado con éxito, Tipo de gasto Details="+t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoGasto> listTipoGasto() {
		Session session = this.sessionFactory.getCurrentSession();
		List<TipoGasto> tipoGastoList = session.createQuery("from TipoGasto").list();
		for(TipoGasto t : tipoGastoList){
			logger.info("Tipo Gasto List::"+t);
		}
		return tipoGastoList;
	}

	@Override
	public TipoGasto getTipoGastoById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		TipoGasto t = (TipoGasto) session.load(TipoGasto.class, new Integer(id));
		logger.info("Tipo de gasto cargado con exito, Tipo de ingreso details="+t);
		return t;
	}

	@Override
	public void removeTipoGasto(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		TipoGasto t = (TipoGasto) session.load(TipoGasto.class, new Integer(id));
		if(null != t){
			session.delete(t);
		}
		logger.info("Tipo de gasto borrado con exito, Tipo de gasto details="+t);
	}

}
