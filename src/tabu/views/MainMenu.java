/*
    Undead Project
    Krzysztof Chrobak 2011
*/

package tabu.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author krzychu
 */
class HelpMenu extends AbstractMenu{

    private MainView controller;

    private JMenuItem rules = new JMenuItem("Rules");
    private JMenuItem program = new JMenuItem("About...");

    public HelpMenu(){
        super("Help");
        addItem(rules);
        addItem(program);
    }

    public void setController(MainView m){
        this.controller = m;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == rules)
            controller.displayRules();
        else if(e.getSource() == program)
            controller.displayInfo();
    }
}

class GameMenu extends AbstractMenu{

    private MainView controller;

    private JMenuItem newGame = new JMenuItem("New game");
    private JMenuItem newTeam = new JMenuItem("New team");
    private JMenuItem newPlayer = new JMenuItem("New player");
    private JMenuItem exit = new JMenuItem("Exit");

    public GameMenu(){
        super("Game");

        addItem(newGame);
        addItem(newTeam);
        addItem(newPlayer);
        addSeparator();
        addItem(exit);
    }

    public void setController(MainView m){
        this.controller = m;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == newGame)
            controller.newGame();
        else if(e.getSource() == newTeam)
            controller.newTeam();
        else if(e.getSource() == newPlayer)
            controller.newPlayer();
        else if(e.getSource() == exit)
            controller.exitRequest();
    }
}

abstract class AbstractMenu extends JMenu implements ActionListener{
    
    public AbstractMenu(String text){
        super(text);
    }

    public void addItem(JMenuItem item){
        this.add(item);
        item.addActionListener(this);
    }
}

public class MainMenu extends JMenuBar{
    private GameMenu gameMenu = new GameMenu();
    private HelpMenu helpMenu = new HelpMenu();
    private MainView controller;

    public MainMenu(){
        this.add(gameMenu);
        this.add(helpMenu);
    }

    public void setController(MainView m){
        this.controller = m;
        gameMenu.setController(m);
        helpMenu.setController(m);
    }
}
