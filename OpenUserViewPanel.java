/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg2.Panels.AdminView;

import assignment.pkg2.Panels.UserInfoView.FollowingListPanel;
import assignment.pkg2.Panels.UserInfoView.FeedListPanel;
import assignment.pkg2.Panels.UserInfoView.UserIDPanel;
import assignment.pkg2.Panels.UserInfoView.TweetMessagePanel;
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


public class OpenUserViewPanel extends ParentPanel {      

    private static OpenUserViewPanel USER_VIEW_INSTANCE;

    private static JFrame frame;
    
    private JPanel userIDPanel;
    private JPanel followUserPanel;
    private JPanel followingListPanel;
    private JPanel tweetMessagePanel;
    private JPanel postTweetPanel;
    private JPanel feedListPanel;
    
    
    private DefaultMutableTreeNode root;
    private Map<String, Observer> allUsers;

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
        
        addComponent(frame, userIDPanel, 0, 0, 1, 6, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addComponent(frame, followUserPanel, 0, 0, 1, 6, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addComponent(frame, followingListPanel, 0, 0, 1, 6, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addComponent(frame, tweetMessagePanel, 0, 0, 1, 6, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addComponent(frame, postTweetPanel, 0, 0, 1, 6, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addComponent(frame, feedListPanel, 0, 0, 1, 6, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
       
    }
    
    //initializes all the components
    void setComponents() {
        frame = new JFrame("Assignment 2 : Mini Twitter");
        formatFrame();
        
        userIDPanel = new UserIDPanel();
        followUserPanel = new FollowUserPanel();
        followingListPanel = new FollowingListPanel();
        tweetMessagePanel = new TweetMessagePanel();
        postTweetPanel = new PostTweetPanel();
        feedListPanel = new FeedListPanel();

        allUsers = new HashMap<String, Observer>();
        root = new UserGroup("Root");
        allUsers.put(((User) root).getUniqueID(), (Observer) this.root);

        
    }

    //sets up basics of the frame
    private void formatFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        frame.setSize(800, 400);
        frame.setVisible(true);
    }

}

