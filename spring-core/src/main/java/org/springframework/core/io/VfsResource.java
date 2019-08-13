package org.springframework.core.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

/**
 * VfsResource
 * description:
 */
public class VfsResource extends AbstractResource {
	@Override
	public boolean exits() {
		return false;
	}

	@Override
	public boolean isReadable() {
		return false;
	}

	@Override
	public boolean isOpen() {
		return false;
	}

	@Override
	public URI getURI() throws IOException {
		return null;
	}

	@Override
	public File getFile() throws IOException {
		return null;
	}

	@Override
	public long contentLength() throws IOException {
		return 0;
	}

	@Override
	public long lastModified() throws IOException {
		return 0;
	}

	@Override
	public Resource createRelative(String relativePath) throws IOException {
		return null;
	}

	@Override
	public String getFilename() {
		return null;
	}

	@Override
	public String getDescription() {
		return null;
	}

	@Override
	public InputStream getInputStream() throws IOException {
		return null;
	}
}
