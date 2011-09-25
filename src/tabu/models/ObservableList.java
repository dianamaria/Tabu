/*
    Undead Project
    Krzysztof Chrobak 2011
*/

package tabu.models;

import java.util.Iterator;
import java.util.LinkedList;
import json.JSONArray;
import json.JSONException;
import json.JSONObject;
import tabu.events.ModelChangeEvent;


/**
 *
 * @author krzychu
 */
public class ObservableList<T extends JSONSerializable> extends ObservableModel
        implements Iterable<T>, JSONSerializable
{
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

    public JSONObject dump() throws JSONException {
        JSONObject result = new JSONObject();
        JSONArray a = new JSONArray();
        for(T i : items){
            a.put(i.dump());
        }
        result.put("items", a);
        return result;
    }

    public void load(JSONObject obj, Object context) throws JSONException {
        JSONArray arr = obj.getJSONArray("items");
        for(int i=0; i<arr.length(); i++){
            
        }
    }
}
