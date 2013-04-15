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
public class ClientViewLog extends JFrame implements SaveableForm {

    private String title = "Uusi lokimerkinta";
    private JPanel panelBase;
    private OkCancelRow okCancelRow;
    private ComboBoxLogView logSelection;
    private SaliControllerHibernate contr = new SaliControllerHibernate();

    public ClientViewLog() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle(title);

        panelBase = new JPanel();
        panelBase.setLayout(new BoxLayout(panelBase, BoxLayout.Y_AXIS));
        okCancelRow = new OkCancelRow(this);

        logSelection = new ComboBoxLogView(this, "Treeni Ohjelma:", contr.getPrograms(), contr);


        panelBase.add(logSelection);

        panelBase.add(okCancelRow);

        this.getContentPane().add(panelBase);

        pack();
        setVisible(true);
    }

    @Override
    public void save() {
    }
}
