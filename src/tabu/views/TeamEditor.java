/*
    Undead Project
    Krzysztof Chrobak 2011
*/

package tabu.views;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import tabu.models.*;
class TeamEditorDialog extends JDialog{

    private Team team;
    private ObservableList<Player> players;

    private ListEditor<Player> playersEditor;
    private JPanel content = new JPanel(new BorderLayout());
    private JPanel propertiesPanel = new JPanel(new FlowLayout());
    private JTextField nameEdit = new JTextField(30);
    private JPanel transferPanel = new JPanel(new GridLayout(0,2,5,0));
    private JPanel confirmPanel = new JPanel();
    private JButton confirmButton = new JButton("Team ready");
    private JPanel teamPanel = new JPanel(new BorderLayout());
    private JPanel teamButtonsPanel = new JPanel(new GridLayout(0,2));
    private JButton addToTeam = new JButton("Import");
    private JButton removeFromTeam = new JButton("Remove");
    private JList teamMembers = new JList();

    public TeamEditorDialog(Team editTeam, ObservableList<Player> players_list){
        this.players = players_list;
        playersEditor = new ListEditor<Player>(
                players, new PlayerEditor(), "Players");
        
        // make sure that edited team is not null
        if(editTeam == null)
            editTeam = new Team("unnamed");

        // visual
        this.setModal(true);
        this.setTitle("Team edition");
        this.setPreferredSize(new Dimension(640,480));
        this.setContentPane(content);

        content.add(propertiesPanel, BorderLayout.PAGE_START);
        content.add(confirmPanel, BorderLayout.PAGE_END);
        content.add(transferPanel, BorderLayout.CENTER);

        propertiesPanel.add(new JLabel("Team name "));
        propertiesPanel.add(nameEdit);

        transferPanel.add(playersEditor);
        transferPanel.add(teamPanel);

        confirmPanel.add(confirmButton);

        teamPanel.add(new JLabel("Team members", JLabel.CENTER),
                BorderLayout.PAGE_START);
        teamPanel.add(teamButtonsPanel, BorderLayout.PAGE_END);
        teamPanel.add(teamMembers);

        teamButtonsPanel.add(addToTeam);
        teamButtonsPanel.add(removeFromTeam);

        this.pack();

        this.addWindowListener(
            new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent ev){
                    clean();
                }
            }
        );

    }

    private void clean(){
         players.removeListener(playersEditor);
    }


}

/**
 *
 * @author krzychu
 */
public class TeamEditor implements Editor<Team>{

    private ObservableList<Player> players = new ObservableList<Player>();

    public TeamEditor(ObservableList<Player> players) {
        this.players = players;
    }

    public Team newItem() {
        TeamEditorDialog ted = new TeamEditorDialog(null, players);
        ted.setVisible(true);
        System.out.println("yes");
        return null;
    }

    public void edit(Team item) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean sureDelete(Team item) {
        int n = JOptionPane.showConfirmDialog(null,
                "Do you really want to delete team : " + item + " ?",
                "Confirmation",
                JOptionPane.YES_NO_OPTION
                );
        return n == JOptionPane.OK_OPTION;
    }

}
