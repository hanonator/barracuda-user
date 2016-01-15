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
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 12, unique = true)
	private String username;

	@Column(length = 12, unique = true)
	private String displayname;

	@Column(length = 50)
	private String password;

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
