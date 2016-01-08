/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Legacy;

import javax.swing.filechooser.FileFilter;

/**
 *
 * @author LAPR3_20152016_G27
 */
public interface Export {

	String getExtension();

	String getExtensionDescription();

	FileFilter getExtensionFilter();

	String export(Object data);

}
