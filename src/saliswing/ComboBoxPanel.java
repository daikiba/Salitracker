/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package saliswing;

import controller.SaliControllerHibernate;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Kone
 */
public class ComboBoxPanel<T> extends JPanel {

    private JLabel descriptionLabel;
    private JComboBox comboBoxItems;
    private Set<T> listItems;
    private Set<T> selectedItems;
    private JPanel gridBox, flowBox;
    protected SaliControllerHibernate controller;
    private JFrame ghostBusters;

    public ComboBoxPanel(JFrame parent, String description, Set<T> items, SaliControllerHibernate controller) {
        ghostBusters = parent;
        descriptionLabel = new JLabel(description);
        selectedItems = new HashSet<>();
        gridBox = new JPanel(new GridLayout(0, 1));
        flowBox = new JPanel(new FlowLayout());
        listItems = items;
        this.controller = controller;
        
        comboBoxItems = new JComboBox();
        comboBoxItems.addItem("Select one");
        for (T listItem : listItems) {
            comboBoxItems.addItem(listItem);
        }

        comboBoxItems.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                addNewRow((T)comboBoxItems.getSelectedItem());
                updateMyView();
            }
        });

        gridBox.add(comboBoxItems);
        flowBox.add(descriptionLabel);

        setLayout(new GridLayout(0, 2));
        this.add(flowBox);
        this.add(gridBox);
    }

    private void addNewRow(T rowItem) {
        if (!selectedItems.contains(rowItem) && comboBoxItems.getSelectedIndex() != 0) {
            gridBox.add(new JLabel(rowItem.toString()), 0);
            selectedItems.add(rowItem);
        }
    }
    
    private void updateMyView(){
        //this.revalidate();
        //this.repaint();
        ghostBusters.pack();
    }
    
    public Set<T> getSelectedItems() {
        return selectedItems;
    }
}
