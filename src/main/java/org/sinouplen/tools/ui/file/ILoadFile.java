/**
 * 
 */
package org.sinouplen.tools.ui.file;

import java.io.File;

/**
 * @author Sinouplen
 * 
 */
public interface ILoadFile<T extends Object> {

	public T Open(Class<T> returnClass, File openingFile);

}
