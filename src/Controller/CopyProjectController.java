/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Data.Data;
import Data.ProjectData;
import Model.Project;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class CopyProjectController {

	private ProjectData projectData;
	private Project project;
	private Project projectCopy;

	/**
	 *
	 * @return
	 */
	public Boolean initiation() {
		this.projectData = Data.getProjectData();
		this.project = ContextController.getOpenProject();
		return this.project != null;
	}

	/**
	 *
	 * @return
	 */
	public Boolean copyProject() {
		this.projectCopy = this.project.clone();
		this.projectCopy.setId(0);
		String name = new StringBuilder(this.projectCopy.getName()).
			append(" (copy)").toString();
		this.projectCopy.setName(name);
		return this.projectCopy != null;
	}

	/**
	 *
	 * @return
	 */
	public Boolean saveProject() {
		return this.projectData.save(this.projectCopy);
	}
}
