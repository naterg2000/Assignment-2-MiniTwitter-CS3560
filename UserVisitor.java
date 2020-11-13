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
public class UserVisitor implements Visitor {

    @Override
    public int visitUser(User u) {   //count how many single users and users in groups there are in the root group
        
        int totalUsers = 0;
        
        //add 1 to totalUsers
        if(u.getClass() == SingleUser.class) {
            totalUsers += visitSingleUser(u);
        }
        //add all the users in each group to totalUsers
        else if(u.getClass() == UserGroup.class) {
            totalUsers += visitUserGroup(u);
        }
        
        return totalUsers;
        
    }

    @Override
    public int visitSingleUser(User user) {     //counts how many individual users there are
        return 1;
    }

    @Override
    public int visitUserGroup(User u) {  //counts how many users are in a group
        int count = 0; 
        
        for(User user : ((UserGroup) u).getUserGroups().values()) {
            
            if(user.getClass() == SingleUser.class) {
                count += visitSingleUser(user);
            }
            else if(user.getClass() == UserGroup.class) {
                count += visitUserGroup(user);
            }
            
        }
        
        return count;
    }
    
}
