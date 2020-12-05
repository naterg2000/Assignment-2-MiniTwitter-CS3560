/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg2;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author nater
 */
public class UserViewPanel {
    
    //buttons
    public JButton followUserButton;
    public JButton postTweetButton;

    //text areas
    public JTextField userIDTextField;
    public JTextArea followingListTextArea;
    public JTextArea tweetFeedTextArea;
    
    public UserViewPanel() {
        
        initializeComponents();
        
    }
    
    private void initializeComponents() {
        
        //buttons
        followUserButton = new JButton("Follow user");
        postTweetButton = new JButton("Post tweet");
        
        //text fields
        userIDTextField = new JTextField();
        followingListTextArea = new JTextArea();
        tweetFeedTextArea = new JTextArea();
    }
    
}
