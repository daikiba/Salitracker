/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package saliswing;

import controller.SaliControllerHibernate;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import saliSql.SaliActivity;
import saliSql.SaliProgram;

/**
 *
 * @author Kone
 */
public class ComboBoxLogView extends JPanel {

    private JLabel descriptionLabel;
    private JComboBox comboBoxItems;
    private Set<SaliProgram> listItems;
    private Set<SaliProgram> selectedItems;
    private JPanel gridBox, flowBox;
    protected SaliControllerHibernate controller;
    private JFrame parentPanel;
    private SelectedDayActivities dailyActivity;

    public ComboBoxLogView(JFrame parent, String description, Set<SaliProgram> items, SaliControllerHibernate controller) {
        parentPanel = parent;
        dailyActivity = new SelectedDayActivities(items.iterator().next());
        descriptionLabel = new JLabel(description);
        selectedItems = new HashSet<>();
        gridBox = new JPanel(new GridLayout(3, 0));
        flowBox = new JPanel(new FlowLayout());
        listItems = items;
        this.controller = controller;

        comboBoxItems = new JComboBox();
        comboBoxItems.addItem("Select one");
        for (SaliProgram listItem : listItems) {
            comboBoxItems.addItem(listItem);
        }

        comboBoxItems.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setDailyPanel((SaliProgram) comboBoxItems.getSelectedItem());
                updateMyView();
            }
        });
        flowBox.add(descriptionLabel);
        flowBox.add(comboBoxItems);
   
        //gridBox.add(dailyActivity);
        setLayout(new GridLayout(2, 0));
        this.add(flowBox);
        this.add(dailyActivity);
    }

    private void setDailyPanel(SaliProgram rowItem) {
        dailyActivity = new SelectedDayActivities(rowItem);
    }

    private void updateMyView() {
        this.revalidate();
        //this.repaint();
        parentPanel.pack();
    }

    public Set<SaliProgram> getSelectedItems() {
        return selectedItems;
    }

    private class SelectedDayActivities extends JPanel {

        private SaliProgram saliActivity;
        private JLabel dailySetText;
        private JLabel dailyRepText;
        private JLabel dailyWeightText;
        private List<JTextField> dailySets;
        private List<JTextField> dailyReps;
        private List<JTextField> dailyWeight;

        public SelectedDayActivities(SaliProgram saliActivity) { 
            this.saliActivity = saliActivity;
            dailySets = new ArrayList();
            dailyReps = new ArrayList();
            dailyWeight = new ArrayList();
            this.setLayout(new GridLayout(0, 1));

            for (SaliActivity sali : saliActivity.getActivities()) {
                JPanel gridTemp = new JPanel(new GridLayout(0, 1));
                JPanel gridTwo = new JPanel(new GridLayout(1, 0));
                JPanel flowOne, flowTwo, flowThree;
                flowOne = new JPanel(new FlowLayout());
                flowOne.setBorder(BorderFactory.createBevelBorder(1));
                flowTwo = new JPanel(new FlowLayout());
                flowTwo.setBorder(BorderFactory.createBevelBorder(1));
                flowThree = new JPanel(new FlowLayout());
                flowThree.setBorder(BorderFactory.createBevelBorder(1));
                
                JTextField setsTemp = new JTextField("0");
                JTextField repsTemp = new JTextField(String.valueOf(sali.getDefaultAmountOfReps()));
                JTextField weightTemp = new JTextField("0");
                
                setsTemp.setPreferredSize(new Dimension(28, 24));
                repsTemp.setPreferredSize(new Dimension(28, 24));
                weightTemp.setPreferredSize(new Dimension(28, 24));

                gridTemp.setBorder(BorderFactory.createEtchedBorder());
                
                gridTemp.add(new JLabel(sali.getName()));
                
                flowOne.add(new JLabel("Settit: "));
                flowOne.add(setsTemp);
                gridTwo.add(flowOne);
                dailySets.add(setsTemp);

                flowTwo.add(new JLabel("Toistot: "));
                flowTwo.add(repsTemp);
                gridTwo.add(flowTwo);
                dailyReps.add(repsTemp);

                flowThree.add(new JLabel("Paino(KG): "));
                flowThree.add(weightTemp);
                gridTwo.add(flowThree);
                dailyWeight.add(weightTemp);

                gridTemp.add(gridTwo);

                this.add(gridTemp);
            }

        }
    }
}
