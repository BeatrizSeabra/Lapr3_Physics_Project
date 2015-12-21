/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ContextController;
import Model.Project;
import Model.Vehicle;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class ViewProjectGUI extends JPanel {

	private DefaultListModel jModelListVehicles = new DefaultListModel();

	/**
	 * Creates new form ViewProjectGUI
	 */
	public ViewProjectGUI() {
		this.initComponents();
		this.initiation();
		this.update();
	}

	public void initiation() {
		this.jListVehicles.setModel(jModelListVehicles);
	}

	public void update() {
		Project project = ContextController.getOpenProject();
		this.jLabelName.setText(project.getName());
		this.jLabelDescription.setText(project.getDescription());
		this.jTextArea1.setText(project.getRoadNetwork().toString());
		this.jModelListVehicles.removeAllElements();
		for (Vehicle vehicle : project.getVehicles()) {
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

        jLabelWothName = new javax.swing.JLabel();
        jLabelName = new javax.swing.JLabel();
        jLabelWithDescription = new javax.swing.JLabel();
        jLabelDescription = new javax.swing.JLabel();
        jScrollPaneVeicles = new javax.swing.JScrollPane();
        jListVehicles = new javax.swing.JList();
        jLabelWithVehicles = new javax.swing.JLabel();
        jLabelWithRoadNetwork = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setMaximumSize(new java.awt.Dimension(470, 440));
        setMinimumSize(new java.awt.Dimension(470, 440));

        jLabelWothName.setText("Name:");

        jLabelWithDescription.setText("Description: ");

        jLabelDescription.setText("Description");

        jListVehicles.setMaximumSize(new java.awt.Dimension(430, 140));
        jListVehicles.setMinimumSize(new java.awt.Dimension(430, 140));
        jListVehicles.setPreferredSize(new java.awt.Dimension(430, 140));
        jScrollPaneVeicles.setViewportView(jListVehicles);

        jLabelWithVehicles.setText("Vehicles:");

        jLabelWithRoadNetwork.setText("Road Network:");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setMaximumSize(new java.awt.Dimension(240, 80));
        jTextArea1.setMinimumSize(new java.awt.Dimension(240, 80));
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabelWithDescription)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelWothName)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelName, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelWithVehicles)
                            .addComponent(jLabelWithRoadNetwork))
                        .addGap(0, 146, Short.MAX_VALUE))
                    .addComponent(jScrollPaneVeicles, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelWothName)
                    .addComponent(jLabelName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelWithDescription)
                    .addComponent(jLabelDescription))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelWithRoadNetwork)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelWithVehicles)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneVeicles, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelDescription;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelWithDescription;
    private javax.swing.JLabel jLabelWithRoadNetwork;
    private javax.swing.JLabel jLabelWithVehicles;
    private javax.swing.JLabel jLabelWothName;
    private javax.swing.JList jListVehicles;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneVeicles;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
