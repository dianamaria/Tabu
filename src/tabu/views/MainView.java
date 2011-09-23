/*
    Undead Project
    Krzysztof Chrobak 2011
*/

package tabu.views;

import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.*;
import tabu.models.ObservableList;
import tabu.models.Player;

/**
 *
 * @author krzychu
 */
public class MainView extends JFrame{

    private final static String INFORMATION = "information";
    private final static String GAME = "game";

    private CardLayout cards = new CardLayout();
    private JPanel content = new JPanel(cards);

    private InformationPanel informationPanel;
    private MainMenu mainMenu = new MainMenu();
  
    // logic
    private ObservableList<Player> players = new ObservableList<Player>();


    public MainView(){
        this.setPreferredSize(new Dimension(800,600));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setJMenuBar(mainMenu);
        mainMenu.setController(this);

        this.setContentPane(content);
        informationPanel = new InformationPanel(this, players);
        content.add(informationPanel, INFORMATION);
        

        this.pack();
        this.setVisible(true);
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
}
