/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package saliswing;

import controller.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Kone
 */
public class NewDayPlanWindow extends JFrame {
    private String title = "Uusi P\u00E4iv\u00E4ohjelma";
    private JPanel panelBase, basicGrid, basicFlow, largerGrid, boxFlow, textAreaFlow;
    private OkCancelRow okCancelRow;
    private JLabel labelName, labelDesciption, labelReps;
    private JTextField textFieldName, textFieldReps;
    private JTextArea textAreaDescription;
    private ComboBoxPanel multiSelectBox;
    
    private SaliControllerHibernate contr = new SaliControllerHibernate();
    
    //private List<SaliMuscleGroup> muscleGroups;
    
    public NewDayPlanWindow() {
        initComponents();
    }
    
    private void initComponents() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle(title);
        
        panelBase = new JPanel(new GridLayout(0,1));
        basicGrid = new JPanel(new GridLayout(0,2));
        basicFlow = new JPanel(new FlowLayout());
        largerGrid = new JPanel(new GridLayout(0,2));
        boxFlow = new JPanel(new FlowLayout());
        okCancelRow = new OkCancelRow();
        textAreaFlow = new JPanel(new FlowLayout());
        
        labelName = new JLabel("Ohjelman nimi");
        labelDesciption = new JLabel("Kuvaus");
        //labelReps = new JLabel("Toistosuositus (lkm)");
        
        multiSelectBox = new ComboBoxPanel("Aktiviteetit", contr.getActivities(), contr);
        
        textFieldName = new JTextField();
        //textFieldReps = new JTextField();
        textAreaDescription = new JTextArea(5, 8);
        textAreaDescription.setBorder(BorderFactory.createLineBorder(Color.black));
        
        basicGrid.add(labelName);
        basicGrid.add(textFieldName);
        
        //basicGrid.add(labelReps);
        //basicGrid.add(textFieldReps);
        
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
}
