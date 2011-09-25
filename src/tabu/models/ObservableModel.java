/*
    Undead Project
    Krzysztof Chrobak 2011
*/

package tabu.models;

import java.util.LinkedList;
import tabu.events.ModelChangeEvent;

/**
 *
 * @author krzychu
 */
public abstract class ObservableModel {
    private transient LinkedList<ModelChangeListener> listeners =
            new LinkedList< ModelChangeListener>();

    public void addModelChangeListener(ModelChangeListener listener){
        listeners.add(listener);
    }

    public void removeModelChangeListener(ModelChangeListener listener){
        listeners.remove(listener);
    }

    public void notify(ModelChangeEvent event){
        for(ModelChangeListener l : listeners){
            l.modelChanged(event);
        }
    }
}
