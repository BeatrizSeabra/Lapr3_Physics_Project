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
 * @author valhalla
 */
public class ProjectDataLocal implements ProjectData {

	List<Project> list = new ArrayList();

	@Override
	public Project newInstance() {
		return new Project();
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
		return newProject;
	}

}
