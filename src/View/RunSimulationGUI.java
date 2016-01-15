/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template fileChooser, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.CreateSimulationController;
import Legacy.Legacy;
import System.Error;
import javax.swing.JOptionPane;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class RunSimulationGUI extends GraphicUserInterface {

	private CreateSimulationController createSimulationController = new CreateSimulationController();

	/**
	 * Creates new form CreateProjectGUI
	 *
	 * @param origin
	 */
	public RunSimulationGUI(GraphicUserInterface origin) {
		this.initComponents();
		this.creation(origin);
	}

	/**
	 *
	 */
	@Override
	public void initiation() {
		this.createSimulationController = new CreateSimulationController();
		this.createSimulationController.initiation();
	}

	/**
	 *
	 */
	@Override
	public void update() {
		if (this.active(this.createSimulationController.hasSimulation())) {
			if (this.jTextFieldName.getText().isEmpty()) {
				this.jTextFieldName.setText(this.createSimulationController.
					getName());
			}
			if (this.jTextFieldDescription.getText().isEmpty()) {
				this.jTextFieldDescription.
					setText(this.createSimulationController.
						getDescription());
			}
			this.jTextAreaSimulations.setText(this.createSimulationController.
				getToString());
		} else {
			this.jTextFieldName.setText("");
			this.jTextFieldDescription.setText("");
			this.jTextAreaSimulations.setText("");
		}
	}

	/**
	 *
	 * @param state
	 * @return
	 */
	public Boolean active(Boolean state) {
		this.jTextFieldName.setEnabled(state);
		this.jTextFieldDescription.setEnabled(state);
		this.jButtonSave.setEnabled(state);
		return state;
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaSimulations = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 500));

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

        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jButtonRoad.setText("Load Simulation");
        jButtonRoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRoadActionPerformed(evt);
            }
        });

        jTextAreaSimulations.setEditable(false);
        jTextAreaSimulations.setColumns(20);
        jTextAreaSimulations.setLineWrap(true);
        jTextAreaSimulations.setRows(5);
        jScrollPane2.setViewportView(jTextAreaSimulations);

        jLabel4.setText("Simulations:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonClean)
                        .addGap(72, 72, 72)
                        .addComponent(jButtonCancel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldDescription))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldName))
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
                        .addComponent(jButtonRoad)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonRoad)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonClean)
                    .addComponent(jButtonCancel)
                    .addComponent(jButtonSave))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
		if (this.jTextFieldName.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Simulation needs a name!");
		} else if (this.jTextFieldDescription.getText().isEmpty()) {
			JOptionPane.
				showMessageDialog(this, "Simulation needs a description!");
		} else if (this.createSimulationController.
			saveSimulation(this.jTextFieldName.
				getText(), this.jTextFieldDescription.getText())) {
			JOptionPane.
				showMessageDialog(this, "Creation simulation successfully!");
			this.close();
		} else {
			JOptionPane.
				showMessageDialog(this, "Error create simulation: " + Error.
								  getErrorMessage());
		}
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonRoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRoadActionPerformed
		String file = this.selectFile(Legacy.
			getFiltersExtensionsImportSimulations());
		if (file != null) {
			this.createSimulationController.loadSimulation(file);
		}
		this.update();
    }//GEN-LAST:event_jButtonRoadActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
		this.close();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCleanActionPerformed
		this.createSimulationController.initiation();
		this.update();
    }//GEN-LAST:event_jButtonCleanActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonClean;
    private javax.swing.JButton jButtonRoad;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaSimulations;
    private javax.swing.JTextField jTextFieldDescription;
    private javax.swing.JTextField jTextFieldName;
    // End of variables declaration//GEN-END:variables
}