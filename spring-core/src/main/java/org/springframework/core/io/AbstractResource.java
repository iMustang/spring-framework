package org.springframework.core.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

/**
 * AbstractResource
 * description:
 */
public abstract class AbstractResource implements Resource {
	@Override
	public URL getURL() throws IOException {
		throw new FileNotFoundException(getDescription() + "cannot be resolved to URL");
	}

}
