/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.List;
import Model.Project;

/**
 *
 * @author LAPR3_20152016_G27
 */
public interface ProjectData {

	Project newInstance();

	List<Project> all();

	Boolean save(Project project);

	Project clone(Project project);

}
