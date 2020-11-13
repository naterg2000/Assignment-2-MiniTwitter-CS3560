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
public interface Visitor {  //for visitor pattern
    
    public int visitUser(User user);
    public int visitSingleUser(User user);
    public int visitUserGroup(User user);
    
}
