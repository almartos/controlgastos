package com.controlgastos.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.controlgastos.spring.model.Gasto;

@Repository
public class GastoDAOImpl implements GastoDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(GastoDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addGasto(Gasto g) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(g);
		logger.info("Gasto guardado con éxito, Gasto Details="+g);
	}

	@Override
	public void updateGasto(Gasto g) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(g);
		logger.info("Gasto actualizado con éxito, Gasto Details="+g);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Gasto> listGasto() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Gasto> gastoList = session.createQuery("from Gasto").list();
		for(Gasto g : gastoList){
			logger.info("Gasto List::"+g);
		}
		return gastoList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Gasto> listGastoByIdGasGlobal(int id){
		Session session = this.sessionFactory.getCurrentSession();
		List<Gasto> gastoList = session.createQuery("from Gasto where idGastoGlobal="+id).list();
		for(Gasto g : gastoList){
			logger.info("Gasto List::"+g);
		}
		return gastoList;
	}

	@Override
	public Gasto getGastoById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Gasto g = (Gasto) session.load(Gasto.class, new Integer(id));
		logger.info("Gasto cargado con exito, Gasto details="+g);
		return g;
	}

	@Override
	public void removeGasto(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Gasto g = (Gasto) session.load(Gasto.class, new Integer(id));
		if(null != g){
			session.delete(g);
		}
		logger.info("Gasto borrado con exito, Gasto details="+g);
	}

}
