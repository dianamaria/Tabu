/*
    Undead Project
    Krzysztof Chrobak 2011
*/

package tabu.views;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;
import javax.swing.*;
import tabu.models.ObservableList;
import tabu.models.Player;
import tabu.models.Team;

/**
 *
 * @author krzychu
 */
public class MainView extends JFrame{

    private final static String INFORMATION = "information";
    private final static String GAME = "game";

    private final static String DATAFILE = "players_and_teams.ser";

    private CardLayout cards = new CardLayout();
    private JPanel content = new JPanel(cards);

    private InformationPanel informationPanel;
    private MainMenu mainMenu = new MainMenu();
  
    // logic
    private ObservableList<Player> players = new ObservableList<Player>();
    private ObservableList<Team> teams = new ObservableList<Team>();

    public MainView(){
        loadData();
        this.setPreferredSize(new Dimension(800,600));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setJMenuBar(mainMenu);
        mainMenu.setController(this);

        this.setContentPane(content);
        informationPanel = new InformationPanel(this, players, teams);
        content.add(informationPanel, INFORMATION);
        

        this.pack();
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent ev){
                saveData();
            }
        });

    }

    public void newGame(){
        System.out.println("new game");
    }

    public void newTeam(){
        System.out.println("new team");
    }

    public void newPlayer(){
        String name = JOptionPane.showInputDialog(this, 
                "Enter player name:");
        players.add(new Player(name));
    }

    public void removePlayer(Player p){
        players.remove(p);
    }

    public void exitRequest(){
        System.out.println("exit request");
    }

    public void displayRules(){
        System.out.println("display rules");
    }

    public void displayInfo(){
        System.out.println("display info");
    }

    public final void saveData(){
        Saver saver = new Saver(players, teams);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            fos = new FileOutputStream(DATAFILE);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(saver);
            oos.close();
        } catch(IOException ex){
            System.out.println("Unable to save settings");
        }
    }

    public final void loadData(){
        Saver saver = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            fis = new FileInputStream(DATAFILE);
            ois = new ObjectInputStream(fis);
            saver = (Saver) ois.readObject();
            ois.close();

            players = saver.players;
            teams = saver.teams;
        } catch(Exception ex){
            System.out.println("Unable to load settings");
        }
    }
}



class Saver implements Serializable {
    ObservableList<Player> players = null;
    ObservableList<Team> teams = null;

    public Saver(){}

    public Saver(ObservableList<Player> players, ObservableList<Team> teams) {
        this.players = players;
        this.teams = teams;
    }
}
