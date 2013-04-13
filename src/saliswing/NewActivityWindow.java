/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package saliswing;

import controller.*;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Kone
 */
public class NewActivityWindow extends JFrame implements SaveableForm {
    private String title = "Uusi Aktiviteetti";
    private JPanel panelBase, basicGrid, basicFlow, largerGrid, boxFlow, textAreaFlow;
    private OkCancelRow okCancelRow;
    private JLabel labelName, labelDesciption, labelReps;
    private JTextField textFieldName, textFieldReps;
    private JTextArea textAreaDescription;
    private ComboBoxPanel multiSelectBox;
    
    private SaliControllerHibernate contr = new SaliControllerHibernate();
    
    public NewActivityWindow() {
        initComponents();
    }
    
    private void initComponents() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle(title);
        
        panelBase = new JPanel();
        panelBase.setLayout(new BoxLayout(panelBase, BoxLayout.Y_AXIS));
        basicGrid = new JPanel(new GridLayout(0,2));
        basicFlow = new JPanel(new FlowLayout());
        largerGrid = new JPanel(new GridLayout(0,2));
        boxFlow = new JPanel(new FlowLayout());
        okCancelRow = new OkCancelRow(this);
        textAreaFlow = new JPanel(new FlowLayout());
        
        labelName = new JLabel("Liikkeen nimi");
        labelDesciption = new JLabel("Kuvaus");
        labelReps = new JLabel("Toistosuositus (lkm)");
        
        multiSelectBox = new ComboBoxPanel(this, "Lihasryhm\u00E4", contr.getMuscleGroups(), contr);
        
        textFieldName = new JTextField();
        textFieldReps = new JTextField();
        textAreaDescription = new JTextArea(5, 8);
        textAreaDescription.setBorder(BorderFactory.createLineBorder(Color.black));
        
        basicGrid.add(labelName);
        basicGrid.add(textFieldName);
        
        basicGrid.add(labelReps);
        basicGrid.add(textFieldReps);
        
        basicFlow.add(basicGrid);

        textAreaFlow.add(labelDesciption);
        largerGrid.add(textAreaFlow);
        largerGrid.add(textAreaDescription);
        
        boxFlow.add(multiSelectBox);
        
        panelBase.add(basicFlow);
        panelBase.add(boxFlow);
        panelBase.add(largerGrid);
        panelBase.add(okCancelRow);
        
        this.getContentPane().add(panelBase);

        //setSize(new Dimension(320, 420));
        pack();
        setVisible(true);
    }

    @Override
    public void save() {
        if ("".equals(textFieldName.getText())) {
            JOptionPane.showMessageDialog(this, "Liikeen nimi puuttuu", "Virhe", JOptionPane.ERROR_MESSAGE);
        }
        else {
            int dreps = 1;
            try {
                dreps =  Integer.parseInt(textFieldReps.getText());
            }
            catch(Exception ex) { }
            if (contr.addNewActivity(textFieldName.getText(), textAreaDescription.getText(), dreps, multiSelectBox.getSelectedItems())){
                JOptionPane.showMessageDialog(this, "Uusi aktiviteetti tallennettu", "Valmis", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(this, contr.getError(), "Virhe", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
