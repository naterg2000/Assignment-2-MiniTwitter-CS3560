/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg2;

import assignment.pkg2.Panels.AdminView.AddUserPanel;
import assignment.pkg2.TreeView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author nater
 */
public class TwitterGUI {   //this class handles the GUI
    
    JPanel panel = new JPanel();
    private TreeView treeViewPanel;
    JOptionPane infoPane;
        
    //admin panel
    //buttons
    JButton addUserButton, 
            addGroupButton,
            openUserViewButton, 
            showUserTotalButton, 
            showTotalMessagesButton, 
            showGroupTotalButton,  
            showPositivityPercentageButton = new JButton("Show positivity percentage"), 
            validateUserIDsButton, 
            mostRecentUpdatedUserButton;
    //text fields and areas
    JTextField userIDTextField, 
               groupIDTextField;
    JTextArea treeViewArea;
    
    private DefaultMutableTreeNode root;
    private Map<String, Observer> allUsers;
    
    //user view panel
    //buttons
    public JButton followUserButton;
    public JButton postTweetButton;
    
    //text fields and areas
    //public JTextField userIDTextField;    might be able to reuse this one
    public JTextArea followingListTextArea;
    public JTextArea tweetFeedTextArea;
    public JTextArea typeTweetTextArea;
    
    public JFrame frame = new JFrame("Mini Twitter");
    
    private String userTarget, groupTarget;
    
    private int totalMessages = 0;
    
    
    public static void main(String[] args) {
        
        TwitterGUI t = new TwitterGUI();
        
    }
    
    public TwitterGUI() {
        
        run();
        
    }
    
    public void run() {
        
        //initializes the frame and all that then sets up the admin control panel
        frame.setSize(1000, 630);
        /*
        frame.add(adminControlPanel);
        frame.add(userInfoPanel);
        */
        frame.add(panel);
        //frame.setResizable(false);    //makes it so the window cnanot be resized
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        initializeAdminPanel();
        initializeUserView();
        
        createAdminPanel();
        
    }
    
    private void initializeAdminPanel() {
        
        //buttons
        addUserButton = new JButton("Add User");
        addGroupButton = new JButton("Add Group");
        openUserViewButton = new JButton("Show User View");
        showUserTotalButton = new JButton("Show total users");
        showTotalMessagesButton = new JButton("Show total messages");
        showGroupTotalButton = new JButton("Show group total");
        showPositivityPercentageButton = new JButton("Show positivity percentage");
        validateUserIDsButton = new JButton("validate IDs");
        mostRecentUpdatedUserButton = new JButton("Show most recent updated user");
        
        //creates functinallity for JButtons
        addUserButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                if(userTarget == "") {
                       System.out.println("No target User ID"); //make this into a popup
                }
                else {
                    addUserButtonPressed();
                }
                
            } 
        } );
        
        addGroupButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                addGroupButtonPressed();
            } 
        } );
        
        openUserViewButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                openUserViewButtonPressed();
            } 
        } );
        
        showUserTotalButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                showUserTotalButtonPressed();
            } 
        } );
        
        showTotalMessagesButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                showTotalMessagesButtonPressed();
            } 
        } );
        
        showGroupTotalButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                showGroupTotalButtonPressed();
            } 
        } );
        
        showPositivityPercentageButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                showPositivityPercentageButtonPressed();
            } 
        } );
        
        validateUserIDsButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                validateUserIDsButtonPressed();
            } 
        } );
        
        mostRecentUpdatedUserButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                mostRecentUpdatedUserButtonPressed();
            } 
        } );
        
        
        //text fields
        userIDTextField = new JTextField("User ID: ");
        groupIDTextField = new JTextField("Group ID: ");
        treeViewArea = new JTextArea("Root");
        
        //add components to panel
        panel.add(addUserButton);
        panel.add(addGroupButton);
        panel.add(openUserViewButton);
        panel.add(showUserTotalButton);
        panel.add(showTotalMessagesButton);
        panel.add(showGroupTotalButton);
        panel.add(showPositivityPercentageButton);
        
        panel.add(userIDTextField);
        panel.add(groupIDTextField);
        
        //adds the tree view panel to the general panel
        treeViewPanel.add(treeViewArea);
        panel.add(treeViewPanel);
        
        allUsers = new HashMap<String, Observer>();
        root = new UserGroup("Root");
        allUsers.put(((User) root).getUniqueID(), (Observer) this.root);
        
        treeViewPanel = new TreeView(root);
        
    }
    
    private void initializeUserView() {
        
        //buttons
        followUserButton = new JButton("Follow user");
        postTweetButton = new JButton("Post tweet");

        //text areas
        userIDTextField = new JTextField("User ID: ");
        followingListTextArea = new JTextArea("User is following these other users...");
        typeTweetTextArea = new JTextArea("Type tweet here... ");
        tweetFeedTextArea = new JTextArea("User's feed");
    
    
        //add cpmponents to panel
        panel.add(followUserButton);
        panel.add(postTweetButton);
        panel.add(userIDTextField);
        panel.add(followingListTextArea);
        panel.add(typeTweetTextArea);
        panel.add(tweetFeedTextArea);
        
        
    }
    
    //sets all the bounds for the components
    public void createAdminPanel() {
        
        //set up sizes and positions
        treeViewArea.setBounds(15, 15, 333, 570);
        
        userIDTextField.setBounds(363, 15, 273, 100);
        groupIDTextField.setBounds(363, 130, 273, 100);
        addUserButton.setBounds(693, 15, 273, 100);
        addGroupButton.setBounds(693, 130, 273, 100);
        openUserViewButton.setBounds(363, 245, 606, 100);
        showUserTotalButton.setBounds(363, 360, 273, 100);
        showGroupTotalButton.setBounds(693, 360, 273, 100);
        showTotalMessagesButton.setBounds(363, 485, 273, 100);
        showPositivityPercentageButton.setBounds(693, 485, 273, 100);
        
        
        //make components visible 
        addUserButton.setVisible(true);
        addGroupButton.setVisible(true);
        openUserViewButton.setVisible(true);
        showUserTotalButton.setVisible(true);
        showTotalMessagesButton.setVisible(true);
        showGroupTotalButton.setVisible(true);
        userIDTextField.setVisible(true);
        groupIDTextField.setVisible(true);
        showPositivityPercentageButton.setVisible(true);
        
        treeViewArea.setVisible(true);
        
        
        
    }
    
    //sets all the bounds for the components
    public void createUserView() {
    
        
        //set all the sizes and everything
        userIDTextField.setBounds(15, 15, 476, 100);
        followUserButton.setBounds(506, 15, 465, 100);
        followingListTextArea.setBounds(15, 130, 955, 150);
        typeTweetTextArea.setBounds(15, 300, 770, 100);
        postTweetButton.setBounds(800, 300, 170, 100);
        tweetFeedTextArea.setBounds(15, 413, 955, 150);
        
        
        //set visibilities
        userIDTextField.setVisible(true);
        followUserButton.setVisible(true);
        postTweetButton.setVisible(true);
        followingListTextArea.setVisible(true);
        tweetFeedTextArea.setVisible(true);
        
        
        //make user view components visible
        userIDTextField.setVisible(true);
        followUserButton.setVisible(true);
        postTweetButton.setVisible(true);
        followingListTextArea.setVisible(true);
        tweetFeedTextArea.setVisible(true);
        
        //make admin control panel components invisible
        addUserButton.setVisible(false);
        addGroupButton.setVisible(false);
        openUserViewButton.setVisible(false);
        showUserTotalButton.setVisible(false);
        showTotalMessagesButton.setVisible(false);
        showGroupTotalButton.setVisible(false);
        userIDTextField.setVisible(false);
        groupIDTextField.setVisible(false);
        showPositivityPercentageButton.setVisible(false);
        
        treeViewArea.setVisible(false);
        
    }
    
    //sets the panels to be visible
    public void makeAdminPanelVisible() {
        
        
        //make admin control panel components invisible
        addUserButton.setVisible(true);
        addGroupButton.setVisible(true);
        openUserViewButton.setVisible(true);
        showUserTotalButton.setVisible(true);
        showTotalMessagesButton.setVisible(true);
        showGroupTotalButton.setVisible(true);
        userIDTextField.setVisible(true);
        groupIDTextField.setVisible(true);
        showPositivityPercentageButton.setVisible(true);
        
        treeViewArea.setVisible(false);
        
        //make user view components visible
        userIDTextField.setVisible(false);
        followUserButton.setVisible(false);
        postTweetButton.setVisible(false);
        followingListTextArea.setVisible(false);
        tweetFeedTextArea.setVisible(false);
        
        
    }
    
    public void makeUserViewPanelVisible() {
        
        
        
        //make user view components visible
        userIDTextField.setVisible(true);
        followUserButton.setVisible(true);
        postTweetButton.setVisible(true);
        followingListTextArea.setVisible(true);
        tweetFeedTextArea.setVisible(true);
        
        //make admin control panel components invisible
        addUserButton.setVisible(false);
        addGroupButton.setVisible(false);
        openUserViewButton.setVisible(false);
        showUserTotalButton.setVisible(false);
        showTotalMessagesButton.setVisible(false);
        showGroupTotalButton.setVisible(false);
        userIDTextField.setVisible(false);
        groupIDTextField.setVisible(false);
        showPositivityPercentageButton.setVisible(false);
        
        treeViewArea.setVisible(false);
        
    }
    
    //admin panel buttons
    
    //when addUserButton is pressed...
    public void addUserButtonPressed() {
        
        //sets the target user to be the string value after position 8 which is the space after the colon
        userTarget = userIDTextField.getText().substring(8);
        
        //from here, the user is added to the treeView
        Observer child = new SingleUser(userTarget);
        
        allUsers.put(((User) child).getUniqueID(), child);
        ((TreeView) treeViewPanel).addSingleUser((DefaultMutableTreeNode) child);
        
        treeViewPanel.singleUserList.add((SingleUser) child);
        
    }
    
    public void addGroupButtonPressed() {
        
        //adds a group to the tree view
        groupTarget = groupIDTextField.getText().substring(8);
        
        //from here, make a new group node in the tree
        Observer child = new UserGroup(groupTarget);

        allUsers.put(((User) child).getUniqueID(), child);
        ((TreeView) treeViewPanel).addGroupUser((DefaultMutableTreeNode) child);
        
        treeViewPanel.groupUserList.add((UserGroup) child);
        
    }
    
    public void openUserViewButtonPressed() {
        
        //calls createUserView() method
        createUserView();
        
    }
    
    public void showUserTotalButtonPressed() {
        
        //returns the total number of single users in the tree
        System.out.println(treeViewPanel.getTotalSingleUsers());
        
    }
    
    public void showGroupTotalButtonPressed() {
        
        //returns the total number of groups in the tree
        System.out.println(treeViewPanel.getTotalGroupUsers());
        infoPane = new JOptionPane();
        infoPane.showMessageDialog(frame, "Hi there. This is the group total button");
        
        
        
        
    }
    
    public void showTotalMessagesButtonPressed() {
        
        //returns the total number of messages from a certain user
        //in SingleUser, return this.getTotalTweets(); 
        
        //get total for each singleUser
        for(int i = 0; i < treeViewPanel.singleUserList.size(); i++) 
            totalMessages += treeViewPanel.singleUserList.get(i).messageCount;
        
        for(int i = 0; i < treeViewPanel.groupUserList.size(); i++) 
            totalMessages += treeViewPanel.groupUserList.get(i).getMessageCount();
        
        infoPane = new JOptionPane();
        infoPane.showMessageDialog(frame, "There are " + totalMessages + " total messages.");
        
    }
    
    
    public void showPositivityPercentageButtonPressed() {
        
        //returns the total number of positive tweets in a user's feed
        //get specific user id, divide positiveMessageCount/getTotalTweets();
        int totalPositiveMessages = 0;
        
        for(int i = 0; i < treeViewPanel.singleUserList.size(); i++) 
            totalPositiveMessages += treeViewPanel.singleUserList.get(i).getPositiveTweetCount();
        
        System.out.println("Positiveity percentage: " + (totalPositiveMessages/totalMessages) * 100);
        
        
    }
    
    
    
    //assignment 3
    public int validateUserIDsButtonPressed() {
        
        //loop through all IDs and detect duplicate numbers. Do not need to fix or prevent them.
        String firstUserID = treeViewPanel.singleUserList.get(0).getUniqueID();
        
        for(int i = 0; i < treeViewPanel.singleUserList.size() - 1; i++) {
            
            if(firstUserID.equals(treeViewPanel.singleUserList.get(i + 1).getUniqueID())) {
                System.out.println("Duplicate user: " + treeViewPanel.singleUserList.get(i + 1).getUniqueID());
                return 1;   //1 for duplicate user
            }
            
        }
        
        return 0; //no duplicate users
    }
    
    public void mostRecentUpdatedUserButtonPressed() {
        
        long mostRecentUpdate = 0;
        
        //loop through all users and look for the largest updateTime
        for(int i = 0; i < treeViewPanel.singleUserList.size() - 1; i++) {
            
            Long currentUserUpdateTime = treeViewPanel.singleUserList.get(i).lastUpdatedTime, 
                 nextUserUpdatedTime = treeViewPanel.singleUserList.get(i + 1).lastUpdatedTime;
            
            //get current user update time and compare to next user update time
            if(nextUserUpdatedTime > currentUserUpdateTime) {
                
                mostRecentUpdate = nextUserUpdatedTime;
                
            }
            
        }
        
        System.out.println("The most recently updated time is: " + mostRecentUpdate);
        
    }
    
}
