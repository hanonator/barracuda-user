package org.barracuda.login.model.view;

public class LoginResponse {

	/**
	 * Indicates whether the login attempt was successfull or not
	 */
	private final boolean success;
	
	/**
	 * The login status code
	 */
	private final LoginStatus status;

	public LoginResponse(LoginStatus status) {
		this.success = status == LoginStatus.OK;
		this.status = status;
	}

	public boolean isSuccess() {
		return success;
	}

	public LoginStatus getStatus() {
		return status;
	}

}
