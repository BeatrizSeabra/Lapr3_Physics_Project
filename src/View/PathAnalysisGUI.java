/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.PathAnalysisController;
import Model.Node;
import Simulation.PathAnalysis;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class PathAnalysisGUI extends GraphicUserInterface {

	private PathAnalysisController pathAnalysisController = new PathAnalysisController();
	private DefaultComboBoxModel jModelComboBoxStartNodes = new DefaultComboBoxModel();
	private DefaultListModel jModelListEndNodes = new DefaultListModel();

	/**
	 * Creates new form CreateProjectGUI
	 */
	public PathAnalysisGUI(GraphicUserInterface origin,
						   PathAnalysis pathAnalysis) {
		this.initComponents();
		this.creation(origin);
		this.pathAnalysisController.setPathAnalysis(pathAnalysis);
	}

	@Override
	public void initiation() {
		this.pathAnalysisController.initiation();
		this.jComboBoxStartNodes.setModel(this.jModelComboBoxStartNodes);
		this.jListEndNodes.setModel(this.jModelListEndNodes);
		for (Node node : this.pathAnalysisController.getNodes()) {
			this.jModelComboBoxStartNodes.addElement(node);
		}
	}

	@Override
	public void update() {
		this.jModelListEndNodes.removeAllElements();
		for (Node node : this.pathAnalysisController.getNodes()) {
			if (!node.equals((Node) this.jComboBoxStartNodes.
				getSelectedItem())) {
				this.jModelListEndNodes.addElement(node);
			}
		}
		if (jComboBoxStartNodes.getSelectedIndex() != -1) {
			jListEndNodes.setEnabled(true);
		}
	}

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonCancel = new javax.swing.JButton();
        jButtonClean = new javax.swing.JButton();
        jButtonAnalyze = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListEndNodes = new javax.swing.JList();
        jLabelWithEndNodes = new javax.swing.JLabel();
        jComboBoxStartNodes = new javax.swing.JComboBox();
        jLabelWithStartNodes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(280, 270));
        setPreferredSize(new java.awt.Dimension(280, 270));

        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jButtonClean.setLabel("Clean");

        jButtonAnalyze.setText("Analyze");
        jButtonAnalyze.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnalyzeActionPerformed(evt);
            }
        });

        jListEndNodes.setEnabled(false);
        jScrollPane2.setViewportView(jListEndNodes);

        jLabelWithEndNodes.setText("Select End Nodes:");

        jComboBoxStartNodes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxStartNodesActionPerformed(evt);
            }
        });

        jLabelWithStartNodes.setText("Select Start Node:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addComponent(jLabelWithStartNodes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAnalyze)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonClean)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelWithEndNodes, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jComboBoxStartNodes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelWithStartNodes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxStartNodes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelWithEndNodes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancel)
                    .addComponent(jButtonClean)
                    .addComponent(jButtonAnalyze))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAnalyzeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnalyzeActionPerformed
		if (this.pathAnalysisController.setNodes((Node) jComboBoxStartNodes.
			getSelectedItem(), (List<Node>) jListEndNodes.
												 getSelectedValuesList())) {
			for (List<String[]> result : this.pathAnalysisController.analyze()) {
				new ResultsGUI(null, result);
			}
		}
    }//GEN-LAST:event_jButtonAnalyzeActionPerformed

    private void jComboBoxStartNodesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxStartNodesActionPerformed
		this.update();
    }//GEN-LAST:event_jComboBoxStartNodesActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
		this.close();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnalyze;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonClean;
    private javax.swing.JComboBox jComboBoxStartNodes;
    private javax.swing.JLabel jLabelWithEndNodes;
    private javax.swing.JLabel jLabelWithStartNodes;
    private javax.swing.JList jListEndNodes;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}