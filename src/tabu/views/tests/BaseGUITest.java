/*
    Undead Project
    Krzysztof Chrobak 2011
*/

package tabu.views.tests;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author krzychu
 */
public class BaseGUITest extends JFrame implements ActionListener{

    public BaseGUITest(){
        this.setDefaultCloseOperation(BaseGUITest.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(400,400));
        this.setContentPane(new JPanel(new GridLayout(1,1)));
        this.build();
        this.pack();
        this.setVisible(true);

    }

    public void build(){
        add(new JLabel("empty"), BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
