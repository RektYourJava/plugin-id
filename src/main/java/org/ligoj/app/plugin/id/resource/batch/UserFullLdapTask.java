package org.ligoj.app.plugin.id.resource.batch;

import org.ligoj.app.plugin.id.resource.UserOrgEditionVo;
import org.ligoj.app.plugin.id.resource.UserOrgResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//http://docs.spring.io/spring/docs/3.2.x/spring-framework-reference/html/scheduling.html
/**
 * LDAP import from list of bean entries.
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UserFullLdapTask extends AbstractLdapBatchTask<UserImportEntry> {

	@Autowired
	protected UserOrgResource resource;

	@Override
	protected void doBatch(final UserImportEntry entry) {

		// Copy the user information
		final UserOrgEditionVo user = new UserOrgEditionVo();
		user.setCompany(entry.getCompany());
		user.setFirstName(entry.getFirstName());
		user.setLastName(entry.getLastName());
		user.setId(entry.getId());
		user.setMail(entry.getMail());

		// Copy groups
		user.setGroups(toList(entry.getGroups()));

		// Create the user
		resource.create(user);
	}

}