package org.barracuda.login.repository;

import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.barracuda.login.model.User;
import org.barracuda.login.model.User_;
import org.springframework.stereotype.Repository;

/**
 * The Repository implementation for users
 * 
 * @author brock
 *
 */
@Repository
public class UserRepository extends AbstractRepository<Long, User> {

	/**
	 * Constructor
	 */
	public UserRepository() {
		super(User.class);
	}

	/**
	 * Gets the user by its username
	 * 
	 * @param username
	 * @return
	 */
	public User forUsername(final String username) {
		Objects.requireNonNull(username, "username cannot be null");
		final EntityManager entityManager = super.getEntityManager();
		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
		criteriaQuery.where(criteriaBuilder.equal(criteriaQuery.from(User.class).get(User_.username), username));
		return (User) entityManager.createQuery(criteriaQuery).getSingleResult();
	}

}