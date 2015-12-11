/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.AddVehiclesController;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class AddVehiclesGUI extends javax.swing.JFrame {

	private AddVehiclesController controller = new AddVehiclesController();
	private DefaultListModel model = new DefaultListModel();
	private JFrame pai;

	/**
	 * Creates new form CreateProjectGUI
	 */
	public AddVehiclesGUI(JFrame pai) {
		initComponents();
		this.jList1.setModel(this.model);
		this.pai = pai;
		this.pai.setEnabled(false);
		this.controller = new AddVehiclesController();
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				jButtonCancelActionPerformed(null);
			}
		});
		this.setVisible(true);
	}

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonSave = new javax.swing.JButton();
        jButtonClean = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jButtonRoad = new javax.swing.JButton();
        jScrollPaneList = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();

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

        jButtonCancel.setText("Cancell");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jButtonRoad.setText("Road Network");
        jButtonRoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRoadActionPerformed(evt);
            }
        });

        ;
        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item2" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPaneList.setViewportView(jList1);

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                        .addComponent(jButtonCancel)))
                .addGap(84, 84, 84))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonRoad)
                .addGap(267, 267, 267))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addComponent(jButtonRoad)
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
		if (jList1.getSelectedIndex() != -1) {
			this.controller.saveProjectVehicles();
		}
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonRoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRoadActionPerformed
		JFileChooser file = new JFileChooser();
		int val = file.showOpenDialog(this);
		if (val == 0) {
			this.controller.loadVehicles(file.getName());
		}
    }//GEN-LAST:event_jButtonRoadActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
		this.pai.setEnabled(true);
		dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCleanActionPerformed
		// TODO add your handling code here:
		this.model.removeAllElements();
    }//GEN-LAST:event_jButtonCleanActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonClean;
    private javax.swing.JButton jButtonRoad;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPaneList;
    // End of variables declaration//GEN-END:variables
}
