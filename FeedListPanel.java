/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg2.Panels.UserInfoView;

import assignment.pkg2.ParentPanel;
import javax.swing.JTextArea;

/**
 *
 * @author nathangoshay
 */
public class FeedListPanel extends ParentPanel {
    
    //displays this user's feed, which is other users' tweets and such
    
    public JTextArea feedListTextArea;
    
    public FeedListPanel() {
        
        setComponents();
        
    }
    
    private void setComponents() {
        
        feedListTextArea = new JTextArea("hi there. this is the feed text area");
        
    }
    
}
