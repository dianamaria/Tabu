/*
    Undead Project
    Krzysztof Chrobak 2011
*/

package tabu.views;

import java.awt.GridLayout;
import javax.swing.JPanel;
import tabu.models.ObservableList;
import tabu.models.Player;
import tabu.models.Team;

/**
 * This panel displays information about registered teams, players and question
 * sets
 * @author krzychu
 */
public class InformationPanel extends JPanel{

    private ListEditor<Player> playersEditor;
    private ListEditor<Team> teamsEditor;

    public InformationPanel(
            MainView controller,
            ObservableList<Player> players,
            ObservableList<Team> teams)
    {
        super(new GridLayout(0,3,5,0));

        playersEditor = new ListEditor<Player>(
                players, new PlayerEditor(), "Players");
        teamsEditor = new ListEditor<Team>(
                teams, new TeamEditor(players), "Teams");


        this.add(playersEditor);
        this.add(teamsEditor);
    }
}
