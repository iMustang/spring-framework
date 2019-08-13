package org.springframework.core.io.support;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.Assert;
import org.springframework.util.PathMatcher;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/**
 * PathMatchingResourcePatternResolver
 * description:
 */
public class PathMatchingResourcePatternResolver implements ResourcePatternResolver {

	@Override
	public Resource[] getResources(String locationPattern) throws IOException {
		Assert.notNull(locationPattern, "Location pattern must not be null");
		if (locationPattern.startsWith(CLASSPATH_ALL_URL_PREFIX)) {
			if (getPathMatcher().isPattern(locationPattern.substring(CLASSPATH_ALL_URL_PREFIX.length()))) {
				return findPathMatchingResources(locationPattern);
			} else {
				return findAllClassPathResources(locationPattern.substring(CLASSPATH_ALL_URL_PREFIX.length()));
			}
		} else {
			int prefixEnd = locationPattern.indexOf(":") + 1;
			if (getPathMatcher().isPattern(locationPattern.substring(prefixEnd))) {
				return findPathMatchingResources(locationPattern);
			} else {
				return new Resource[]{getResourceLoader().getResource(locationPattern)};
			}
		}
	}

	@Override
	public Resource getResource(String location) {
	}

	@Override
	public ClassLoader getClassLoader() {
	}

	public PathMatcher getPathMatcher() {
		return this.pathMatcher;
	}

	protected Resource[] findPathMatchingResources(String locationPattern) throws IOException {
		determineRootDir(locationPattern);
	}

	protected String determineRootDir(String location) {
		int prefixEnd = location.indexOf(":") + 1;
		int rootDirEnd = location.length();
		while (rootDirEnd > prefixEnd && getPathMatcher().isPattern(location.substring(prefixEnd, rootDirEnd))) {
			rootDirEnd = location.lastIndexOf('/', rootDirEnd - 2) + 1;
		}
		if (rootDirEnd == 0) {
			rootDirEnd = prefixEnd;
		}
		return location.substring(0, rootDirEnd);
	}

	protected Resource[] findAllClassPathResources(String location) throws IOException {
		String path = location;
		if (path.startsWith("/")) {
			path = path.substring(1);
		}
		Enumeration<URL> resourcesUrls = getClassLoader().getResources(path);
		LinkedHashSet<Resource> result = new LinkedHashSet<>(16);
		while (resourcesUrls.hasMoreElements()) {
			URL url = resourcesUrls.nextElement();
			result.add(convertClassLoaderURL(url));
		}
		return result.toArray(new Resource[result.size()]);
	}

	protected Resource convertClassLoaderURL(URL url) {
		return new UrlResource(url);
	}

	private PathMatcher pathMatcher = new AntPathMatcher();
}
