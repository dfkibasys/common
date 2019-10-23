package de.dfki.cos.basys.common.component.manager.impl;

import java.io.File;

import org.eclipse.emf.common.util.URI;

import de.dfki.cos.basys.common.component.ComponentContext;
import de.dfki.cos.basys.common.component.FunctionalClient;
import de.dfki.cos.basys.common.component.StringConstants;

public class FileSystemClient implements FunctionalClient {

	URI uri = null;

	public FileSystemClient() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean connect(ComponentContext context, String connectionString) {
		uri = URI.createFileURI(connectionString);
		if (uri.isFile()) {
			return true;
		} else {
			uri = null;
			return false;
		}
	}

	@Override
	public boolean disconnect() {
		uri = null;
		return true;
	}

	public File getFile() {
		String fileString = uri.toFileString();
		File file = new File(fileString);
		return file;
	}

}
