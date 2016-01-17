package View;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Controller.ViewRunController;
import Model.Drop;
import Model.Run;
import Model.Step;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class ViewRunGUI extends GraphicUserInterface {

	private ViewRunController viewRunController = new ViewRunController();
	private DefaultListModel jModelListRuns = new DefaultListModel();

	/**
	 * Creates new form CreateProjectGUI
	 *
	 * @param origin
	 * @param pathAnalysis
	 */
	public ViewRunGUI(GraphicUserInterface origin) {
		this.initComponents();
		this.creation(origin);
	}

	/**
	 *
	 */
	@Override
	public void initiation() {
		this.viewRunController.initiation();
		this.jListRuns.setModel(this.jModelListRuns);
	}

	/**
	 *
	 */
	@Override
	public void update() {
		this.jModelListRuns.removeAllElements();
		List<Run> runs = this.viewRunController.getRuns();
		if (runs != null && !runs.isEmpty()) {
			for (Run run : runs) {
				this.jModelListRuns.addElement(run);
			}
		}
	}

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonCancel = new javax.swing.JButton();
        jButtonView = new javax.swing.JButton();
        jLabelWithRuns = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListRuns = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(280, 270));

        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jButtonView.setText("View");
        jButtonView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonViewActionPerformed(evt);
            }
        });

        jLabelWithRuns.setText("List of runs:");

        jScrollPane1.setViewportView(jListRuns);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addComponent(jLabelWithRuns, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonView)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCancel))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelWithRuns)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancel)
                    .addComponent(jButtonView))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonViewActionPerformed
		if (this.jListRuns.getSelectedIndex() != -1) {
			Run run = this.viewRunController.getRun(this.jListRuns.
				getSelectedIndex());
			new ResultsGUI(null, run.getStepResults(), Step.getLegend());
			new ResultsGUI(null, run.getDropResults(), Drop.getLegend());
			this.close();
		}
    }//GEN-LAST:event_jButtonViewActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
		this.close();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonView;
    private javax.swing.JLabel jLabelWithRuns;
    private javax.swing.JList jListRuns;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
