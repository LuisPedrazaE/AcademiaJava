package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Huesped;

@Repository
public class HuespedDAOHibernateImpl implements HuespedDAO {

	// define field for entitymanager	
	private EntityManager entityManager;
		
	// set up constructor injection
	@Autowired
	public HuespedDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	@Override
	public List<Huesped> findAll() {
		System.out.println("HuespedDAOHibernateImpl");
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<Huesped> theQuery =
				currentSession.createQuery("from Huesped", Huesped.class);
		
		// execute query and get result list
		List<Huesped> huespedes = theQuery.getResultList();
		
		// return the results		
		return huespedes;
	}


	@Override
	public Huesped findById(int theId) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// get the employee
		Huesped theHuesped =
				currentSession.get(Huesped.class, theId);
		
		// return the employee
		return theHuesped;
	}


	@Override
	public void save(Huesped theHuesped) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// save employee
		currentSession.saveOrUpdate(theHuesped);
	}


	@Override
	public void deleteById(int theId) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery(
						"delete from Huesped where id=:huespedId");
		
		theQuery.setParameter("huespedId", theId);
		
		theQuery.executeUpdate();
	}

}







