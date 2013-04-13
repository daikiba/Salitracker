/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package saliswing;

import controller.*;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import saliSql.SaliActivity;

/**
 *
 * @author Kone
 */
public class NewDayPlanWindow extends JFrame implements SaveableForm {
    private String title = "Uusi P\u00E4iv\u00E4ohjelma";
    private JPanel panelBase, basicGrid, basicFlow, largerGrid, boxFlow;
    private OkCancelRow okCancelRow;
    private JLabel labelName;
    private JTextField textFieldName;
    private ComboBoxPanel multiSelectBox;
    
    private SaliControllerHibernate contr = new SaliControllerHibernate();
    
    public NewDayPlanWindow() {
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
        
        labelName = new JLabel("Ohjelman nimi");
        
        multiSelectBox = new ComboBoxPanel(this, "Aktiviteetit", contr.getActivities(), contr);
        
        textFieldName = new JTextField();
        
        basicGrid.add(labelName);
        basicGrid.add(textFieldName);
        
        basicFlow.add(basicGrid);
        
        boxFlow.add(multiSelectBox);
        
        panelBase.add(basicFlow);
        panelBase.add(boxFlow);
        panelBase.add(largerGrid);
        panelBase.add(okCancelRow);
        
        this.getContentPane().add(panelBase);

        pack();
        setVisible(true);
    }
    
    @Override
    public void save() {
        if ("".equals(textFieldName.getText())) {
            JOptionPane.showMessageDialog(this, "P\u00E4iv\u00E4ohjelman nimi puuttuu", "Virhe", JOptionPane.ERROR_MESSAGE);
        }
        else {
            if (contr.addNewProgram(textFieldName.getText(), multiSelectBox.getSelectedItems())){
                JOptionPane.showMessageDialog(this, "Uusi p\u00E4iv\u00E4ohjelma tallennettu", "Valmis", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(this, contr.getError(), "Virhe", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
