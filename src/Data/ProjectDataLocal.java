/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Model.Project;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class ProjectDataLocal implements ProjectData {

	private List<Project> list = new ArrayList();
	private Integer currentIndex = 0;

	private Integer getCurrentIndex() {
		this.currentIndex++;
		return this.currentIndex;
	}

	@Override
	public Project newInstance() {
		Project project = new Project();
		project.setId(this.getCurrentIndex());
		return project;
	}

	@Override
	public List<Project> all() {
		return new ArrayList(this.list);
	}

	@Override
	public Boolean save(Project project) {
		for (Project proj : this.list) {
			if (proj.equals(project)) {
				proj.setName(project.getName());
				proj.setDescription(project.getDescription());
				return true;
			}
		}
		return this.list.add(project);
	}

	@Override
	public Project clone(Project project) {
		Project newProject = this.newInstance();
		newProject.setId(this.getCurrentIndex());
		newProject.setName(project.getName());
		newProject.setDescription(project.getDescription());
		return newProject;
	}

	@Override
	public Project get(Integer id) {
		for (Project project : this.list) {
			if (project.getId() == id) {
				return project;
			}
		}
		return null;
	}

	@Override
	public Boolean hasChanged(Project project) {
		Project oldProject = this.get(project.getId());
		return !oldProject.equals(project);
	}

}
