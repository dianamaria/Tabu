/*
    Undead Project
    Krzysztof Chrobak 2011
*/

package tabu.views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import tabu.models.Task;

/**
 *
 * @author krzychu
 */
public class TaskPanel extends JPanel{
    private JPanel inner = new JPanel(new GridLayout(0,1));
    private Task task;

    public TaskPanel(Task task){
        super(new BorderLayout());
        this.task = task;
        inner.add(new JLabel(task.getWord(), JLabel.CENTER));
        inner.add(new JSeparator(JSeparator.HORIZONTAL));
        for(String w : task.getForbidden()){
            inner.add(new JLabel(w, JLabel.CENTER));
        }
        this.add(inner, BorderLayout.PAGE_START);
    }
}
