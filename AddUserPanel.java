/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg2;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author nathangoshay
 */


public class AddUserPanel extends ParentPanel {     //REWRITE THE NAMES AND SUCH!!!!

    private JPanel treePanel;
    private Map<String, Observer> allUsers;

    private JButton addUserButton;
    private JButton addGroupButton;
    private JTextField userId;
    private JTextField groupId;

    public AddUserPanel(JPanel treePanel, Map<String, Observer> allUsers) {
        super();
        this.treePanel = treePanel;
        this.allUsers = allUsers;

        setComponents();
        addComponents();
    }


    private void addComponents() {
        addComponent(this, userId, 0, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addComponent(this, addUserButton, 1, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addComponent(this, groupId, 0, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addComponent(this, addGroupButton, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
    }

    private void setComponents() {
        userId = new JTextField("User ID");
        groupId = new JTextField("Group ID");

        addUserButton = new JButton("Add User");
        setAddUserButtonActionListener();

        addGroupButton = new JButton("Add Group");
        setAddGroupButtonActionListener();
    }


    private void setAddUserButtonActionListener() {
        addUserButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // check if user ID already exists
                if (allUsers.containsKey(userId.getText())) {
                    SpecificInfo popup = new SpecificInfo("Error!",
                            "User already exists!\nPlease choose a different user name.",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    Observer child = new SingleUser(userId.getText());

                    allUsers.put(((User) child).getUniqueID(), child);
                    ((TreeView) treePanel).addSingleUser((DefaultMutableTreeNode) child);
                }
            }
        });
    }

    /**
     * Initializes action listener for AddGroupButton.  Adds GroupUser with the
     * specified user ID to the TreePanel if the user ID does not already exist.
     *
     * If a SingleUser is selected in the TreePanel, the new GroupUser will be added
     * as a sibling of the selected User.  If a GroupUser is selected in the TreePanel,
     * the new GroupUser will be added as a child of  the selected User.
     */
    private void setAddGroupButtonActionListener() {
        addGroupButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // check if user ID already exists
                if (allUsers.containsKey(groupId.getText())) {
                    SpecificInfo popup = new SpecificInfo("Error!",
                            "User already exists!\nPlease choose a different user name.",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    Observer child = new UserGroup(groupId.getText());

                    allUsers.put(((User) child).getUniqueID(), child);
                    ((TreeView) treePanel).addGroupUser((DefaultMutableTreeNode) child);
                }
            }
        });
    }

}
