package org.barracuda.login.controller;

import javax.persistence.NoResultException;

import org.barracuda.login.model.User;
import org.barracuda.login.model.view.LoginRequest;
import org.barracuda.login.model.view.LoginResponse;
import org.barracuda.login.model.view.LoginStatus;
import org.barracuda.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author brock
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

	/**
	 * The user service for this controller
	 */
	private final UserService service;

	/**
	 * Constructor
	 * 
	 * @param service
	 */
	@Autowired
	public UserController(final UserService service) {
		this.service = service;
	}

	/**
	 * Fetches users based on the given user id
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public LoginResponse validate(@RequestBody final LoginRequest request) {
		try {
			User user = service.get(request.getUsername());
			if (!user.getPassword().equals(request.getPassword())) {
				return new LoginResponse(LoginStatus.INVALID_CREDENTIALS);
			}
			else if (Boolean.TRUE.equals(user.getDisabled())) {
				return new LoginResponse(LoginStatus.ACCOUNT_DISABLED);
			}
		} catch (EmptyResultDataAccessException | NoResultException ex) {
			return new LoginResponse(LoginStatus.INVALID_CREDENTIALS);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new LoginResponse(LoginStatus.LOGIN_SERVER_REJECTED_SESSION);
		}
		return new LoginResponse(LoginStatus.OK);
	}

	/**
	 * Fetches users based on the given user id
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public void register(@RequestBody final User user) {
		
	}

}