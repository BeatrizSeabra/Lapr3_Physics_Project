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
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author LAPR3_20152016_G27
 */
public abstract class GraphicUserInterface extends JFrame {

	/**
	 *
	 */
	public GraphicUserInterface origin;

	/**
	 *
	 * @param origin
	 */
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

	/**
	 *
	 */
	public void close() {
		if (this.origin != null) {
			this.origin.update();
			this.origin.repaint();
			this.origin.revalidate();
			this.origin.setEnabled(true);
		}
		this.dispose();
	}

	/**
	 *
	 * @param filters
	 * @return
	 */
	public String saveFile(List<FileFilter> filters) {
		JFileChooser fileChooser = this.getJFileChooser(filters);
		int response = fileChooser.showSaveDialog(this);
		if (response == JFileChooser.APPROVE_OPTION) {
			String file = fileChooser.getSelectedFile().toString();
			String extension = ((FileNameExtensionFilter) fileChooser.
				getFileFilter()).getExtensions()[0];
			if (!file.endsWith(extension)) {
				StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append(file);
				stringBuilder.append(".");
				stringBuilder.append(extension);
				file = stringBuilder.toString();
			}
			return file;
		}
		Error.setErrorMessage("None selected and chosen file!");
		return null;
	}

	/**
	 *
	 * @param filters
	 * @return
	 */
	public String selectFile(List<FileFilter> filters) {
		JFileChooser fileChooser = this.getJFileChooser(filters);
		fileChooser.setMultiSelectionEnabled(false);
		int response = fileChooser.showOpenDialog(this);
		if (response == JFileChooser.APPROVE_OPTION) {
			return fileChooser.getSelectedFile().toString();
		}
		Error.setErrorMessage("None selected and chosen file!");
		return null;
	}

	/**
	 *
	 * @param filters
	 * @return
	 */
	public String[] selectFiles(List<FileFilter> filters) {
		JFileChooser fileChooser = this.getJFileChooser(filters);
		fileChooser.setMultiSelectionEnabled(true);
		int response = fileChooser.showOpenDialog(this);
		if (response == JFileChooser.APPROVE_OPTION) {
			StringBuilder stringBuilder = new StringBuilder();
			for (File file : fileChooser.getSelectedFiles()) {
				stringBuilder.append(";");
				stringBuilder.append(file.getAbsoluteFile());
			}
			return stringBuilder.toString().substring(1).split(";");
		}
		Error.setErrorMessage("None selected and chosen file!");
		return null;
	}

	private JFileChooser getJFileChooser(List<FileFilter> filters) {
		JFileChooser fileChooser = new JFileChooser(Settings.
			getOption("PathFilesFolder"));
		fileChooser.setAcceptAllFileFilterUsed(false);
		if (filters != null) {
			for (FileFilter filter : filters) {
				fileChooser.addChoosableFileFilter(filter);
			}
		}
		return fileChooser;
	}

	abstract void initiation();

	abstract void update();

}
