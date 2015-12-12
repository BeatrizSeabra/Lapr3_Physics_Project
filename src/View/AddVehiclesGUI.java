/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.AddVehiclesController;
import Model.Vehicle;
import System.Error;
import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class AddVehiclesGUI extends GraphicUserInterface {

	private AddVehiclesController addVehiclesController = new AddVehiclesController();
	private DefaultListModel jModelListVehicles = new DefaultListModel();

	/**
	 * Creates new form CreateProjectGUI
	 */
	public AddVehiclesGUI(GraphicUserInterface origin) {
		this.initComponents();
		this.creation(origin);
	}

	@Override
	public void initiation() {
		this.addVehiclesController = new AddVehiclesController();
		this.addVehiclesController.initiation();
		this.jListVehicles.setModel(this.jModelListVehicles);
	}

	@Override
	public void update() {
		this.jModelListVehicles.removeAllElements();
		for (Vehicle vehicle : this.addVehiclesController.getVehicles()) {
			this.jModelListVehicles.addElement(vehicle);
		}
	}

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonSave = new javax.swing.JButton();
        jButtonClean = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jButtonLoadVehicles = new javax.swing.JButton();
        jScrollPaneList = new javax.swing.JScrollPane();
        jListVehicles = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonSave.setText("Save");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonClean.setText("Clean");
        jButtonClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCleanActionPerformed(evt);
            }
        });

        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jButtonLoadVehicles.setText("Load Vehicles");
        jButtonLoadVehicles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoadVehiclesActionPerformed(evt);
            }
        });

        ;
        jListVehicles.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item2" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPaneList.setViewportView(jListVehicles);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPaneList)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonSave)
                        .addGap(123, 123, 123)
                        .addComponent(jButtonClean)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                        .addComponent(jButtonCancel)))
                .addGap(84, 84, 84))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonLoadVehicles)
                .addGap(267, 267, 267))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addComponent(jButtonLoadVehicles)
                .addGap(18, 18, 18)
                .addComponent(jScrollPaneList, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSave)
                    .addComponent(jButtonClean)
                    .addComponent(jButtonCancel))
                .addGap(49, 49, 49))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
		if (this.addVehiclesController.saveProjectVehicles()) {
			JOptionPane.showMessageDialog(this, "Successfully added vehicles!");
			this.close();
		} else {
			JOptionPane.
				showMessageDialog(this, "Could not add vehicles: " + Error.
								  getErrorMessage());
		}
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonLoadVehiclesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoadVehiclesActionPerformed
		JFileChooser fileChooser = new JFileChooser();
		int response = fileChooser.showOpenDialog(this);
		if (response == 0) {
			for (File file : fileChooser.getSelectedFiles()) {
				this.addVehiclesController.loadVehicles(file.getAbsolutePath());
			}
		}
		this.update();
    }//GEN-LAST:event_jButtonLoadVehiclesActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
		this.close();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCleanActionPerformed
		this.addVehiclesController.initiation();
		this.update();
    }//GEN-LAST:event_jButtonCleanActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonClean;
    private javax.swing.JButton jButtonLoadVehicles;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JList jListVehicles;
    private javax.swing.JScrollPane jScrollPaneList;
    // End of variables declaration//GEN-END:variables
}
