package org.barracuda.login.service;

import java.util.Objects;

import javax.transaction.Transactional;

import org.barracuda.login.model.User;
import org.barracuda.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The default implementation for the user service
 * 
 * @author brock
 *
 */
@Service
@Transactional
public class DefaultUserService implements UserService {

	/**
	 * The user repository
	 */
    private final UserRepository repository;

    /**
     * Constructor
     * 
     * @param repository
     */
    @Autowired
    public DefaultUserService(final UserRepository repository) {
        Objects.requireNonNull(repository, "user repository cannot be null");
        this.repository = repository;
    }

	@Override
	public User get(Long id) {
		return repository.forId(id);
	}

	@Override
	public User get(String username) {
		return repository.forUsername(username);
	}

}