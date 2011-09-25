/*
    Undead Project
    Krzysztof Chrobak 2011
*/

package tabu.models;

import json.JSONException;
import json.JSONObject;

/**
 *
 * @author krzychu
 */
public class Player implements JSONSerializable{
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JSONObject dump() throws JSONException{
        JSONObject result = new JSONObject();
        result.put("name", name);
        return result;
    }

    public void load(JSONObject obj, Object context) throws JSONException{
        name = obj.getString("name");
    }

    @Override
    public String toString(){
        return name;
    }
}
