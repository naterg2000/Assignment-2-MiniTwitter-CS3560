/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg2;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author nathangoshay
 */
public class UserGroup extends User implements Subject {    //composite pattern
    
    private Map<String, User> groupUserMap;
    private Map<String, User> followerMap;
    
    
    public UserGroup(String ID) {
        
        super(ID);
        groupUserMap = new HashMap<String, User>();
        
    }

    public Map<String, User> getUserGroups() {
        return groupUserMap;
    }
    
    public User addUserToGroup(User user) {
        if(!this.contains(user.getUniqueID())) {
            this.groupUserMap.put(user.getUniqueID(), user);
        }
        return this;
        
        
    }
    
    private boolean containsUserGroup() {
        
        boolean hasGroup = false;
        
        for(User u : this.groupUserMap.values()) {
            
            if(u.getClass() == UserGroup.class) {
                hasGroup = true;
            }
            
        }
        return hasGroup;
        
    }
    
    //composite pattern
    
    @Override
    public int getSingleUserCount() {
        
        int count = 0;
        
        for(User u : this.groupUserMap.values()) {
            
            count += u.getSingleUserCount();
            
        }
        return count;
    }

    @Override
    public int getUserGroupCount() {
        
        int count = 0;
        
        for(User u : this.groupUserMap.values()) {
            if(u.getClass() == UserGroup.class) {
                ++count;
                count += u.getSingleUserCount();
            }
            
        }
        
        return count;
        
    }
    
    public boolean contains(String ID) {
        
        boolean contains = false;
        
        for(User u : groupUserMap.values()) {
            
            if(u.contains(ID)) {
                contains = true;
            }
            
        }
        
        return false;
    }
    
    public int getMessageCount() {
        int total = 0; 
        for(User u : this.groupUserMap.values()) {
            total += u.getTotalTweets();
        }
        return total;
    }
    
    //subject methods
    
    //------------------------------need to implement this!
    @Override
    public void attach(Observer observer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }
    
    @Override
    public void notifyObservers() {
        
        for(Observer ob : followerMap.values()) {
            ob.update(this);
        }
        
    }
    
    //observer pattern
    @Override
    public void update(Subject subject) {
        
        for(User u : groupUserMap.values()) {
            
            ((Observer) u).update(subject);
            
        }
        
    }

    //visitor pattern
    @Override
    public void accept(Visitor visitor) {
        
        for(User u : groupUserMap.values()) {
            
            u.accept(visitor);
            
        }
        visitor.visitUserGroup(this);
        
    }
    
}
