/*
    Undead Project
    Krzysztof Chrobak 2011
*/

package tabu.models;

import java.util.ArrayList;

import json.*;
/**
 *
 * @author krzychu
 */
public class TaskSet {
    
    private String topic;
    private ArrayList<Task> tasks = new ArrayList<Task>();

    public TaskSet(JSONObject obj) throws JSONException{
        this.load(obj);
    }

    private void load(JSONObject obj) throws JSONException{
        topic = obj.getString("topic");
        JSONArray arr = obj.getJSONArray("tasks");
        for(int i=0; i<arr.length(); i++){
            tasks.add(new Task(arr.getJSONObject(i)));
        }
    }

    public Task get(int i){
        return tasks.get(i);
    }

    public int size(){
        return tasks.size();
    }
}
