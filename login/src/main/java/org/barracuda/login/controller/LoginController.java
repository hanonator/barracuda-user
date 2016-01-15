package org.barracuda.login.controller;

import org.barracuda.login.model.User;
import org.barracuda.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
public class LoginController {

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
    public LoginController(final UserService service) {
        this.service = service;

    }

    /**
     * Fetches users based on the given user id
     * 
     * @param userId
     * @return
     */
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public User getUser(@PathVariable("userId") final long userId) {
        return service.get(userId);
    }

}