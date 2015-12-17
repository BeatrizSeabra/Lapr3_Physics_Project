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

	private Integer getNextIndex() {
		this.currentIndex++;
		return this.currentIndex;
	}

	@Override
	public Project newInstance() {
		Project project = new Project();
		project.setId(this.getNextIndex());
		return project;
	}

	@Override
	public Integer size() {
		return this.list.size();
	}

	@Override
	public List<Project> all() {
		return new ArrayList(this.list);
	}

	@Override
	public Boolean save(Project project) {
		for (Project oldProject : this.list) {
			if (oldProject.getId() == project.getId()) {
				this.list.remove(oldProject);
				return this.list.add(project);
			}
		}
		return this.list.add(project);
	}

	@Override
	public Project copy(Project project) {
		return project.clone();
	}

	@Override
	public Project clone(Project project) {
		Project newProject = this.copy(project);
		newProject.setId(this.getNextIndex());
		return newProject;
	}

	@Override
	public Project get(Integer id) {
		for (Project project : this.list) {
			if (project.getId() == id) {
				return this.copy(project);
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
