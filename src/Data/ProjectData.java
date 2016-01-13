/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Model.Project;
import java.util.List;

/**
 *
 * @author LAPR3_20152016_G27
 */
public interface ProjectData {

	/**
	 *
	 * @return
	 */
	Integer size();

	/**
	 *
	 * @return
	 */
	List<Project> all();

	/**
	 *
	 * @param project
	 * @return
	 */
	Boolean save(Project project);

	/**
	 *
	 * @param projects
	 * @return
	 */
	Boolean save(List<Project> projects);

	/**
	 *
	 * @param project
	 * @return
	 */
	Project get(Project project);

	/**
	 *
	 * @param project
	 * @return
	 */
	Boolean hasChanged(Project project);

}
