/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg2;

/**
 *
 * @author nathangoshay
 */
public class UserGroupVisitor implements Visitor  { 
    
    
    //visitor methods
    @Override
    public int visitUser(User user) {   //counts all the users in the groups
        
        int count = 0;
        
        if(user.getClass() == SingleUser.class) {
            count += visitSingleUser(user);
        }
        else if(user.getClass() == UserGroup.class) {
            count += visitUserGroup(user);
        }
        
        
        return count;
    }

    @Override
    public int visitSingleUser(User user) { //return 0 because we are looking for group count only
        return 0;
    }

    @Override
    public int visitUserGroup(User user) {  
        int count = 0;
        
        //fill in some code here
        for(User u : ((UserGroup) user).getUserGroups().values()) {
            if(u.getClass() == UserGroup.class) {
                ++count;
            }
            count += visitUser(u);
        }
        
        return count;
    }
    
}
