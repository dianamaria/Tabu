/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tabu.models;

import json.JSONException;
import json.JSONObject;

/**
 *
 * @author krzychu
 */
public interface JSONSerializable<T> {
    public JSONObject dump() throws JSONException;
    public T load(JSONObject obj, Object context, T prototype) throws JSONException;
}
