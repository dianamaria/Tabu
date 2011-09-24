/*
    Undead Project
    Krzysztof Chrobak 2011
*/

package tabu.models;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author krzychu
 */
public class Team implements Iterable<Player>{
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
}
