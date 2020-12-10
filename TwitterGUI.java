/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg2;

import assignment.pkg2.Panels.AdminView.AddUserPanel;
import assignment.pkg2.TreeView;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
    
    private String userTarget, groupTarget;
    
    private int totalMessages = 0;
    
    public GridBagLayout adminLayout = new GridBagLayout();
    private GridBagLayout userViewLayout = new GridBagLayout();
    
    public GridBagConstraints gbc = new GridBagConstraints();
    
    //private JPanel panel = new JPanel(); 
    private JPanel adminPanel = new JPanel(new GridBagLayout());
    private JPanel userViewPanel = new JPanel(new GridBagLayout());
        
    private TreeView treeViewPanel;
    private JOptionPane infoPane;
    
    
    
    
    public JFrame frame = new JFrame("Mini Twitter");
    public JFrame userViewFrame = new JFrame("User View");
        
    //admin panel
    //buttons
    private JButton addUserButton, 
            addGroupButton,
            openUserViewButton, 
            showUserTotalButton, 
            showTotalMessagesButton, 
            showGroupTotalButton,  
            showPositivityPercentageButton, 
            validateUserIDsButton, 
            mostRecentUpdatedUserButton;
    
    //text fields and areas
    private JTextField userIDTextField, 
                       groupIDTextField;
    
    private JTextArea treeViewArea;
    
    private DefaultMutableTreeNode root;
    private Map<String, Observer> allUsers;
    
    
    //user view panel
    //buttons
    private JButton followUserButton, 
                    postTweetButton, 
                    toAdminViewButton;
    
    //text fields and areas
    //public JTextField userIDTextField;    might be able to reuse this one
    public JTextArea followingListTextArea, 
                    tweetFeedTextArea, 
                    typeTweetTextArea;
    
    private static TwitterGUI INSTANCE;
    
    
    
    public static void main(String[] args) { 
        TwitterGUI t = new TwitterGUI(); 
    }
    
    public TwitterGUI() { 
        run(); 
    }
    
    //singleton pattern
    public static TwitterGUI getInstance() {
        if (INSTANCE == null) {
            synchronized (Driver.class) {
                if (INSTANCE == null) {
                    INSTANCE = new TwitterGUI();
                }
            }
        }
        return INSTANCE;
    }
    
    
    
    public void run() {
        
        //initializes the frame and all that then sets up the admin control panel
        frame.setSize(1000, 630);
        userViewFrame.setSize(1000, 630);
        
        adminPanel.setLayout(adminLayout);
        userViewPanel.setLayout(userViewLayout);
        gbc.gridx = 0;
        gbc.gridy = 0;
        
        //add everthing to the JPanels
        initializeAdminPanel();
        initializeUserView();
        
        
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        
    }
    
    private void initializeAdminPanel() {
        
        //define buttons
        addUserButton = new JButton("Add User");
        addGroupButton = new JButton("Add Group");
        openUserViewButton = new JButton("Open User View");
        showUserTotalButton = new JButton("Show total users");
        showTotalMessagesButton = new JButton("Show total messages");
        showGroupTotalButton = new JButton("Show group total");
        showPositivityPercentageButton = new JButton("Show positivity percentage");
        validateUserIDsButton = new JButton("validate IDs");
        mostRecentUpdatedUserButton = new JButton("Show most recent updated user");
        
        //define  text fields
        userIDTextField = new JTextField("User ID: ");
        groupIDTextField = new JTextField("Group ID: ");
        //treeViewArea = new JTextArea("Root");
        
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
                System.out.println("Calling openUserView()");
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
        
        
        allUsers = new HashMap<String, Observer>();
        root = new UserGroup("Root");
        allUsers.put(((User) root).getUniqueID(), (Observer) this.root);
        
        
        treeViewPanel = new TreeView(root);
        
        
        
        //tree view
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 40;      //make this component tall
        gbc.weightx = 1.0;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        adminPanel.add(treeViewPanel, gbc);
        
        
        //user ID text field
        gbc.fill = GridBagConstraints.HORIZONTAL;
        //gbc.ipady = 40;      //make this component tall
        gbc.weightx = 0.0;
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 0;
        adminPanel.add(userIDTextField, gbc);
        
        //group ID text field
        gbc.fill = GridBagConstraints.HORIZONTAL;
        //gbc.ipady = 40;      //make this component tall
        gbc.weightx = 0.0;
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 1;
        adminPanel.add(groupIDTextField, gbc);
        
        //add user button
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.gridx = 2;
        gbc.gridy = 0;
        adminPanel.add(addUserButton, gbc);
        
        //add group button
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.gridx = 2;
        gbc.gridy = 1;
        adminPanel.add(addGroupButton, gbc);
        
        //open user view button
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.gridx = 1;
        gbc.gridy = 2;
        adminPanel.add(openUserViewButton, gbc);
        
        //show user total button
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.gridx = 1;
        gbc.gridy = 4;
        adminPanel.add(showUserTotalButton, gbc);
        
        //open group total button
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.gridx = 2;
        gbc.gridy = 4;
        adminPanel.add(showGroupTotalButton, gbc);
        
        //show total messages button
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.gridx = 1;
        gbc.gridy = 5;
        adminPanel.add(showTotalMessagesButton, gbc);
        
        //open group total button
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.gridx = 2;
        gbc.gridy = 5;
        adminPanel.add(showPositivityPercentageButton, gbc);
        
        
        frame.add(adminPanel);
        
        
        
        //treeViewArea.setBounds(15, 15, 333, 570);
        
         
        
        
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
        
        //treeViewArea.setVisible(true);
        
        
        adminPanel.setVisible(true);
        
        
        
        
        
    }
    
    private void initializeUserView() {
        
        //buttons
        followUserButton = new JButton("Follow user");
        postTweetButton = new JButton("Post tweet");
        toAdminViewButton = new JButton("Back to Admin View");

        //text areas
        userIDTextField = new JTextField("User ID: ");
        followingListTextArea = new JTextArea("User is following these other users...");
        typeTweetTextArea = new JTextArea("Type tweet here... ");
        tweetFeedTextArea = new JTextArea("User's feed");
    
    
        
        //JButton functinality
        followUserButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                followUserButtonPressed();
            } 
        } );
        
        postTweetButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                postTweetButtonPressed();
            } 
        } );
        
        
        
        
        //set all the sizes and everything
        userIDTextField.setBounds(15, 15, 476, 100);
        followUserButton.setBounds(506, 15, 465, 100);
        followingListTextArea.setBounds(15, 130, 955, 150);
        typeTweetTextArea.setBounds(15, 300, 770, 100);
        postTweetButton.setBounds(800, 300, 170, 100);
        tweetFeedTextArea.setBounds(15, 413, 955, 150);
        
        userViewFrame.add(userViewPanel);
        
        
        userViewPanel.setVisible(true);
        
    }
    
    //makes a new frame for the user view. Get's the target user ID's information
    public void createUserView() {
        
        //userID text field
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        userViewPanel.add(userIDTextField, gbc);
        
        //followUser button
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.gridx = 1;
        gbc.gridy = 0;
        userViewPanel.add(followUserButton, gbc);
        
        //current following view
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 20;
        gbc.weightx = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        userViewPanel.add(followingListTextArea, gbc);
        
        gbc.ipadx = 0;
        
        //tweet message text view
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.gridx = 0;
        gbc.gridy = 2;
        userViewPanel.add(typeTweetTextArea, gbc);
        
        //post tweet button
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.gridx = 2;
        gbc.gridy = 4;
        userViewPanel.add(postTweetButton, gbc);
        
        //text view of tweets
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 2;
        gbc.gridx = 0;
        gbc.gridy = 3;
        userViewPanel.add(tweetFeedTextArea, gbc);
        
        userViewFrame.setVisible(true);
        
        
    }
    
    
    
    //admin panel button functinality
    
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
    
    //user view functionaolity
    
    void followUserButtonPressed() {
        
        
        
    }
    
    void postTweetButtonPressed() {
        
        
        
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
