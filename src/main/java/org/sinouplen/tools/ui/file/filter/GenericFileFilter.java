/**
 * 
 */
package org.sinouplen.tools.ui.file.filter;

import java.io.File;
import java.util.Collection;

import javax.swing.filechooser.FileFilter;

/**
 * Creates a file filter that accepts only directory and *.oxi files.
 * 
 * @author Sinouplen
 * @version 1.0.0
 * @since 2012-11-15
 */
public class GenericFileFilter extends FileFilter {

	private static final String EXTENSION_SEPARATOR = ".";
	private static final String DESCRIPTION_FILES_SEPARATOR = " ,";

	protected Collection<String> extensionFiles;
	private String description = "";

	/**
	 * Creates a file filter that accepts only directory and extensionFiles
	 * parameter files.
	 * 
	 */
	public GenericFileFilter(Collection<String> extensionFiles) {
		this.extensionFiles = extensionFiles;
		this.description = "";
		for (String extensionFile : extensionFiles) {
			if (!this.description.isEmpty()) {
				this.description += DESCRIPTION_FILES_SEPARATOR;
			}
			this.description += extensionFile;
		}
	}

	/**
	 * Return true the file is directory or extensionFiles parameter.
	 * 
	 * @see FileFilter#accepts
	 */
	public boolean accept(File file) {
		if (file != null) {
			if (file.isDirectory()) {
				return true;
			}

			String name = file.getName().toLowerCase();
			String fileExtension = name.substring(name
					.lastIndexOf(EXTENSION_SEPARATOR) + 1);
			return this.extensionFiles.contains(fileExtension);
		} else {
			return false;
		}
	}

	/**
	 * Returns the human readable description of this filter.
	 * 
	 * @see setDescription
	 * @see setExtensionListInDescription
	 * @see isExtensionListInDescription
	 * @see FileFilter#getDescription
	 */
	public String getDescription() {
		return this.description;
	}
}
