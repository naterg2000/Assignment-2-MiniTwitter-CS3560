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
public interface Subject {  //pbserver pattern
    
    public void attach(Observer observer);
    
    public void notifyObservers();
    
}
