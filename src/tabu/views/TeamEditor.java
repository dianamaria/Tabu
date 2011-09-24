/*
    Undead Project
    Krzysztof Chrobak 2011
*/

package tabu.views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import tabu.events.ModelChangeEvent;
import tabu.models.*;


class TeamEditorDialog extends JDialog implements 
     ActionListener,
     ModelChangeListener
{

    public static final int EXIT_OK = 1;
    public static final int EXIT_ABORT = 2;

    private Team team;
    private ObservableList<Player> players;
    private int exitStatus = EXIT_ABORT;

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
        players.addListener(this);
        playersEditor = new ListEditor<Player>(
                players, new PlayerEditor(), "Players");

        nameEdit.setText(editTeam.getName());
        setTeam(editTeam);

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

        addToTeam.addActionListener(this);
        removeFromTeam.addActionListener(this);
        confirmButton.addActionListener(this);

        this.pack();

        this.addWindowListener(
            new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent ev){
                    finalOperations();
                }
            }
        );

    }

    private void setTeam(Team t){
        team = t;
        DefaultListModel model = new DefaultListModel();
        for(Player p : team){
            model.addElement(p);
        }
        teamMembers.setModel(model);
    }

    private void finalOperations(){
         players.removeListener(playersEditor);
         players.removeListener(this);
         team.setName(nameEdit.getText());
         System.out.println("finalized");
    }

    private void addToTeamAction(){
        Player toAdd = playersEditor.getSelectedObject();
        if(toAdd == null)
            return;
        
        if(team.addPlayer(toAdd))
            setTeam(team);
    }

    private void removeFromTeamAction(){
        Player toRemove = (Player) teamMembers.getSelectedValue();
        team.removePlayer(toRemove);
        setTeam(team);

    }

    private void confirm(){
        exitStatus = EXIT_OK;
        finalOperations();
        this.dispose();
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addToTeam)
            addToTeamAction();
        else if(e.getSource() == removeFromTeam)
            removeFromTeamAction();
        else if(e.getSource() == confirmButton)
            confirm();
    }

    public void modelChanged(ModelChangeEvent event) {
        setTeam(team);
    }

    public int getExitStatus() {
        return exitStatus;
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
        Team newTeam = new Team("Unnamed");
        TeamEditorDialog ted = new TeamEditorDialog(newTeam, players);
        ted.setVisible(true);
        if(ted.getExitStatus() == TeamEditorDialog.EXIT_OK)
            return newTeam;
        else
            return null;
    }

    public void edit(Team item) {
        TeamEditorDialog ted = new TeamEditorDialog(item, players);
        ted.setVisible(true);
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
