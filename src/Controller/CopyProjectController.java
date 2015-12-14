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

	private Project project;
	private Project projectCopy;
	private ProjectData projectData;

	public Boolean initiation() {
		this.projectData = Data.getProjectData();
		this.project = ContextController.getOpenProject();
		return this.project != null;
	}

	public Boolean copyProject() {
		this.projectCopy = this.projectData.clone(this.project);
		return this.projectCopy != null;
	}

	public Boolean saveProject() {
		this.projectData.save(this.projectCopy);
		return true;
	}
}
