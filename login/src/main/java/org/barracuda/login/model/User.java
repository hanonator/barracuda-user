package org.barracuda.login.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(name = "un_username", columnNames = "username"),
		@UniqueConstraint(name = "un_displayname", columnNames = "displayname")})
public class User implements Serializable {
	
	/**
	 * Used for serializing the object
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The user's uid
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	/**
	 * The name the user uses to log in to the server
	 */
	@Column(name = "username", length = 12, unique = true)
	private String username;

	/**
	 * The name the user uses in game
	 */
	@Column(name = "displayname", length = 12, unique = true)
	private String displayname;

	/**
	 * The password. This is saved as an MD5 hash
	 */
	@Column(name = "password", length = 50)
	private String password;

	/**
	 * The password. This is saved as an MD5 hash
	 */
	@Column(name = "disabled", length = 50)
	private Boolean disabled;

	/**
	 * Constructor
	 */
	public User() {
		this(null, null, null);
	}

	/**
	 * Constructor
	 * 
	 * @param username
	 * @param displayname
	 * @param password
	 */
	public User(String username, String displayname, String password) {
		this.username = username;
		this.displayname = displayname;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDisplayname() {
		return displayname;
	}

	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	@Override
	public boolean equals(final Object otherObject) {
		if (!(otherObject instanceof User)) {
			return false;
		}
		User otherUser = (User) otherObject;
		return Objects.equals(id, otherUser.id) && Objects.equals(username, otherUser.username);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, username);
	}

}
