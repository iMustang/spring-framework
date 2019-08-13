package org.springframework.beans.factory.xml;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * XmlBeanFactory
 * description:
 */
public class XmlBeanFactory extends DefaultListableBeanFactory {
	private final XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(this);
}
