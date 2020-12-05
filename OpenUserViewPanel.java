/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg2.Panels.AdminView;

import assignment.pkg2.ParentPanel;
//import assignment.pkg2.Panels.UserInfoView.FollowingListPanel;
import assignment.pkg2.Panels.UserInfoView.FeedListPanel;
import assignment.pkg2.Panels.UserInfoView.UserIDPanel;
//import assignment.pkg2.Panels.UserInfoView.TweetMessagePanel;
import assignment.pkg2.Panels.UserInfoView.FollowUserPanel;
import assignment.pkg2.Panels.UserInfoView.PostTweetPanel;
import assignment.pkg2.Driver;
import assignment.pkg2.Observer;
import assignment.pkg2.User;
import assignment.pkg2.UserGroup;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;

import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class OpenUserViewPanel extends ParentPanel {      

    private static OpenUserViewPanel USER_VIEW_INSTANCE;

    private static JFrame frame;
    
    private JPanel userIDPanel;
    private JPanel followUserPanel;
    private JPanel followingListPanel;
    private JPanel tweetMessagePanel;
    private JPanel postTweetPanel;
    private JPanel feedListPanel;
    
    JButton testButton = new JButton("This is a test");
    
    
    private DefaultMutableTreeNode root;
    private Map<String, Observer> allUsers;
    
    public static void main(String[] args) {
        
        USER_VIEW_INSTANCE.getInstance();
        
    }

    //returns instance of user view panel for singleton pattern
    public static OpenUserViewPanel getInstance() {
        if (USER_VIEW_INSTANCE == null) {
            synchronized (Driver.class) {
                if (USER_VIEW_INSTANCE == null) {
                    USER_VIEW_INSTANCE = new OpenUserViewPanel();
                }
            }
        }
        return USER_VIEW_INSTANCE;
    }

    private OpenUserViewPanel() {
        super();

        setComponents();
        addComponents();
    }

    //adds components to the frame and adjusts their positions
    private void addComponents() {
        
        
        
        addComponent(frame, userIDPanel, 0, 0, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH);   //user id field
        addComponent(frame, followUserPanel, 0, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH); //follow user
        addComponent(frame, followingListPanel, 0, 0, 2, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH);  //following
        addComponent(frame, tweetMessagePanel, 0, 0, 3, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH);  //tweet message here
        addComponent(frame, postTweetPanel, 0, 0, 3, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);  //post tweet
        addComponent(frame, feedListPanel, 0, 0, 4, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH); //This user's tweet feed
        
        
        
        //addComponent(frame, testButton, 25, 50, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        
    }
    
    //initializes all the components
    void setComponents() {
        frame = new JFrame("User View | Mini Twitter | Assignment 2");
        formatFrame();
        /*
        
        userIDPanel = new JPanel();
        followUserPanel = new JPanel();
        followingListPanel = new JPanel();
        tweetMessagePanel = new JPanel();
        postTweetPanel = new JPanel();
        feedListPanel = new JPanel();
        
        /*
        
        JTextField userIDTextField = new JTextField("User ID Field");
        
        JButton followUserButton = new JButton("Follow user");
        JButton tweetButton = new JButton("Post tweet");
        
        JTextArea followingListArea = new JTextArea("Follower list");
        JTextArea tweetTextBoxArea = new JTextArea("Tweet message here");
        JTextArea feedListArea = new JTextArea("This user's tweet feed");
        
        /*
        
        userIDPanel.add(userIDTextField);
        followUserPanel.add(followUserButton);
        followingListPanel.add(followingListArea);
        tweetMessagePanel.add(tweetTextBoxArea);
        postTweetPanel.add(tweetButton);
        feedListPanel.add(feedListArea);
        
        */
        
        /*                                      I can't seem to make it work this way so until I can figure this out, we'll do it a different way!
        userIDPanel = new UserIDPanel();
        followUserPanel = new FollowUserPanel();
        followingListPanel = new FollowingListPanel();
        tweetMessagePanel = new TweetMessagePanel();
        postTweetPanel = new PostTweetPanel();
        feedListPanel = new FeedListPanel();
*/

        allUsers = new HashMap<String, Observer>();
        root = new UserGroup("Root");
        allUsers.put(((User) root).getUniqueID(), (Observer) this.root);

        
    }

    //sets up basics of the frame
    private void formatFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        frame.setSize(1500, 800);
        frame.setVisible(true);
    }

    //button action listeners
    public void setFollowUserButtonActionListener() {
        
    }
    
    public void setPostTweetButtonActionListener() {
        
    }
    
    
}

