/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.AddVehiclesController;
import Legacy.Legacy;
import Model.Vehicle;
import System.Error;
import javax.swing.DefaultListModel;
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
		this.jButtonSave.setEnabled(this.addVehiclesController.hasChanges());
	}

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonSave = new javax.swing.JButton();
        jButtonClean = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jButtonLoadVehicles = new javax.swing.JButton();
        jScrollPaneList = new javax.swing.JScrollPane();
        jListVehicles = new javax.swing.JList();
        jLabelWithVehicles = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(450, 250));

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

        jLabelWithVehicles.setText("Vehicles:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneList)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                        .addComponent(jButtonClean)
                        .addGap(101, 101, 101)
                        .addComponent(jButtonCancel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelWithVehicles)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonLoadVehicles)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLoadVehicles)
                    .addComponent(jLabelWithVehicles))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneList, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSave)
                    .addComponent(jButtonClean)
                    .addComponent(jButtonCancel)))
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
		String[] files = this.selectFiles(Legacy.
			getFiltersExtensionsImportVehicle());
		if (files != null) {
			for (String file : files) {
				this.addVehiclesController.loadVehicles(file);
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
    private javax.swing.JLabel jLabelWithVehicles;
    private javax.swing.JList jListVehicles;
    private javax.swing.JScrollPane jScrollPaneList;
    // End of variables declaration//GEN-END:variables
}
