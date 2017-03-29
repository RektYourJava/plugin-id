package org.ligoj.app.plugin.id.resource;

import java.util.Collection;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.ligoj.app.iam.SimpleUser;

import lombok.Getter;
import lombok.Setter;

/**
 * User definition for edition.
 */
@Getter
@Setter
public class UserOrgEditionVo extends SimpleUser {

	/**
	 * SID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * User mail address.
	 */
	@NotNull
	@NotBlank
	@Email
	private String mail;

	/**
	 * Normalized groups aliases.
	 */
	private Collection<String> groups;

}
