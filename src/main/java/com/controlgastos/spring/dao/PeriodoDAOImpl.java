package com.controlgastos.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.controlgastos.spring.model.Periodo;

@Repository
public class PeriodoDAOImpl implements PeriodoDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(PeriodoDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addPeriodo(Periodo p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Periodo guardado con éxito, Periodo Details="+p);
	}

	@Override
	public void updatePeriodo(Periodo p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Periodo actualizado con éxito, Periodo Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Periodo> listPeriodo() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Periodo> periodoList = session.createQuery("from Periodo").list();
		for(Periodo p : periodoList){
			logger.info("Periodo List::"+p);
		}
		return periodoList;
	}

	@Override
	public Periodo getPeriodoById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Periodo p = (Periodo) session.load(Periodo.class, new Integer(id));
		logger.info("Periodo cargado con exito, Periodo details="+p);
		return p;
	}

	@Override
	public void removePeriodo(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Periodo p = (Periodo) session.load(Periodo.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Periodo borrado con exito, Periodo details="+p);
	}

}
