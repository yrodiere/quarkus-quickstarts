package org.acme.hibernate.orm.fruit;

import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import io.quarkus.arc.Unremovable;
import io.quarkus.credentials.CredentialsProvider;

@ApplicationScoped
@Unremovable
@Named("fruits1cred")
public class FruitCredentialsProvider implements CredentialsProvider {
	@Override
	public Map<String, String> getCredentials(String credentialsProviderName) {
		return Map.of(USER_PROPERTY_NAME, "hibernate_orm_test_1",
				PASSWORD_PROPERTY_NAME, "hibernate_orm_test_1");
	}
}
