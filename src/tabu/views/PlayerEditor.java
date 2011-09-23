/*
    Undead Project
    Krzysztof Chrobak 2011
*/

package tabu.views;

import javax.swing.JOptionPane;
import tabu.models.Editor;
import tabu.models.Player;

/**
 *
 * @author krzychu
 */
public class PlayerEditor implements Editor<Player>{

    public Player newItem() {
        String name = JOptionPane.showInputDialog("Enter player name:");
        if(name == null)
            return null;
        else
            return new Player(name);
    }

    public void edit(Player item) {
        String name = JOptionPane.showInputDialog("Enter player name:",
                item.getName());
        if(name != null)
            item.setName(name);
    }

    public boolean sureDelete(Player item) {
        int n = JOptionPane.showConfirmDialog(null,
                "Do you really want to delete player : " + item + " ?",
                "Confirmation",
                JOptionPane.YES_NO_OPTION
                );
        return n == JOptionPane.OK_OPTION;
    }

}
