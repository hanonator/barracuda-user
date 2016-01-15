package org.barracuda.login.repository;

import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Used to interact with the database
 * 
 * @author brock
 *
 * @param <P>
 * @param <E>
 */
public abstract class AbstractRepository<P, E> {

	/**
	 * The JPA entity manager
	 */
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * The type of the entity
	 */
	private final Class<E> type;

	/**
	 * Constructor
	 * 
	 * @param type
	 */
	public AbstractRepository(final Class<E> type) {
		Objects.requireNonNull(type, "entity class cannot be null");
		this.type = type;
	}

	/**
	 * Gets the entity for it primary key value
	 * 
	 * @param id
	 * @return
	 */
	public E forId(P id) {
		return this.entityManager.find(this.type, id);
	}

	protected EntityManager getEntityManager() {
		return this.entityManager;
	}

}