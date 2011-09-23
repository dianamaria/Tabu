/*
    Undead Project
    Krzysztof Chrobak 2011
*/

package tabu.models;

import java.util.LinkedList;
import json.*;

/**
 *
 * @author krzychu
 */
public class Task {
    private String word;
    private LinkedList<String> forbidden = new LinkedList<String>();

    public Task(JSONObject obj) throws JSONException{
        this.load(obj);
    }

    public Task(String word, LinkedList<String> forbidden) {
        this.word = word;
        this.forbidden = forbidden;
    }

    
    /**
     * Loads Task from JSONObject
     */
    private void load(JSONObject obj) throws JSONException{
        word = obj.getString("noun");
        JSONArray forbidden_arr = obj.getJSONArray("forbidden");
        for(int i = 0; i < forbidden_arr.length(); i++){
            forbidden.add(forbidden_arr.getString(i));
        }
    }

    public LinkedList<String> getForbidden() {
        return forbidden;
    }

    public String getWord() {
        return word;
    }
}
