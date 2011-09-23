/*
    Undead Project
    Krzysztof Chrobak 2011
*/

package tabu.views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import tabu.events.ModelChangeEvent;
import tabu.models.Editor;
import tabu.models.ModelChangeListener;
import tabu.models.ObservableList;

/**
 *
 * @author krzychu
 */
public class ListEditorPanel<T> extends JPanel implements 
        ModelChangeListener,
        ActionListener
{
    // logic
    private ObservableList<T> list;
    private Editor<T> editor;

    // view
    private JList listView;
    private JButton addButton = new JButton("Add");
    private JButton removeButton = new JButton("Delete");
    private JButton editButton = new JButton("Edit");
    private JPanel buttonPanel = new JPanel(new GridLayout(0,3));

    public ListEditorPanel(
            ObservableList<T> list,
            Editor<T> editor,
            String title)
    {
        super(new BorderLayout());

        this.list = list;
        list.addListener(this);
        this.editor = editor;

        // create list view
        listView = new JList(list.toArray());

        // create button panel
        buttonPanel.add(addButton);
        addButton.addActionListener(this);
        buttonPanel.add(editButton);
        editButton.addActionListener(this);
        buttonPanel.add(removeButton);
        removeButton.addActionListener(this);

        this.add(new JLabel(title, JLabel.CENTER), BorderLayout.PAGE_START);
        this.add(listView, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.PAGE_END);
    }

    private void reloadList(){
        DefaultListModel model = new DefaultListModel();
        for(T e : list){
            model.addElement(e);
        }
        listView.setModel(model);
    }

    public void modelChanged(ModelChangeEvent event) {
        reloadList();
    }

    public void actionPerformed(ActionEvent e) {
        if(list == null || editor == null)
            return;
        
        if(e.getSource() == addButton){
            T newItem = editor.newItem();
            if(newItem != null)
                list.add(newItem);
        }
        else if(listView.getSelectedIndex() != -1){
            if(e.getSource() == removeButton){
                if(editor.sureDelete((T) listView.getSelectedValue()) == true)
                    list.remove((T) listView.getSelectedValue());
            }
            else if(e.getSource() == editButton){
                editor.edit((T) listView.getSelectedValue());
                list.notify(new ModelChangeEvent(list));
            }
        }
    }

}
