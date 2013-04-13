/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package saliswing;

import controller.SaliController;
import controller.SaliControllerHibernate;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Kone
 */
public class ComboBoxPanel<T> extends JPanel {

    private JLabel descriptionLabel;
    private JComboBox comboBoxItems;
    private List<T> listItems;
    private List<String> selectedItems;
    private JPanel gridBox, flowBox;
    protected SaliControllerHibernate controller;

    public ComboBoxPanel(String description, List<T> items, SaliControllerHibernate controller) {
        descriptionLabel = new JLabel(description);
        selectedItems = new ArrayList();
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
                addNewRow(comboBoxItems.getSelectedItem().toString());
                updateMyView();
            }
        });

        gridBox.add(comboBoxItems);
        flowBox.add(descriptionLabel);

        setLayout(new GridLayout(0, 2));
        this.add(flowBox);
        this.add(gridBox);
    }

    private void addNewRow(String rowName) {
        if (!selectedItems.contains(rowName) && comboBoxItems.getSelectedIndex() != 0) {
            gridBox.add(new JLabel(rowName), 0);
            selectedItems.add(rowName);
        }
    }
    
    private void updateMyView(){
        this.revalidate();
        this.repaint();
    }
}
