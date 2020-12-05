/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg2.Panels.AdminView;

import assignment.pkg2.ParentPanel;
import assignment.pkg2.Driver;
import assignment.pkg2.Observer;
import assignment.pkg2.TreeView;
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


public class AdminControlPanel extends ParentPanel {      

    private static AdminControlPanel INSTANCE;

    private static JFrame frame;
    private JPanel treeView;
    private JPanel addUser;
    private JPanel openUserView;
    private JPanel showInfo;

    private DefaultMutableTreeNode root;
    private Map<String, Observer> allUsers;

    public static AdminControlPanel getInstance() {
        if (INSTANCE == null) {
            synchronized (Driver.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AdminControlPanel();
                }
            }
        }
        return INSTANCE;
    }
    
    public static void main(String[] args) {
        AdminControlPanel p = new AdminControlPanel();
    }

    private AdminControlPanel() {
        super();

        setComponents();
        addComponents();
    }

    private void addComponents() {
        addComponent(frame, treeView, 0, 0, 1, 6, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addComponent(frame, addUser, 1, 0, 2, 2, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addComponent(frame, openUserView, 1, 2, 2, 2, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addComponent(frame, showInfo, 1, 4, 2, 2, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
    }

    void setComponents() {
        frame = new JFrame("Assignment 2 : Mini Twitter");
        formatFrame();

        allUsers = new HashMap<String, Observer>();
        root = new UserGroup("Root");
        allUsers.put(((User) root).getUniqueID(), (Observer) this.root);

        treeView = new TreeView(root);
        addUser = new AddUserPanel(treeView, allUsers);
        
        //openUserView = new OpenUserViewPanel(treeView, allUsers);
        //showInfo = new ShowInfoPanel(treeView);

        // set buttons to respond to ENTER key, remove default response to SPACE key
        //UIManager.put("Button.defaultButtonFollowsFocus", Boolean.TRUE);
        //InputMap im = (InputMap) UIManager.get("Button.focusInputMap");
        //im.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "none");
    }

    private void formatFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        frame.setSize(800, 400);
        frame.setVisible(true);
    }

}
