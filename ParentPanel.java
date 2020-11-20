/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg2.Panels.AdminView;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JPanel;

/**
 *
 * @author nathangoshay
 */
public class ParentPanel extends JPanel {
    
    private static final Insets i = new Insets(0,0,0,0);
    
    public ParentPanel() {
        super(new GridBagLayout());
    }
 
    public void addComponent(Container c, Component comp, int x, int y, int width, int height, int anchor, int fill) {
        
        GridBagConstraints con = new GridBagConstraints(x, y, width, height, 1.0, 1.0, anchor, fill, i, 0, 0);
        c.add(comp, con);
        
    }
    
}
