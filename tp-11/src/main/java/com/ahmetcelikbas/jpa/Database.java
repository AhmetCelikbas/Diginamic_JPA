package com.ahmetcelikbas.jpa;

import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import javax.persistence.TransactionRequiredException;
import javax.persistence.TypedQuery;

/**
 * @author keylan
 * JPA MySQL
 */
public class Database {

	/* 
	 * Arguments
	 */
	/**
	 * EntityManagerFactory entityManagerFactory
	 */
	private static EntityManagerFactory entityManagerFactory;
	/**
	 * EntityManager entityManager
	 */
	private static EntityManager entityManager;
	
	/* 
	 * Methodes 
	 */
	/**
	 * @throws IllegalStateException
	 * Créé une entité de persistance avec l'unité de persistance "JSP_TP11"
	 */
	private static void createEntity() throws IllegalStateException {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("JSP_TP11");
			entityManager = entityManagerFactory.createEntityManager();
		} catch (IllegalStateException e) {
			throw e;
		}
	}
	
	/**
	 * @throws IllegalStateException
	 * Ferme et détruit l'entité de persistance
	 */
	private static void destroyEntity() throws IllegalStateException {
		try {
			entityManager.close();
			entityManager = null;
		} catch (IllegalStateException e) {
			throw e;
		}
		
	}
	
	/**
	 * @return EntityManager
	 * @throws IllegalStateException
	 */
	public static EntityManager getEntity() throws IllegalStateException {
		try {
			if(entityManager == null) {
				createEntity();
			}
			return entityManager;
		} catch (IllegalStateException e) {
			throw e;
		}

	}
	
	/**
	 * @param queryString
	 * @param model
	 * @return List<T>
	 * @throws IllegalStateException
	 * @throws IllegalArgumentException
	 * Créé une requete et retourne les résultats de la requête sous forme de liste (générique)
	 */
	public static <T> List<T> query(String queryString, Class<T> model) throws 	IllegalStateException, 
																				IllegalArgumentException {
		try {
			if(entityManager == null) {
				createEntity();
			}
			TypedQuery<T> query = entityManager.createQuery(queryString, model); 
			return query.getResultList();
		} catch (IllegalStateException e) {
			throw e;
		} catch (IllegalArgumentException e) {
			throw e;
		}
	}
	
	/**
	 * @param model
	 * @param id
	 * @return T
	 * @throws IllegalStateException
	 * @throws IllegalArgumentException
	 * Trouve l'entité de la classe spécifiée en argument 'model' correspondant à la clé primaire spécifiée en argument 'id'
	 */
	public static <T> T find(Class<T> model, int id) throws 	IllegalStateException, 
															IllegalArgumentException {		
		try {
			if(entityManager == null) {
				createEntity();
			}
			return entityManager.find(model, id);
		} catch (IllegalStateException e) {
			throw e;
		} catch (IllegalArgumentException e) {
			throw e;
		}
	}
	
	/**
	 * @param obj
	 * @throws IllegalStateException
	 * @throws IllegalArgumentException
	 * @throws EntityExistsException
	 * @throws TransactionRequiredException
	 * @throws RollbackException
	 * @throws PersistenceException
	 * Ajoute dans la base de données l'entité fournie en argument 'Obj'
	 */
	public static void presist(Object obj) throws 	IllegalStateException, 
													IllegalArgumentException,
													EntityExistsException,
													TransactionRequiredException,
													RollbackException,
													PersistenceException {
		try {
			if(entityManager == null) {
				createEntity();
			}
			entityManager.getTransaction().begin();
			entityManager.persist(obj);
			entityManager.flush();
			entityManager.getTransaction().commit();
			destroyEntity();
		} catch (IllegalStateException e) {
			throw e;
		} catch (IllegalArgumentException e) {
			throw e;
		} catch (EntityExistsException e) {
			throw e;
		} catch (TransactionRequiredException e) {
			throw e;
		} catch (RollbackException e) {
			throw e;
		} catch (PersistenceException e) {
			throw e;
		}
	}
		
	/**
	 * @param obj
	 * @throws IllegalStateException
	 * @throws IllegalArgumentException
	 * @throws EntityExistsException
	 * @throws TransactionRequiredException
	 * @throws RollbackException
	 * @throws PersistenceException
	 * Supprime de la base de données l'entité fournie en argument 'Obj'
	 */
	public static void remove(Object obj) throws 	IllegalStateException, 
													IllegalArgumentException,
													EntityExistsException,
													TransactionRequiredException,
													RollbackException,
													PersistenceException {
		try {
			if(entityManager == null) {
				createEntity();
			}
			entityManager.getTransaction().begin();
			entityManager.refresh(obj); // mise à jour du cache JPA avant de supprimer.
			entityManager.remove(obj);
			entityManager.getTransaction().commit();
			destroyEntity();
		} catch (IllegalStateException e) {
			throw e;
		} catch (IllegalArgumentException e) {
			throw e;
		} catch (EntityExistsException e) {
			throw e;
		} catch (TransactionRequiredException e) {
			throw e;
		} catch (RollbackException e) {
			throw e;
		} catch (PersistenceException e) {
			throw e;
		}
	}
	
}
