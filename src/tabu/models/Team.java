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

/**
 *
 * @author krzychu
 */
public class Team implements Iterable<Player>, JSONSerializable{
    private String name;
    private LinkedList<Player> players = new LinkedList<Player>();

    public Team(String name) {
        this.name = name;
    }

    public boolean addPlayer(Player p){
        if(players.contains(p))
            return false;

        players.add(p);
        return true;
    }

    public void removePlayer(Player p){
        players.remove(p);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    

    @Override
    public String toString(){
        return name;
    }

    public Iterator<Player> iterator() {
        return players.iterator();
    }

    public Player[] getPlayersArray(){
        return (Player[]) players.toArray();
    }

    public JSONObject dump() throws JSONException {
        JSONObject result = new JSONObject();
        result.put("name", name);
        JSONArray players_arr = new JSONArray();
        for(Player p : this){
            players_arr.put(p.getName());
        }
        result.put("players", players_arr);
        return result;
    }

    private Player findByName(ObservableList<Player> ps, String playerName){
        for(Player p : ps){
            if(p.getName().equals(playerName))
                return p;
        }
        return null;
    }

    public void load(JSONObject obj, Object context) throws JSONException {
        ObservableList<Player> allPlayers = (ObservableList<Player>) context;
        name = obj.getString("name");
        JSONArray players_arr = obj.getJSONArray("players");
        players.clear();
        for(int i=0; i<players_arr.length() ; i++){
            String playerName = players_arr.getString(i);
            players.add(findByName(allPlayers, playerName));
        }
    }
}
