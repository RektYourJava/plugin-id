/*
 * Licensed under MIT (https://github.com/ligoj/ligoj/blob/master/LICENSE)
 */
package org.ligoj.app.plugin.id.resource;

import org.ligoj.app.api.ServicePlugin;
import org.springframework.security.core.Authentication;

/**
 * Features of identity (authentication) implementations. The Identity and Access Management is covered by IAM features,
 * not this one.
 */
public interface IdentityServicePlugin extends ServicePlugin {

	/**
	 * Indicates this provider accept the authentication to be queried.
	 * 
	 * @param authentication
	 *            The authentication to accept.
	 * @param node
	 *            The node parameters.
	 * @return <code>true</code> When this provider can perform authentication for this authentication token.
	 */
	boolean accept(Authentication authentication, String node);

	/**
	 * Authenticate the given token.
	 * 
	 * @param authentication
	 *            The current authentication to check.
	 * @param node
	 *            The node to use for this authentication.
	 * @param primary
	 *            When <code>true</code> This is a primary authentication provider. No user details mapping is expected.
	 * @return The validated authentication. May not be the original parameter. Never <code>null</code>.
	 */
	Authentication authenticate(Authentication authentication, String node, boolean primary);
}
