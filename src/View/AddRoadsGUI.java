/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.AddRoadsController;
import Legacy.Legacy;
import Model.Project;
import System.Error;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class AddRoadsGUI extends GraphicUserInterface {

	private AddRoadsController addRoadsController = new AddRoadsController();
	private DefaultListModel jModelListRoads = new DefaultListModel();

	/**
	 * Creates new form CreateProjectGUI
	 */
	public AddRoadsGUI(GraphicUserInterface origin) {
		this.initComponents();
		this.creation(origin);
	}

	@Override
	public void initiation() {
		this.addRoadsController = new AddRoadsController();
		this.addRoadsController.initiation();
		this.jListVehicles.setModel(this.jModelListRoads);
	}

	@Override
	public void update() {
		this.jModelListRoads.removeAllElements();
		for (Project road : this.addRoadsController.getRoads()) {
			this.jModelListRoads.addElement(road);
		}
		this.jButtonSave.setEnabled(this.addRoadsController.hasChanges());
	}

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonSave = new javax.swing.JButton();
        jButtonClean = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jButtonLoadRoads = new javax.swing.JButton();
        jScrollPaneList = new javax.swing.JScrollPane();
        jListVehicles = new javax.swing.JList();
        jLabelWithRoads = new javax.swing.JLabel();

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

        jButtonLoadRoads.setText("Load Roads");
        jButtonLoadRoads.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoadRoadsActionPerformed(evt);
            }
        });

        ;
        jListVehicles.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item2" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPaneList.setViewportView(jListVehicles);

        jLabelWithRoads.setText("Roads:");

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
                        .addComponent(jLabelWithRoads)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonLoadRoads)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLoadRoads)
                    .addComponent(jLabelWithRoads))
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
		if (this.addRoadsController.saveProjectRoads()) {
			JOptionPane.showMessageDialog(this, "Successfully added Roads");
			this.close();
		} else {
			JOptionPane.
				showMessageDialog(this, "Could not add roads: " + Error.
								  getErrorMessage());
		}
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonLoadRoadsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoadRoadsActionPerformed
		String[] files = this.selectFiles(Legacy.
			getFiltersExtensionsImportRoadNetwork());
		if (files != null) {
			for (String file : files) {
				this.addRoadsController.loadRoads(file);
			}
		}
		this.update();
    }//GEN-LAST:event_jButtonLoadRoadsActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
		this.close();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCleanActionPerformed
		this.addRoadsController.initiation();
		this.update();
    }//GEN-LAST:event_jButtonCleanActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonClean;
    private javax.swing.JButton jButtonLoadRoads;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JLabel jLabelWithRoads;
    private javax.swing.JList jListVehicles;
    private javax.swing.JScrollPane jScrollPaneList;
    // End of variables declaration//GEN-END:variables
}
