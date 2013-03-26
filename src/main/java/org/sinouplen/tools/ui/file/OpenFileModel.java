/**
 * 
 */
package org.sinouplen.tools.ui.file;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;

import org.apache.log4j.Logger;

/**
 * @author Sinouplen
 * 
 */
public class OpenFileModel<R extends Object, T extends ILoadFile<R>> extends
		AbstractAction {

	private static final long serialVersionUID = -2317690157960036847L;

	private static final Logger LOGGER = Logger.getLogger(OpenFileModel.class);

	private Component component;
	private JFileChooser jFileChooser;

	private Class<R> returnClass;
	private T loadFile;
	private R returnObject;

	/**
	 * @return the returnObject
	 */
	public R getReturnObject() {
		return returnObject;
	}

	/**
	 * 
	 * @return the parent file of chooser file
	 */
	public File getParentFileChooserPath() {
		return this.jFileChooser.getSelectedFile().getParentFile();
	}

	public OpenFileModel(Class<R> returnClass, T loadFile, Component component,
			JFileChooser jFileChosser) {
		super("Open File...");
		this.component = component;
		this.jFileChooser = jFileChosser;

		this.returnClass = returnClass;
		this.loadFile = loadFile;
	}

	public void actionPerformed(ActionEvent actionEvent) {
		LOGGER.debug("OpenFileModel action performed");
		// Show the open file dialog and not return until dialog is closed
		this.jFileChooser.showOpenDialog(this.component);

		if (this.jFileChooser.getSelectedFile() != null) {
			File selectedFile = this.jFileChooser.getSelectedFile();
			if (selectedFile == null) {
				this.returnObject = null;
			} else {
				LOGGER.debug("Show load file object " + this.loadFile);
				this.returnObject = this.loadFile.Open(returnClass,
						selectedFile);
				LOGGER.debug("Show return object " + this.returnObject);
			}
		}
	}
}
