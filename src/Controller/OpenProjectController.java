/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Data.Data;
import Data.ProjectData;
import Model.Project;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public class OpenProjectController {

	private ProjectData projectData;
	private Project project;

	public List<Project> PedeListaProjetosExistentes() {
		this.projectData = Data.getProjectData();
		return this.projectData.all();
	}

	public void ProjetoEscolhido(Project proj) {
		ContextController.setOpenProject(proj);
	}
}
