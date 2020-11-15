/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg2;
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
/**
 *
 * @author nathangoshay
 *
 */

public class TreeView extends JPanel {      

    private DefaultMutableTreeNode rootNode;
    private DefaultTreeModel treeModel;
    private JTree tree;
    private JScrollPane scrollPane;

    public TreeView(DefaultMutableTreeNode root) {
        super(new GridLayout(1,0));

        rootNode = root;
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

}