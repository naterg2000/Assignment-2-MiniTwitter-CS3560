/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg2;

import java.awt.Button;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import java.awt.GridBagConstraints;  
import java.awt.GridBagLayout; 

/**
 *
 * @author nathangoshay
 */
public class MiniTwitterInterface extends JPanel {
    
    public JFrame frame = new JFrame("Mini Twitter!");
    
    public JTextField userIDTextField, tweetMessageTextField, tweetFeedTextField, userGroupIDTextField;
    public JTextArea treeHierarchyArea;
    
    public JButton backButton, followUserButton, postTweetButton, addUserButton, addGroupButton, openUserViewButton;
    
    public static MiniTwitterInterface app = new MiniTwitterInterface();
    
    
    //tutorial on YT
    JButton b1, b2, b3, b4, b5;
    GridBagConstraints constraints = new GridBagConstraints();
    
    
    public static void main(String[] args) {
        
        //MiniTwitterInterface a = new MiniTwitterInterface();
        
        //from YT Tutorial
        JFrame frame = new JFrame("YT Tutorial");
        frame.setSize(1000, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        
        MiniTwitterInterface app = new MiniTwitterInterface();
        frame.add(app);
        
    }
    
    public MiniTwitterInterface() { // x and y are the size of the JFrame. 
        
        /*
        //create frame and all the jazz
        frame.add(panel);
        
        //frame.getContentPane().setLayout(new FlowLayout()); //not sure what this does lol
        frame.setSize(x, y);
        frame.setLayout(null);
        frame.setVisible(true);
        
        
        //stops the process when the window is closed
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        */
        
        setLayout(new GridBagLayout());
        
        b1 = new JButton("Button 1");
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(b1, constraints);
        
        b2 = new JButton("Button 2");
        constraints.gridx = 1;
        constraints.gridy = 1;
        add(b2, constraints);
        
        b3 = new JButton("Button 3");
        constraints.gridx = 2;
        constraints.gridy = 2;
        add(b3, constraints);
        
        b4 = new JButton("Button 4");
        constraints.gridx = 3;
        constraints.gridy = 3;
        add(b4, constraints);
        
        b5 = new JButton("Button 5");
        constraints.gridx = 4;
        constraints.gridy = 4;
        add(b5, constraints);
        
        
        
        
        //stops program when window is closed
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
    
        
        
        /* -------------------------------------------------------------------------------------------------------------------------------
        
        //initialize buttons and text fields
        
        /*
        addUserButton = new JButton("Add user");
        addGroupButton = new JButton("Add new group");
        addUserButton.setBounds(310, 100, 200, 60);
        addGroupButton.setBounds(560, 100, 200, 60);
        openUserViewButton.setBounds(560, 200, 200, 60);
        followUserButton = new JButton("Follow User");
        backButton = new JButton("<");
        postTweetButton = new JButton("Post Tweet");
        openUserViewButton = new JButton("Open user view");
        
        userIDTextField = new JTextField("User ID Field", 20);
        userGroupIDTextField = new JTextField("User Group ID Field", 20);
        tweetMessageTextField = new JTextField("Tweet message here...", 20);
        tweetFeedTextField = new JTextField("Tweet feed...", 20);
        // There should be an end of group comment here
        
        //add all componenets to frame
        //text fields
        frame.add(userIDTextField);
        frame.add(userGroupIDTextField);
        frame.add(tweetMessageTextField);
        frame.add(tweetFeedTextField);
        
        frame.add(treeHierarchyArea);
        
        
        //buttons
        frame.add(followUserButton);
        frame.add(postTweetButton);
        frame.add(backButton);
        frame.add(addUserButton);
        frame.add(addGroupButton);
        
        
        //by default, everything in user view will be invisible because Admin Panel is the startup page
        userIDTextField.setVisible(false);
        userGroupIDTextField.setVisible(false);
        tweetMessageTextField.setVisible(false);
        tweetFeedTextField.setVisible(false);
        
        followUserButton.setVisible(false);
        postTweetButton.setVisible(false);
        backButton.setVisible(false);
        addUserButton.setVisible(false);
        addGroupButton.setVisible(false);
        openUserViewButton.setVisible(false);
        
        
        
        //set up Admin Panel
        treeHierarchyArea = new JTextArea("Root");  //!!!!!!!!!!change this to visit the root user and get the namemfrom there !!!!!!!!!!!
        treeHierarchyArea.setBounds(0, 20, 200, 400);
        frame.add(treeHierarchyArea);
        treeHierarchyArea.setVisible(true);
        
        
        //set up User View
        
        userIDTextField.setLocation(10, 50);
        tweetMessageTextField.setLocation(110, 50);
        tweetFeedTextField.setLocation(210, 50);
        
        
        followUserButton.setBounds(10, 100, 100, 40);
        postTweetButton.setBounds(110, 100, 100, 40);
        backButton.setBounds(210, 100, 100, 40);
        
        
        
        */ //--------------------------------------------------------------------------------------------------------------------------------------
        
        
        
                
    }
    
    
     
    
    /*
    private void makeFrame(int x, int y) {
        
        frame.add(panel);
        
        frame.getContentPane().setLayout(new FlowLayout()); //not sure what this does lol
        frame.setSize(x, y);
        frame.setLayout(null);
        frame.setVisible(true);
        
        //stops the process when the window is closed
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        /*
        JButton butt = new JButton("Hi");
        butt.setBounds(100, 100, 100, 40);
        frame.add(butt);    
        
    }   */   
    
    /*
    private void makeAdminPanel() {
        
        
        
    }   */
    
    /*
    private void makeUserView() {
        
        //need a userID text area, button: follow user, List view of who this user is following, text area with the tweet message, button to post tweet, and list 
        //view of tweet feed
        
        userIDTextField = new JTextField("User ID Field", 100);
        tweetMessageTextField = new JTextField("Tweet message here...", 100);
        tweetFeedTextField = new JTextField("Tweet feed...", 100);
        
        followUserButton = new JButton();
        backButton = new JButton();
        postTweetButton = new JButton();
        
        followUserButton.setBounds(100, 100, 100, 40);
        postTweetButton.setBounds(100, 100, 100, 40);
        backButton.setBounds(100, 100, 100, 40);
        
        panel.add(userIDTextField);
        panel.add(tweetMessageTextField);
        panel.add(tweetFeedTextField);
        
        panel.add(followUserButton);
        panel.add(postTweetButton);
        panel.add(backButton);
        
        
        
        
        
        
    } */
    
    private void makeAdminView() {
        
        
        
        
    }
    
    
    //singleton method
    public static MiniTwitterInterface getInstance() {
        return app;
    }
    
    public void showMessage() {
        System.out.println("Hello world! This is MiniTwitterInterface speaking!");
    }
    
}
