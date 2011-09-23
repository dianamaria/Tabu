/*
    Undead Project
    Krzysztof Chrobak 2011
*/

package tabu.models;

/**
 *
 * @author krzychu
 */
public class TeamGameInfo {
    private Team team;
    private int score;

    public int getScore() {
        return score;
    }

    public Team getTeam() {
        return team;
    }

    public void addPoint(){
        score++;
    }

    public void subPoint(){
        score--;
    }
}
