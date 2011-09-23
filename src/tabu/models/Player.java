/*
    Undead Project
    Krzysztof Chrobak 2011
*/

package tabu.models;

/**
 *
 * @author krzychu
 */
public class Player {
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

    @Override
    public String toString(){
        return name;
    }
}
