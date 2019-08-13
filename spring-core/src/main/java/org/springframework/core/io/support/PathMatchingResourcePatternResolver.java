package org.springframework.core.io.support;

import org.springframework.core.io.Resource;
import org.springframework.util.Assert;

import java.io.IOException;

/**
 * PathMatchingResourcePatternResolver
 * description:
 */
public class PathMatchingResourcePatternResolver implements ResourcePatternResolver {
	@Override
	public Resource[] getResources(String locationPattern) throws IOException {
		Assert.notNull(locationPattern, "Location pattern must not be null");
		if (locationPattern.startsWith(CLASSPATH_ALL_URL_PREFIX)) {
			if(getPathMatcher())
		}
	}

	@Override
	public Resource getResource(String location) {
	}

	@Override
	public ClassLoader getClassLoader() {
	}
}
