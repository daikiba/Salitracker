/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package saliswing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Kone
 */
public class OkCancelRow extends JPanel {
    private JButton okButton, cancelButton;
    private SaveableForm parent;
    
    public OkCancelRow(SaveableForm parent) {
        this.parent = parent;
        okButton = new JButton("OK");
        cancelButton = new JButton("Peruuta");
        
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                callParentSave();
            }
        });
        
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("peruuta");
            }
        });
        
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
        this.add(okButton);
        this.add(cancelButton);
    }
    
    public void callParentSave() {
        if (parent != null) {
            parent.save();
        }
        else {
            System.out.println("Parent is null");
        }
    }
}
