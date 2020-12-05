/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg2.Panels.UserInfoView;

import assignment.pkg2.ParentPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author nathangoshay
 */
public class PostTweetPanel extends ParentPanel {
    
    //accesses all the followers of a certain user and uploads a tweet to their feed
    
    public JButton postTweetButton;
    
    public PostTweetPanel() {
        
        setComponents();
        
    }
    
    private void setComponents() {
        
        postTweetButton = new JButton("Post Tweet");
        postTweetButton.setVisible(true);
        
    }
    
    private void setPostTweetButtonActionListener() {
        
        postTweetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                //first, check to see that the tweet box is occupied
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                
                //then, upload whatever is in the tweet box to all the users' feeds
            }
        });
        
    }
    
    
}
