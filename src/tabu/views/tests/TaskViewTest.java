/*
    Undead Project
    Krzysztof Chrobak 2011
*/

package tabu.views.tests;

import java.util.LinkedList;
import javax.swing.JLabel;
import tabu.models.Task;
import tabu.views.TaskPanel;

/**
 *
 * @author krzychu
 */
public class TaskViewTest extends BaseGUITest{

    public static void main(String args[]){
        TaskViewTest t = new TaskViewTest();
    }

    public void build(){
        LinkedList<String> forbidden = new LinkedList<String>();
        forbidden.add("a");
        forbidden.add("muchLonger");
        Task task = new Task("name", forbidden);
        this.add(new TaskPanel(task));
    }
}
