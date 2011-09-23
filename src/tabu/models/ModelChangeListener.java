/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tabu.models;

import tabu.events.ModelChangeEvent;


/**
 *
 * @author krzychu
 */
public interface ModelChangeListener {
    public void modelChanged(ModelChangeEvent event);
}
