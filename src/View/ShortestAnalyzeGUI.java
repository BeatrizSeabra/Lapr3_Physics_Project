/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ShortestAnalyzeController;
import Legacy.Legacy;
import Model.Node;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class ShortestAnalyzeGUI extends GraphicUserInterface {

	private DefaultComboBoxModel jModelListStarts = new DefaultComboBoxModel();
	private DefaultComboBoxModel jModelListEnds = new DefaultComboBoxModel();
	private ShortestAnalyzeController shortestAnalyzeController = new ShortestAnalyzeController();

	/**
	 * Creates new form CreateProjectGUI
	 */
	public ShortestAnalyzeGUI(GraphicUserInterface origin) {
		this.initComponents();
		this.creation(origin);
	}

	@Override
	public void initiation() {
		this.shortestAnalyzeController = new ShortestAnalyzeController();
		this.shortestAnalyzeController.initiation();
		this.jComboBoxStartNode.setModel(this.jModelListStarts);
		this.jComboBoxEndNode.setModel(this.jModelListEnds);
		for (Node node : this.shortestAnalyzeController.getNodes()) {
			this.jModelListStarts.addElement(node);
		}
	}

	@Override
	public void update() {
		this.jModelListEnds.removeAllElements();
		for (Node node : this.shortestAnalyzeController.getNodes()) {
			if (!node.equals((Node) this.jComboBoxStartNode.
				getSelectedItem())) {
				this.jModelListEnds.addElement(node);
			}
		}

	}

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBoxStartNode = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxEndNode = new javax.swing.JComboBox();
        jButtonShortestNode = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Select Start Node:");

        jComboBoxStartNode.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxStartNodeItemStateChanged(evt);
            }
        });
        jComboBoxStartNode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxStartNodeActionPerformed(evt);
            }
        });

        jLabel2.setText("Select End Node:");

        jComboBoxEndNode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEndNodeActionPerformed(evt);
            }
        });

        jButtonShortestNode.setText("ShortestAnalyze");
        jButtonShortestNode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonShortestNodeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxEndNode, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxStartNode, 0, 240, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jButtonShortestNode)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxStartNode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxEndNode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jButtonShortestNode)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxStartNodeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxStartNodeItemStateChanged
		// TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxStartNodeItemStateChanged

    private void jComboBoxStartNodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxStartNodeActionPerformed
		this.update();
    }//GEN-LAST:event_jComboBoxStartNodeActionPerformed

    private void jComboBoxEndNodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEndNodeActionPerformed

    }//GEN-LAST:event_jComboBoxEndNodeActionPerformed

    private void jButtonShortestNodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonShortestNodeActionPerformed
		String filePath = this.saveFile(Legacy.
			getFiltersExtensionsExportAnalyze());
		if (this.shortestAnalyzeController.
			setNodes((Node) this.jModelListStarts.getSelectedItem(), (Node) this.jModelListEnds.
					 getSelectedItem()) && this.shortestAnalyzeController.
			save(filePath)) {
			JOptionPane.showMessageDialog(this, "Successfully!");
			this.close();
		} else {
			JOptionPane.showMessageDialog(this, "no!");
		}
    }//GEN-LAST:event_jButtonShortestNodeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonShortestNode;
    private javax.swing.JComboBox jComboBoxEndNode;
    private javax.swing.JComboBox jComboBoxStartNode;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
