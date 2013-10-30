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
public class OpenFileModel extends AbstractAction {

	private static final long serialVersionUID = -2317690157960036847L;

	private static final Logger LOGGER = Logger.getLogger(OpenFileModel.class);

	private Component component;
	private JFileChooser jFileChooser;

	private File returnFile;

	/**
	 * @return the returnObject
	 */
	public File getReturnFile() {
		return returnFile;
	}

	/**
	 * 
	 * @return the parent file of chooser file
	 */
	public File getParentFileChooserPath() {
		return this.jFileChooser.getSelectedFile().getParentFile();
	}

	public OpenFileModel(Component component, JFileChooser jFileChosser) {
		super("Open File...");
		this.component = component;
		this.jFileChooser = jFileChosser;
	}

	public void actionPerformed(ActionEvent actionEvent) {
		LOGGER.debug("OpenFileModel action performed");
		// Show the open file dialog and not return until dialog is closed
		this.jFileChooser.showOpenDialog(this.component);

		if (this.jFileChooser.getSelectedFile() != null) {
			this.returnFile = this.jFileChooser.getSelectedFile();
		}
	}
}
