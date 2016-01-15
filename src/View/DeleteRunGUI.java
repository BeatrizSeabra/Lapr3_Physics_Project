package View;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Controller.DeleteRunController;
import Model.Run;
import Simulation.PathAnalysis;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class DeleteRunGUI extends GraphicUserInterface {

	private DeleteRunController deleteRunController = new DeleteRunController();
	private DefaultComboBoxModel jModelComboBoxListRuns = new DefaultComboBoxModel();

	/**
	 * Creates new form CreateProjectGUI
	 *
	 * @param origin
	 * @param pathAnalysis
	 */
	public DeleteRunGUI(GraphicUserInterface origin,
						PathAnalysis pathAnalysis) {
		this.initComponents();
		this.creation(origin);
		this.deleteRunController.DeleteRunSimulation(null, null);

	}

	/**
	 *
	 */
	@Override
	public void initiation() {
		this.deleteRunController.initiation();
		this.jComboBoxListRuns.setModel(this.jModelComboBoxListRuns);

		for (Run run : this.deleteRunController.getRuns()) {
			this.jModelComboBoxListRuns.addElement(run);
		}

	}

	/**
	 *
	 */
	@Override
	public void update() {

		for (Run run : this.deleteRunController.getRuns()) {
			if (!run.equals((Run) this.jComboBoxListRuns.
				getSelectedItem())) {
				this.jComboBoxListRuns.remove(run);
			}
		}
		if (jComboBoxListRuns.getSelectedIndex() != -1) {
			jListEndNodes.setEnabled(true);
		}
		this.active(true);
	}

	/**
	 *
	 * @param state
	 * @return
	 */
	public Boolean active(Boolean state) {
		this.jButtonDeleteRuns.setEnabled(this.jComboBoxListRuns.
			getSelectedIndex() != -1);
		return state;
	}

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonCancel = new javax.swing.JButton();
        jButtonDeleteRuns = new javax.swing.JButton();
        jComboBoxListRuns = new javax.swing.JComboBox();
        jLabelWithRuns = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(280, 270));

        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jButtonDeleteRuns.setText("Delete Run");
        jButtonDeleteRuns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteRunsActionPerformed(evt);
            }
        });

        jComboBoxListRuns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxListRunsActionPerformed(evt);
            }
        });

        jLabelWithRuns.setText("List of runs:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelWithRuns, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonDeleteRuns)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                        .addComponent(jButtonCancel))
                    .addComponent(jComboBoxListRuns, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelWithRuns)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxListRuns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancel)
                    .addComponent(jButtonDeleteRuns))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDeleteRunsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteRunsActionPerformed
		if (this.deleteRunController.setRuns((Run) jComboBoxListRuns.
			getSelectedItem())       {
			List<List<String[]>> results = this.deleteRunController.analyze();
			if (results != null && !results.isEmpty()) {
				for (List<String[]> result : results) {
					new ResultsGUI(null, result);
				}
			} else {
				JOptionPane.
					showMessageDialog(this, "There is no link between selected data!");
			}
		}
    }//GEN-LAST:event_jButtonDeleteRunsActionPerformed

    private void jComboBoxListRunsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxListRunsActionPerformed
		this.update();
    }//GEN-LAST:event_jComboBoxListRunsActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
		this.close();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonDeleteRuns;
    private javax.swing.JComboBox jComboBoxListRuns;
    private javax.swing.JLabel jLabelWithRuns;
    // End of variables declaration//GEN-END:variables
}
