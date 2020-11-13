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
public class Driver {   //singleton pattern, I thin?????
    
    public static void main(String[] args) {    
        
        Driver app = new Driver();
        
    }
    
    public Driver() {
        run();
    }
    
    private void run() {
        
        AdminControlPanel.getInstance();
        
    }
    
    
}
