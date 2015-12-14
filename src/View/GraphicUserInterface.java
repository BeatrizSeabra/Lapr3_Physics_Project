/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import System.Error;
import System.Settings;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author LAPR3_20152016_G27
 */
public abstract class GraphicUserInterface extends JFrame {

	public GraphicUserInterface origin;

	public void creation(GraphicUserInterface origin) {
		if (origin != null) {
			this.origin = origin;
			this.origin.setEnabled(false);
		}
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				close();
			}
		});
		this.initiation();
		this.update();
		this.setVisible(true);
	}

	public void close() {
		if (this.origin != null) {
			this.origin.update();
			this.origin.repaint();
			this.origin.revalidate();
			this.origin.setEnabled(true);
		}
		this.dispose();
	}

	public File getFile(List<FileFilter> filters) {
		JFileChooser fileChooser = new JFileChooser(Settings.
			getOption("PathFilesFolder"));
		fileChooser.setMultiSelectionEnabled(true);
		fileChooser.setAcceptAllFileFilterUsed(false);
		if (filters != null) {
			for (FileFilter filter : filters) {
				fileChooser.addChoosableFileFilter(filter);
			}
		}
		int response = fileChooser.showOpenDialog(this);
		if (response == 0) {
			return fileChooser.getSelectedFile();
		}
		Error.setErrorMessage("None selected and chosen file!");
		return null;
	}

	public File[] getFiles(List<FileFilter> filters) {
		JFileChooser fileChooser = new JFileChooser(Settings.
			getOption("PathFilesFolder"));
		fileChooser.setMultiSelectionEnabled(true);
		fileChooser.setAcceptAllFileFilterUsed(false);
		if (filters != null) {
			for (FileFilter filter : filters) {
				fileChooser.addChoosableFileFilter(filter);
			}
		}
		int response = fileChooser.showOpenDialog(this);
		if (response == 0) {
			return fileChooser.getSelectedFiles();
		}
		Error.setErrorMessage("None selected and chosen file!");
		return null;
	}

	abstract void initiation();

	abstract void update();

}
