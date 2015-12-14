/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template fileChooser, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.CreateProjectController;
import Model.RoadNetwork;
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
public class CreateProjectGUI extends GraphicUserInterface {

	private CreateProjectController createProjectController = new CreateProjectController();
	private DefaultListModel jModelListRoadNetworks = new DefaultListModel();
	private DefaultListModel jModelListVehicles = new DefaultListModel();

	/**
	 * Creates new form CreateProjectGUI
	 */
	public CreateProjectGUI(GraphicUserInterface origin) {
		this.initComponents();
		this.creation(origin);
	}

	@Override
	public void initiation() {
		this.jListRoadNetworks.setModel(this.jModelListRoadNetworks);
		this.jListVehicles.setModel(jModelListVehicles);
		this.createProjectController = new CreateProjectController();
		this.createProjectController.initiation();
	}

	@Override
	public void update() {
		this.jModelListRoadNetworks.removeAllElements();
		for (RoadNetwork network : this.createProjectController.
			getProjectRoadNetworks()) {
			this.jModelListRoadNetworks.addElement(network);
		}
		this.jModelListVehicles.removeAllElements();
		for (Vehicle vehicle : this.createProjectController.getProjectVehicles()) {
			this.jModelListVehicles.addElement(vehicle);
		}
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonSave = new javax.swing.JButton();
        jTextFieldName = new javax.swing.JTextField();
        jTextFieldDescription = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonClean = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jButtonRoad = new javax.swing.JButton();
        jButtonVehicles = new javax.swing.JButton();
        jScrollPaneList = new javax.swing.JScrollPane();
        jListRoadNetworks = new javax.swing.JList();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListVehicles = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonSave.setText("Save");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jLabel1.setText("Name:");

        jLabel2.setText("Description:");

        jButtonClean.setText("Clean");
        jButtonClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCleanActionPerformed(evt);
            }
        });

        jButtonCancel.setText("Cancell");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jButtonRoad.setText("Load Road Networks");
        jButtonRoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRoadActionPerformed(evt);
            }
        });

        jButtonVehicles.setText("Load Vehicles");
        jButtonVehicles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVehiclesActionPerformed(evt);
            }
        });

        ;
        jScrollPaneList.setViewportView(jListRoadNetworks);

        jScrollPane1.setViewportView(jListVehicles);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonSave)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonClean)
                                .addGap(141, 141, 141)
                                .addComponent(jButtonCancel))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(42, 42, 42)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextFieldName)
                                            .addComponent(jTextFieldDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addComponent(jButtonRoad)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonVehicles)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(84, 84, 84))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPaneList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonVehicles)
                    .addComponent(jButtonRoad))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPaneList, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSave)
                    .addComponent(jButtonClean)
                    .addComponent(jButtonCancel))
                .addGap(49, 49, 49))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
		if (this.jTextFieldName.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Project needs a name!");
		} else if (this.jTextFieldDescription.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Project needs a description!");
		} else if (this.createProjectController.
			setDataProject(this.jTextFieldName.getText(), this.jTextFieldDescription.
						   getText()) && this.createProjectController.
			registProject()) {
			JOptionPane.
				showMessageDialog(this, "Creation project successfully!");
			this.close();
		} else {
			JOptionPane.
				showMessageDialog(this, "Error create project: " + Error.
								  getErrorMessage());
		}
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonRoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRoadActionPerformed
		JFileChooser fileChooser = new JFileChooser();
		int response = fileChooser.showOpenDialog(this);
		if (response == 0) {
			for (File file : fileChooser.getSelectedFiles()) {
				this.createProjectController.
					loadVehicles(file.getAbsolutePath());
			}
		}
		this.update();
    }//GEN-LAST:event_jButtonRoadActionPerformed

    private void jButtonVehiclesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVehiclesActionPerformed
		JFileChooser fileChooser = new JFileChooser();
		int response = fileChooser.showOpenDialog(this);
		if (response == 0) {
			for (File file : fileChooser.getSelectedFiles()) {
				this.createProjectController.
					loadVehicles(file.getAbsolutePath());
			}
		}
		this.update();
    }//GEN-LAST:event_jButtonVehiclesActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
		this.close();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCleanActionPerformed
		this.createProjectController.initiation();
		this.jTextFieldDescription.setText("");
		this.jTextFieldName.setText("");
		this.update();
    }//GEN-LAST:event_jButtonCleanActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonClean;
    private javax.swing.JButton jButtonRoad;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonVehicles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList jListRoadNetworks;
    private javax.swing.JList jListVehicles;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneList;
    private javax.swing.JTextField jTextFieldDescription;
    private javax.swing.JTextField jTextFieldName;
    // End of variables declaration//GEN-END:variables
}
