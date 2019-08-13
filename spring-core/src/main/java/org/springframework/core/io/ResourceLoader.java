package org.springframework.core.io;

import org.springframework.util.ResourceUtils;

/**
 * ResourceLoader
 * description:
 */
public interface ResourceLoader {

	String ClASSPATH_URL_PREFIX = ResourceUtils.CLASSPATH_URL_PREFIX;

	Resource getResource(String location);

	ClassLoader getClassLoader();
}
