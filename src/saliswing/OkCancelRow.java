/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package saliswing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Kone
 */
public class OkCancelRow extends JPanel {
    private JButton okButton, cancelButton;
    
    public OkCancelRow() {
        okButton = new JButton("OK");
        cancelButton = new JButton("Peruuta");
        
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("ok");
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
}
