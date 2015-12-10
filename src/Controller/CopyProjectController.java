/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Data.Data;
import Data.ProjectData;
import Data.ProjectData;
import Model.Project;

/**
 *
 * @author LAPR3_20152016_G27
 */
public class CopyProjectController {
    private Project opened;
    private Project copy;
    private ProjectData rp;
    
    /**
     *
     * @return
     */
    public Boolean copyProject(){
        this.opened = ContextController.getOpenProject();
        this.rp = Data.getProjectData();
        this.copy = this.rp.clone(this.opened);
        return true;
    }
    public Boolean save(){
        this.rp.save(this.copy);
        return true;
    }
}
