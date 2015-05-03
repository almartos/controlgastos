package com.controlgastos.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.controlgastos.spring.model.HistoricoGasto;
import com.controlgastos.spring.model.HistoricoIngreso;

@Repository
public class HistoricoIngresoDAOImpl implements HistoricoIngresoDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(HistoricoIngresoDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addHistoricoIngreso(HistoricoIngreso hi) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(hi);
		logger.info("Historico Ingreso guardado con éxito, Historico Ingreso Details="+hi);
	}

	@Override
	public void updateHistoricoIngreso(HistoricoIngreso hi) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(hi);
		logger.info("Historico Ingreso actualizado con éxito, Historico Ingreso Details="+hi);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistoricoIngreso> listHistoricoIngreso() {
		Session session = this.sessionFactory.getCurrentSession();
		List<HistoricoIngreso> historicoIngresoList = session.createQuery("from IngresoGasto").list();
		for(HistoricoIngreso hi : historicoIngresoList){
			logger.info("Historico Ingreso List:"+hi);
		}
		return historicoIngresoList;
	}

	@Override
	public HistoricoIngreso getHistoricoIngresoById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		HistoricoIngreso hi = (HistoricoIngreso) session.load(HistoricoIngreso.class, new Integer(id));
		logger.info("Historico Ingreso cargado con exito, Historico Ingreso details="+hi);
		return hi;
	}

	@Override
	public void removeHistoricoIngreso(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		HistoricoIngreso hi = (HistoricoIngreso) session.load(HistoricoIngreso.class, new Integer(id));
		if(null != hi){
			session.delete(hi);
		}
		logger.info("Historico Ingreso borrado con exito, Historico Ingreso details="+hi);
	}
	
	@Override
	public List<HistoricoIngreso> listHistoricoIngresoPorIdIngreso(int id){
		Session session = this.sessionFactory.getCurrentSession();
		List<HistoricoIngreso> historicoIngresoList = session.createQuery("from HistoricoIngreso where idIngreso="+id).list();
		for(HistoricoIngreso hi: historicoIngresoList){
			logger.info("Historico Ingreso por Id Ingreso::"+hi);
		}
		return historicoIngresoList;
	}

}
