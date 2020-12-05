/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg2.Panels.UserInfoView;

import assignment.pkg2.ParentPanel;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author nathangoshay
 */
public class FollowUserPanel extends ParentPanel {
    
    //a panel containing a button that attaches a different user to the currentuser
    
    public JButton followUserButton;
    
    public FollowUserPanel() {
        
        setComponents();
        
    }
    
    private void setComponents() {
        
        followUserButton = new JButton("Follow User");
        
    }
    
    private void setFollowUserButtonActionListener() {
        
        followUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                //first, check if there is anything entered in the target user id text field
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                
                //if there is, then have this user follow the targeted user
            }
        });
        
    }
    
}
