package org.barracuda.login.model.view;

/**
 * Result of the login procedure. Names nicked from Graham
 * 
 * @author Red
 */
public enum LoginStatus {

	/**
	 * Exchange data login status.
	 */
	EXCHANGE_DATA,

	/**
	 * Delay for 2 seconds login status.
	 */
	DELAY,

	/**
	 * OK login status.
	 */
	OK,

	/**
	 * Invalid credentials login status.
	 */
	INVALID_CREDENTIALS,

	/**
	 * Account disabled login status.
	 */
	ACCOUNT_DISABLED,

	/**
	 * Account online login status.
	 */
	ACCOUNT_ONLINE,

	/**
	 * Game updated login status.
	 */
	GAME_UPDATED,

	/**
	 * Server full login status.
	 */
	SERVER_FULL,

	/**
	 * Login server offline login status.
	 */
	LOGIN_SERVER_OFFLINE,

	/**
	 * Too many connections login status.
	 */
	TOO_MANY_CONNECTIONS,

	/**
	 * Bad session id login status.
	 */
	BAD_SESSION_ID,

	/**
	 * Login server rejected session login status.
	 */
	LOGIN_SERVER_REJECTED_SESSION,

	/**
	 * Members account required login status.
	 */
	MEMBERS_ACCOUNT_REQUIRED,

	/**
	 * Could not complete login status.
	 */
	COULD_NOT_COMPLETE,

	/**
	 * Server updating login status.
	 */
	UPDATING,

	/**
	 * Reconnection OK login status.
	 */
	RECONNECTION_OK,

	/**
	 * Too many login attempts login status.
	 */
	TOO_MANY_LOGINS,

	/**
	 * Standing in members area on free world status.
	 */
	IN_MEMBERS_AREA;

}