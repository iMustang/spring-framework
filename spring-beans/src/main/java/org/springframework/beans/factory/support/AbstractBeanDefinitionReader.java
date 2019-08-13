package org.springframework.beans.factory.support;

import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.util.Assert;

/**
 * AbstractBeanDefinitionReader
 * description:
 */
public class AbstractBeanDefinitionReader {
	private final BeanDefinitionRegistry registry;

	private ResourceLoader resourceLoader;

	public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
		Assert.notNull(registry, "BeanDefinitionRegistry must not be null");
		this.registry = registry;

		if (this.registry instanceof ResourceLoader) {
			this.resourceLoader = (ResourceLoader) this.registry;
		} else {
			this.resourceLoader = new PathMatchingResourcePatternResolver();
		}
	}
}
