package com.controlgastos.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.controlgastos.spring.model.PlantillaIngreso;

@Repository
public class PlantillaIngresoDAOImpl implements PlantillaIngresoDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(PlantillaIngresoDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	


	@Override
	public void addPlantillaIngreso(PlantillaIngreso pl) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(pl);
		logger.info("Plantilla de ingreso guardada con éxito, Plantilla de Ingreso Details="+pl);
	}

	@Override
	public void updatePlantillaIngreso(PlantillaIngreso pl) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(pl);
		logger.info("Plantilla de ingreso actualizada con éxito, Plantilla de Ingreso Details="+pl);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlantillaIngreso> listPlantillaIngreso() {
		Session session = this.sessionFactory.getCurrentSession();
		List<PlantillaIngreso> plantillaIngresoList = session.createQuery("from PlantillaIngreso").list();
		for(PlantillaIngreso pl : plantillaIngresoList){
			logger.info("Plantilla Ingreso List::"+pl);
		}
		return plantillaIngresoList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PlantillaIngreso> listDistinctPlantillaIngreso() {
		Session session = this.sessionFactory.getCurrentSession();	
		List<PlantillaIngreso> lista = session.createCriteria(PlantillaIngreso.class).setProjection(Projections.projectionList().add(Projections.distinct(Projections.property("name")))).list();	
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PlantillaIngreso> listPlantillaIngresoByName(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		List<PlantillaIngreso> plantillaIngresoList = session.createQuery("from PlantillaIngreso where name="+"'"+name+"'").list();
		for(PlantillaIngreso pl : plantillaIngresoList){
			logger.info("Plantilla Ingreso List::"+pl);
		}
		return plantillaIngresoList;
	}
	

	@Override
	public PlantillaIngreso getPlantillaIngresoById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		PlantillaIngreso pl = (PlantillaIngreso) session.load(PlantillaIngreso.class, new Integer(id));
		logger.info("Tipo de ingreso cargado con exito, Tipo de ingreso details="+pl);
		return pl;
	}

	@Override
	public void removePlantillaIngreso(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		PlantillaIngreso pl = (PlantillaIngreso) session.load(PlantillaIngreso.class, new Integer(id));
		if(null != pl){
			session.delete(pl);
		}
		logger.info("Plantilla de ingreso borrado con exito, Tipo de ingreso details="+pl);
	}

}
