package com.controlgastos.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.controlgastos.spring.model.HistoricoGasto;

@Repository
public class HistoricoGastoDAOImpl implements HistoricoGastoDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(HistoricoGastoDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addHistoricoGasto(HistoricoGasto hg) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(hg);
		logger.info("Historico Gasto guardado con éxito, Historico Gasto Details="+hg);
	}

	@Override
	public void updateHistoricoGasto(HistoricoGasto hg) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(hg);
		logger.info("Historico Gasto actualizado con éxito, Historico Gasto Details="+hg);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistoricoGasto> listHistoricoGasto() {
		Session session = this.sessionFactory.getCurrentSession();
		List<HistoricoGasto> historicoGastoList = session.createQuery("from HistoricoGasto").list();
		for(HistoricoGasto hg : historicoGastoList){
			logger.info("Historico Gasto List::"+hg);
		}
		return historicoGastoList;
	}

	@Override
	public HistoricoGasto getHistoricoGastoById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		HistoricoGasto hg = (HistoricoGasto) session.load(HistoricoGasto.class, new Integer(id));
		logger.info("Historico Gasto cargado con exito, Historico Gasto details="+hg);
		return hg;
	}

	@Override
	public void removeHistoricoGasto(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		HistoricoGasto hg = (HistoricoGasto) session.load(HistoricoGasto.class, new Integer(id));
		if(null != hg){
			session.delete(hg);
		}
		logger.info("Historico Gasto borrado con exito, Gasto details="+hg);
	}
	
	@Override
	public List<HistoricoGasto> listHistoricoGastoPorIdGasto(int id){
		Session session = this.sessionFactory.getCurrentSession();
		List<HistoricoGasto> historicoGastoList = session.createQuery("from HistoricoGasto where idGasto="+id).list();
		for(HistoricoGasto hg: historicoGastoList){
			logger.info("Historico Gasto por Id Gasto::"+hg);
		}
		return historicoGastoList;
	}

}
