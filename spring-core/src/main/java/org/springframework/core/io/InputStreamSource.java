package org.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * InputStreamSource
 * description:
 */
public interface InputStreamSource {
	InputStream getInputStream() throws IOException;
}
