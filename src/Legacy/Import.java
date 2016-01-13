/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Legacy;

import java.util.List;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author LAPR3_20152016_G27
 * @param <T>
 */
public interface Import<T> {

	/**
	 *
	 * @return
	 */
	String getExtension();

	/**
	 *
	 * @return
	 */
	String getExtensionDescription();

	/**
	 *
	 * @return
	 */
	FileFilter getExtensionFilter();

	/**
	 *
	 * @param data
	 * @return
	 */
	List<T> importData(String data);

}
