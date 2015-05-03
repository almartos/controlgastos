package com.controlgastos.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.controlgastos.spring.model.Ingreso;

@Repository
public class IngresoDAOImpl implements IngresoDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(IngresoDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addIngreso(Ingreso i) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(i);
		logger.info("Ingreso guardado con éxito, Ingreso Details="+i);
	}

	@Override
	public void updateIngreso(Ingreso i) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(i);
		logger.info("Ingreso actualizado con éxito, Ingreso Global Details="+i);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ingreso> listIngreso() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Ingreso> ingresoList = session.createQuery("from Ingreso").list();
		for(Ingreso i : ingresoList){
			logger.info("Ingreso List::"+i);
		}
		return ingresoList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Ingreso> listIngresoByIdIngGlobal(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Ingreso> ingresoList = session.createQuery("from Ingreso where idIngresoGlobal="+id).list();
		for(Ingreso i : ingresoList){
			logger.info("Ingreso List::"+i);
		}
		return ingresoList;
	}

	@Override
	public Ingreso getIngresoById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Ingreso i = (Ingreso) session.load(Ingreso.class, new Integer(id));
		logger.info("Ingreso cargado con exito, Tipo de ingreso details="+i);
		return i;
	}

	@Override
	public void removeIngreso(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Ingreso i = (Ingreso) session.load(Ingreso.class, new Integer(id));
		if(null != i){
			session.delete(i);
		}
		logger.info("Ingreso borrado con exito, Ingreso details="+i);
	}

}
