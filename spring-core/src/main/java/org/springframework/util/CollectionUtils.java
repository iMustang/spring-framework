package org.springframework.util;

import java.util.Collection;

/**
 * CollectionUtils
 * description:
 */
public class CollectionUtils {
	public static boolean isEmpty(Collection collection) {
		return (collection == null || collection.isEmpty());
	}
}
