package org.springframework.core.env;

/**
 * Environment
 * description:
 */
public interface Environment extends PropertyResolver {
	String[] getActiveProfiles();

	String[] getDefaultProfiles();

	boolean acceptsProfiles(String... profiles);
}
