/*
    Undead Project
    Krzysztof Chrobak 2011
*/

package tabu.models;

import java.util.Iterator;
import java.util.LinkedList;
import tabu.events.ModelChangeEvent;


/**
 *
 * @author krzychu
 */
public class ObservableList<T> extends AbstractModel implements Iterable<T>{
    private LinkedList<T> items = new LinkedList<T>();

    public T get(int i){
        return items.get(i);
    }

    public void add(T item){
        items.add(item);
        notify(new ModelChangeEvent(this));
    }

    public void remove(T item){
        items.remove(item);
        notify(new ModelChangeEvent(this));
    }

    public int size(){
        return items.size();
    }

    public T[] toArray(){
        return (T[])items.toArray();
    }

    public Iterator<T> iterator() {
        return items.iterator();
    }
}
