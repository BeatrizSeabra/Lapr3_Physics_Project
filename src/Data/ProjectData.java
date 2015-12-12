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

	Project newInstance();

	Integer size();

	List<Project> all();

	Boolean save(Project project);

	Project copy(Project project);

	Project clone(Project project);

	Project get(Integer id);

	Boolean hasChanged(Project project);

}
