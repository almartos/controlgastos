package com.controlgastos.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.controlgastos.spring.model.PlantillaGasto;
import com.controlgastos.spring.model.PlantillaIngreso;

@Repository
public class PlantillaGastoDAOImpl implements PlantillaGastoDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(PlantillaGastoDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addPlantillaGasto(PlantillaGasto pl) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(pl);
		logger.info("Plantilla de gasto guardada con éxito, Plantilla de Gasto Details="+pl);
	}

	@Override
	public void updatePlantillaGasto(PlantillaGasto pl) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(pl);
		logger.info("Plantilla de gasto actualizada con éxito, Plantilla de Gasto Details="+pl);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlantillaGasto> listPlantillaGasto() {
		Session session = this.sessionFactory.getCurrentSession();
		List<PlantillaGasto> plantillaGastoList = session.createQuery("from PlantillaGasto").list();
		for(PlantillaGasto pl : plantillaGastoList){
			logger.info("Plantilla Gasto List::"+pl);
		}
		return plantillaGastoList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PlantillaGasto> listDistinctPlantillaGasto() {
		Session session = this.sessionFactory.getCurrentSession();	
		List<PlantillaGasto> lista = session.createCriteria(PlantillaGasto.class).setProjection(Projections.projectionList().add(Projections.distinct(Projections.property("name")))).list();	
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PlantillaGasto> listPlantillaGastoByName(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		List<PlantillaGasto> plantillaGastoList = session.createQuery("from PlantillaGasto where name="+"'"+name+"'").list();
		for(PlantillaGasto pl : plantillaGastoList){
			logger.info("Plantilla Ingreso List::"+pl);
		}
		return plantillaGastoList;
	}

	@Override
	public PlantillaGasto getPlantillaGastoById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		PlantillaGasto pl = (PlantillaGasto) session.load(PlantillaGasto.class, new Integer(id));
		logger.info("Tipo de gasto cargado con exito, Tipo de gasto details="+pl);
		return pl;
	}

	@Override
	public void removePlantillaGasto(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		PlantillaGasto pl = (PlantillaGasto) session.load(PlantillaGasto.class, new Integer(id));
		if(null != pl){
			session.delete(pl);
		}
		logger.info("Plantilla de gasto borrado con exito, Tipo de gasto details="+pl);
	}

}
