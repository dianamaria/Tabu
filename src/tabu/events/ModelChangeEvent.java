/*
    Undead Project
    Krzysztof Chrobak 2011
*/

package tabu.events;

/**
 *
 * @author krzychu
 */
public class ModelChangeEvent {

    public Object source;

    public ModelChangeEvent(Object source) {
        this.source = source;
    }

    public Object getSource() {
        return source;
    }
}
