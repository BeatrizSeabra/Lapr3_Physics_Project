/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ContextController;
import Simulation.Analysis;
import Simulation.PathAnalysis;
import Simulation.VehicleAnalysis;
import System.Settings;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JMenuItem;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class ApplicationGUI extends GraphicUserInterface {

	/**
	 * Creates new form MainFrame
	 */
	public ApplicationGUI() {
		this.initComponents();
		this.creation(null);
	}

	/**
	 *
	 */
	@Override
	public void initiation() {
		this.setLocationRelativeTo(null);
	}

	/**
	 *
	 */
	@Override
	public void update() {
		this.rootPane.getContentPane().removeAll();
		if (ContextController.getOpenProject() != null) {
			this.rootPane.getContentPane().setLayout(new FlowLayout());
			this.rootPane.getContentPane().add(new ViewProjectGUI());
			this.accessMenu(true, ContextController.getOpenSimulation() != null);
		} else {
			this.initComponents();
			this.accessMenu(false, false);
		}
		this.loadMenuAnalysis();
		this.repaint();
		this.revalidate();
	}

	private void accessMenu(Boolean stateProject, Boolean stateSimulation) {
		this.addVehicle.setEnabled(stateProject);
		this.copyProject.setEnabled(stateProject);
		this.editProject.setEnabled(stateProject);
		this.jMenuItemAddRoads.setEnabled(stateProject);
		this.jMenuItemCloseProject.setEnabled(stateProject);
		this.analysis.setEnabled(stateProject);
		this.simulation.setEnabled(stateProject);
		this.JMenuItemCopySimulation.setEnabled(stateSimulation);
		this.jMenuItemEditSimulation.setEnabled(stateSimulation);
		this.jMenuItemCloseSimulation.setEnabled(stateSimulation);
		this.jMenuRun.setEnabled(stateSimulation);
	}

	private void loadMenuAnalysis() {
		this.analysis.removeAll();
		List<Object> objects = Settings.loadAllClass(Settings.
			getOptions("PathAnalysisClass"));
		objects.addAll(Settings.loadAllClass(Settings.
			getOptions("VehicleAnalysisClass")));
		for (Object object : objects) {
			Analysis analysis = (Analysis) object;
			if (analysis != null) {
				JMenuItem menuItem = new javax.swing.JMenuItem();
				menuItem.setText(analysis.getName());
				menuItem.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						jMenuAnalysisActionPerformed(evt, analysis);
					}
				});
				this.analysis.add(menuItem);
			}
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

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jLabelWithWarning = new javax.swing.JLabel();
        jLabelCreateProject = new javax.swing.JLabel();
        jLabelOpenProject = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        closeProject = new javax.swing.JMenu();
        openProject = new javax.swing.JMenuItem();
        createProject = new javax.swing.JMenuItem();
        copyProject = new javax.swing.JMenuItem();
        editProject = new javax.swing.JMenuItem();
        addVehicle = new javax.swing.JMenuItem();
        jMenuItemAddRoads = new javax.swing.JMenuItem();
        jMenuItemCloseProject = new javax.swing.JMenuItem();
        analysis = new javax.swing.JMenu();
        simulation = new javax.swing.JMenu();
        jMenuItemOpenSimulation = new javax.swing.JMenuItem();
        jMenuItemCreateSimulation = new javax.swing.JMenuItem();
        JMenuItemCopySimulation = new javax.swing.JMenuItem();
        jMenuItemEditSimulation = new javax.swing.JMenuItem();
        jMenuItemCloseSimulation = new javax.swing.JMenuItem();
        jMenuRun = new javax.swing.JMenu();
        jMenuItemRunSimulation = new javax.swing.JMenuItem();
        jMenuItemViewRun = new javax.swing.JMenuItem();
        jMenuItemDeleteRun = new javax.swing.JMenuItem();
        jMenuHelp = new javax.swing.JMenu();
        jMenuItemAbout = new javax.swing.JMenuItem();
        jMenuItemLog = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(827, 630));
        setMinimumSize(new java.awt.Dimension(827, 630));
        setSize(new java.awt.Dimension(827, 630));

        jLabelWithWarning.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabelWithWarning.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelWithWarning.setText("\"There is no active project!\"");

        jLabelCreateProject.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabelCreateProject.setForeground(new java.awt.Color(0, 51, 255));
        jLabelCreateProject.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCreateProject.setText("Create a project...");
        jLabelCreateProject.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCreateProjectMouseClicked(evt);
            }
        });

        jLabelOpenProject.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabelOpenProject.setForeground(new java.awt.Color(0, 51, 255));
        jLabelOpenProject.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelOpenProject.setText("Open a project...");
        jLabelOpenProject.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelOpenProjectMouseClicked(evt);
            }
        });

        closeProject.setText("Project");

        openProject.setText("Open");
        openProject.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openProjectMouseClicked(evt);
            }
        });
        openProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openProjectActionPerformed(evt);
            }
        });
        closeProject.add(openProject);

        createProject.setText("Create");
        createProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createProjectActionPerformed(evt);
            }
        });
        closeProject.add(createProject);

        copyProject.setText("Copy");
        copyProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyProjectActionPerformed(evt);
            }
        });
        closeProject.add(copyProject);

        editProject.setText("Edit");
        editProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProjectActionPerformed(evt);
            }
        });
        closeProject.add(editProject);

        addVehicle.setText("Add Vehicle");
        addVehicle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addVehicleActionPerformed(evt);
            }
        });
        closeProject.add(addVehicle);

        jMenuItemAddRoads.setText("Add Roads");
        jMenuItemAddRoads.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAddRoadsActionPerformed(evt);
            }
        });
        closeProject.add(jMenuItemAddRoads);

        jMenuItemCloseProject.setText("Close");
        jMenuItemCloseProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCloseProjectActionPerformed(evt);
            }
        });
        closeProject.add(jMenuItemCloseProject);

        jMenuBar1.add(closeProject);

        analysis.setText("Analysis");
        jMenuBar1.add(analysis);

        simulation.setText("Simulation");

        jMenuItemOpenSimulation.setText("Open");
        jMenuItemOpenSimulation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemOpenSimulationActionPerformed(evt);
            }
        });
        simulation.add(jMenuItemOpenSimulation);

        jMenuItemCreateSimulation.setText("Create");
        jMenuItemCreateSimulation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCreateSimulationActionPerformed(evt);
            }
        });
        simulation.add(jMenuItemCreateSimulation);

        JMenuItemCopySimulation.setText("Copy");
        JMenuItemCopySimulation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenuItemCopySimulationActionPerformed(evt);
            }
        });
        simulation.add(JMenuItemCopySimulation);

        jMenuItemEditSimulation.setText("Edit");
        jMenuItemEditSimulation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEditSimulationActionPerformed(evt);
            }
        });
        simulation.add(jMenuItemEditSimulation);

        jMenuItemCloseSimulation.setText("Close");
        jMenuItemCloseSimulation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCloseSimulationActionPerformed(evt);
            }
        });
        simulation.add(jMenuItemCloseSimulation);

        jMenuBar1.add(simulation);

        jMenuRun.setText("Run");

        jMenuItemRunSimulation.setText("Run Simulation");
        jMenuItemRunSimulation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRunSimulationActionPerformed(evt);
            }
        });
        jMenuRun.add(jMenuItemRunSimulation);

        jMenuItemViewRun.setText("View Run");
        jMenuItemViewRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemViewRunActionPerformed(evt);
            }
        });
        jMenuRun.add(jMenuItemViewRun);

        jMenuItemDeleteRun.setText("Delete Run");
        jMenuItemDeleteRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDeleteRunActionPerformed(evt);
            }
        });
        jMenuRun.add(jMenuItemDeleteRun);

        jMenuBar1.add(jMenuRun);

        jMenuHelp.setText("Help");

        jMenuItemAbout.setText("About");
        jMenuItemAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAboutActionPerformed(evt);
            }
        });
        jMenuHelp.add(jMenuItemAbout);

        jMenuItemLog.setText("Log");
        jMenuItemLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLogActionPerformed(evt);
            }
        });
        jMenuHelp.add(jMenuItemLog);

        jMenuBar1.add(jMenuHelp);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(307, 307, 307)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelWithWarning)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelOpenProject)
                            .addComponent(jLabelCreateProject))))
                .addContainerGap(320, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jLabelWithWarning)
                .addGap(57, 57, 57)
                .addComponent(jLabelCreateProject)
                .addGap(46, 46, 46)
                .addComponent(jLabelOpenProject)
                .addContainerGap(366, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openProjectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openProjectMouseClicked

    }//GEN-LAST:event_openProjectMouseClicked

    private void createProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createProjectActionPerformed
		new CreateProjectGUI(this);
    }//GEN-LAST:event_createProjectActionPerformed

    private void copyProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyProjectActionPerformed
		new CopyProjectGUI(this);
    }//GEN-LAST:event_copyProjectActionPerformed

    private void editProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProjectActionPerformed
		new EditProjectGUI(this);
    }//GEN-LAST:event_editProjectActionPerformed

    private void addVehicleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addVehicleActionPerformed
		new AddVehiclesGUI(this);
    }//GEN-LAST:event_addVehicleActionPerformed

    private void openProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openProjectActionPerformed
		new OpenProjectGUI(this);
    }//GEN-LAST:event_openProjectActionPerformed

    private void jLabelCreateProjectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCreateProjectMouseClicked
		this.createProjectActionPerformed(null);
    }//GEN-LAST:event_jLabelCreateProjectMouseClicked

    private void jLabelOpenProjectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelOpenProjectMouseClicked
		this.openProjectActionPerformed(null);
    }//GEN-LAST:event_jLabelOpenProjectMouseClicked

    private void jMenuItemCloseProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCloseProjectActionPerformed
		ContextController.setOpenProject(null);
		this.update();
    }//GEN-LAST:event_jMenuItemCloseProjectActionPerformed

    private void jMenuItemLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLogActionPerformed
		new LogGUI(null);
    }//GEN-LAST:event_jMenuItemLogActionPerformed

    private void jMenuItemCreateSimulationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCreateSimulationActionPerformed
		new CreateSimulationGUI(this);
    }//GEN-LAST:event_jMenuItemCreateSimulationActionPerformed

    private void jMenuItemOpenSimulationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemOpenSimulationActionPerformed
		new OpenSimulationGUI(this);
    }//GEN-LAST:event_jMenuItemOpenSimulationActionPerformed

    private void JMenuItemCopySimulationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuItemCopySimulationActionPerformed
		new CopySimulationGUI(this);
    }//GEN-LAST:event_JMenuItemCopySimulationActionPerformed

    private void jMenuItemEditSimulationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEditSimulationActionPerformed
		new EditSimulationGUI(this);
    }//GEN-LAST:event_jMenuItemEditSimulationActionPerformed

    private void jMenuItemCloseSimulationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCloseSimulationActionPerformed
		ContextController.setOpenSimulation(null);
		this.update();
    }//GEN-LAST:event_jMenuItemCloseSimulationActionPerformed

    private void jMenuItemAddRoadsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAddRoadsActionPerformed
		new AddRoadsGUI(this);
    }//GEN-LAST:event_jMenuItemAddRoadsActionPerformed

    private void jMenuItemDeleteRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDeleteRunActionPerformed
		//new DeleteRunGUI(this);
    }//GEN-LAST:event_jMenuItemDeleteRunActionPerformed

    private void jMenuItemViewRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemViewRunActionPerformed
		//new ViewRunGUI(this);
    }//GEN-LAST:event_jMenuItemViewRunActionPerformed

    private void jMenuItemRunSimulationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRunSimulationActionPerformed
		new RunSimulationGUI(this);
    }//GEN-LAST:event_jMenuItemRunSimulationActionPerformed

    private void jMenuItemAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAboutActionPerformed
		new AboutGUI(this);
    }//GEN-LAST:event_jMenuItemAboutActionPerformed

	private void jMenuAnalysisActionPerformed(ActionEvent evt, Analysis analysis) {
		if (analysis instanceof PathAnalysis) {
			new PathAnalysisGUI(this, (PathAnalysis) analysis);
		} else if (analysis instanceof VehicleAnalysis) {
			new VehicleAnalysisGUI(this, (VehicleAnalysis) analysis);
		}
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem JMenuItemCopySimulation;
    private javax.swing.JMenuItem addVehicle;
    private javax.swing.JMenu analysis;
    private javax.swing.JMenu closeProject;
    private javax.swing.JMenuItem copyProject;
    private javax.swing.JMenuItem createProject;
    private javax.swing.JMenuItem editProject;
    private javax.swing.JLabel jLabelCreateProject;
    private javax.swing.JLabel jLabelOpenProject;
    private javax.swing.JLabel jLabelWithWarning;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuHelp;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItemAbout;
    private javax.swing.JMenuItem jMenuItemAddRoads;
    private javax.swing.JMenuItem jMenuItemCloseProject;
    private javax.swing.JMenuItem jMenuItemCloseSimulation;
    private javax.swing.JMenuItem jMenuItemCreateSimulation;
    private javax.swing.JMenuItem jMenuItemDeleteRun;
    private javax.swing.JMenuItem jMenuItemEditSimulation;
    private javax.swing.JMenuItem jMenuItemLog;
    private javax.swing.JMenuItem jMenuItemOpenSimulation;
    private javax.swing.JMenuItem jMenuItemRunSimulation;
    private javax.swing.JMenuItem jMenuItemViewRun;
    private javax.swing.JMenu jMenuRun;
    private javax.swing.JMenuItem openProject;
    private javax.swing.JMenu simulation;
    // End of variables declaration//GEN-END:variables
}
