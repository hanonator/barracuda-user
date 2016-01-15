package org.barracuda.login.service;

import org.barracuda.login.model.User;

/**
 * Supplies users to the 
 * 
 * @author brock
 *
 */
public interface UserService {

	/**
	 * Attempts to get the user by its primary key
	 * 
	 * @param id
	 * @return
	 */
	User get(Long id);

	/**
	 * Attempts to get the user by its username
	 * 
	 * @param id
	 * @return
	 */
	User get(String username);

}