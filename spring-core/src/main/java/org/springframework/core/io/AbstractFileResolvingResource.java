package org.springframework.core.io;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

/**
 * AbstractFileResolvingResource
 * description:
 */
public abstract class AbstractFileResolvingResource extends AbstractResource {
	@Override
	public boolean exits() {
		try {
			URL url = getURL();
			if (ResourceUtils.isFileURL(url)) {
				return getFile().exists();
			} else {
				URLConnection con = url.openConnection();
				ResourceUtils.useCachesIfNecessary(con);
				HttpURLConnection httpCon = con instanceof HttpURLConnection ? (HttpURLConnection) con : null;

				if (httpCon != null) {
					httpCon.setRequestMethod("HEAD");
					int code = httpCon.getResponseCode();
					if (code == HttpURLConnection.HTTP_OK) {
						return true;
					} else if (code == HttpURLConnection.HTTP_NOT_FOUND) {
						return false;
					}
				}
				if (con.getContentLength() >= 0) {
					return true;
				}
				if (httpCon != null) {
					httpCon.disconnect();
					return false;
				} else {
					InputStream is = getInputStream();
					is.close();
					return true;
				}
			}
		} catch (IOException e) {
			return false;
		}
	}

	@Override
	public boolean isReadable() {
	}

	@Override
	public boolean isOpen() {
	}

	@Override
	public URI getURI() throws IOException {
	}

	@Override
	public File getFile() throws IOException {
		URL url = getURL();
		if (url.getProtocol().startsWith(ResourceUtils.URL_PROTOCOL_VFS)) {
			return VfsResourceDelegate.getResource(url).getFile();
		}
		return ResourceUtils.getFile(url, getDescription());
	}

	@Override
	public long contentLength() throws IOException {
	}

	@Override
	public long lastModified() throws IOException {
	}

	@Override
	public Resource createRelative(String relativePath) throws IOException {
	}

	@Override
	public String getFilename() {
	}

	@Override
	public String getDescription() {
	}

	@Override
	public InputStream getInputStream() throws IOException {
	}

	private static class VfsResourceDelegate {
		public static Resource getResource(URL url) throws IOException {
			return new VfsResource(VfsUtils.getRoot(url));
		}
	}
}
