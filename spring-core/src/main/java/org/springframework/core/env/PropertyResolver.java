package org.springframework.core.env;

/**
 * PropertyResolver
 * description:
 */
public interface PropertyResolver {
	boolean containsProperty(String key);

	String getProperty(String key);

	String getProperty(String key, String defaultValue);

	<T> T getProperty(String key, Class<T> targetType);

	<T> T getProperty(String key, Class<T> targetType, T defaultValue);

	<T> Class<T> getPropertyAsClass(String key, Class<T> targetType);

	String getRequiredProperty(String key) throws IllegalStateException;

	String resolvePlaceholders(String text);

	String resolveRequiredPlaceholders(String text) throws IllegalArgumentException;
}
