/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package componentes.appexecutionplanner;

import java.io.File;
import java.io.Serializable;

/**
 *
 * @author Jose Javier BO
 */
public class AplicacionEjecutable extends File implements Serializable {

    public AplicacionEjecutable(String pathname) {
        super(pathname);
    }
}
