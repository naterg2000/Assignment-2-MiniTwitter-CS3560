/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg2;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import java.awt.GridLayout;

public class TreeView extends JPanel {
    
    int numSingleUsers = 0, numGroupUsers = 0;

    private DefaultMutableTreeNode rootNode;
    private DefaultTreeModel treeModel;
    private JTree tree;
    private JScrollPane scrollPane;
    public ArrayList<SingleUser> singleUserList = new ArrayList<>();
    public ArrayList<UserGroup> groupUserList = new ArrayList<>();

    public TreeView(DefaultMutableTreeNode node) {
        super(new GridLayout(1,0));

        rootNode = node;
        setComponents();
        addComponents();
    }

    public JTree getTree() {
        return this.tree;
    }
    public DefaultMutableTreeNode getRoot() {
        return this.rootNode;
    }

    public void addGroupUser(DefaultMutableTreeNode node) {
        DefaultMutableTreeNode parentNode = null;
        TreePath parentPath = tree.getSelectionPath();
        if (parentPath == null) {
            parentNode = rootNode;
        } else {
            parentNode = (DefaultMutableTreeNode) parentPath.getLastPathComponent();
        }

        
        if (parentNode.getUserObject().getClass() == SingleUser.class) {
            parentNode = (DefaultMutableTreeNode) parentNode.getParent();
        }
        addUser(parentNode, node, true);
        numGroupUsers++;
    }

    public void addSingleUser(DefaultMutableTreeNode child) {
        DefaultMutableTreeNode parentNode = null;
        TreePath parentPath = tree.getSelectionPath();

        // set parent as selected User, set as root if no User is selected
        if (parentPath == null) {
            parentNode = rootNode;
        } else {
            parentNode = (DefaultMutableTreeNode) parentPath.getLastPathComponent();
        }

        // add to parent GroupUser if selected node is a SingleUser
        if (parentNode.getUserObject().getClass() == SingleUser.class) {
            parentNode = (DefaultMutableTreeNode) parentNode.getParent();
        }
        addUser(parentNode, child, true);
        numSingleUsers++;
    }


    
    private void addUser(DefaultMutableTreeNode parent, DefaultMutableTreeNode c, boolean shouldBeVisible) {
        DefaultMutableTreeNode child = new DefaultMutableTreeNode(c);

        if (parent == null) {
            parent = rootNode;
        }

        treeModel.insertNodeInto(child, parent, parent.getChildCount());

        if (shouldBeVisible) {
            tree.scrollPathToVisible(new TreePath(child.getPath()));
        }

        if (parent.getClass() != UserGroup.class) {
            parent = (DefaultMutableTreeNode) parent.getUserObject();
        }
        ((UserGroup) parent).addUserToGroup((User) c);
    }

    private void addComponents() {
        add(scrollPane);
    }

    private void setComponents() {
        treeModel = new DefaultTreeModel(rootNode);
        treeModel.addTreeModelListener(new TreeViewListener());

        tree = new JTree(treeModel);
        formatTree();

        scrollPane = new JScrollPane(tree);
    }

    private void formatTree() {
        tree.setEditable(true);
        tree.getSelectionModel().setSelectionMode (TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.setShowsRootHandles(true);
        tree.setSelectionRow(0);
    }

    /**
     * TreeModelListener for this TreeModel.
     */
    private class TreeViewListener implements TreeModelListener {
        public void treeNodesChanged(TreeModelEvent e) {
        }
        public void treeNodesInserted(TreeModelEvent e) {
        }
        public void treeNodesRemoved(TreeModelEvent e) {
        }
        public void treeStructureChanged(TreeModelEvent e) {
        }
    }
    
    public int getTotalSingleUsers() {
        return numSingleUsers;
    }
    
    public int getTotalGroupUsers() {
        return numGroupUsers;
    }

    
}
