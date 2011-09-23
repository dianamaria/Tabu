/*
    Undead Project
    Krzysztof Chrobak 2011
*/

package tabu.models;

import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author krzychu
 */
public class Team implements Serializable{
    private String name;
    private LinkedList<Player> players = new LinkedList<Player>();

    public Team(String name) {
        this.name = name;
    }

    public void addPlayer(Player p){
        players.add(p);
    }

    public void removePlayer(Player p){
        players.remove(p);
    }

    public String getName() {
        return name;
    }    
}
