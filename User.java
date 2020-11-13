/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg2;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author nathangoshay
 */
public abstract class User extends DefaultMutableTreeNode implements Observer {    //composite pattern
    
    String uniqueID;
    int totalTweets = 0;
    
    //make User constructor here!
    public User(String ID) {
        
        super(ID);
        uniqueID = ID;
        this.setTotalTweets(0);
        
    }
    
    public abstract int getSingleUserCount();
    public abstract int getUserGroupCount();
    public abstract boolean contains(String id);
          
    
    public String getUniqueID() {
        return this.uniqueID;
    }
    public int getTotalTweets() {
        return this.totalTweets;
    }
    
    
    public void setTotalTweets(int n) {
        totalTweets = n;
    }
    
    //visitor pattern
    public abstract void accept(Visitor visitor);
    
}
