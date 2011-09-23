/*
    Undead Project
    Krzysztof Chrobak 2011
*/

package tabu.views;

import java.awt.GridLayout;
import javax.swing.JPanel;
import tabu.models.ObservableList;
import tabu.models.Player;

/**
 * This panel displays information about registered teams, players and question
 * sets
 * @author krzychu
 */
public class InformationPanel extends JPanel{

    private ListEditorPanel<Player> playersEditor;

    public InformationPanel(MainView controller, ObservableList<Player> players){
        super(new GridLayout(0,3));
        playersEditor = new ListEditorPanel<Player>(
                players, new PlayerEditor(), "Players");
        this.add(playersEditor);
    }
}
