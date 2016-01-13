/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ResultsController;
import Legacy.Legacy;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class ResultsGUI extends GraphicUserInterface {

	private ResultsController resultsController = new ResultsController();

	/**
	 * Creates new form OpenProjectGUI
	 *
	 * @param origin
	 * @param result
	 */
	public ResultsGUI(GraphicUserInterface origin, List<String[]> result) {
		this.resultsController.setResults(result);
		this.initComponents();
		this.creation(origin);
	}

	/**
	 *
	 */
	@Override
	public void initiation() {
	}

	/**
	 *
	 */
	@Override
	public void update() {
		TableModel tableModel = new DefaultTableModel(this.resultsController.
			getResultsValues(), this.resultsController.getResultsLegend());
		this.jTableResults.setModel(tableModel);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		this.jTableResults.setDefaultRenderer(Object.class, centerRenderer);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelWithResults = new javax.swing.JLabel();
        jButtonExport = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableResults = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 400));
        setPreferredSize(new java.awt.Dimension(400, 400));

        jLabelWithResults.setText("Results of Analysis:");

        jButtonExport.setText("Export Results");
        jButtonExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExportActionPerformed(evt);
            }
        });

        jTableResults.setEnabled(false);
        jScrollPane2.setViewportView(jTableResults);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelWithResults, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonExport))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonExport)
                    .addComponent(jLabelWithResults))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExportActionPerformed
		String filePath = this.saveFile(Legacy.getFiltersExtensionsExport());
		if (filePath != null && !filePath.isEmpty()) {
			if (this.resultsController.export(filePath)) {
				JOptionPane.showMessageDialog(this, "Successful export!");
			} else {
				JOptionPane.showMessageDialog(this, "Could not export!");
			}
		}
    }//GEN-LAST:event_jButtonExportActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExport;
    private javax.swing.JLabel jLabelWithResults;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableResults;
    // End of variables declaration//GEN-END:variables
}
