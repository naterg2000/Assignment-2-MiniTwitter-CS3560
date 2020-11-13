/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg2;

import javax.swing.JOptionPane;

/**
 *
 * @author nathangoshay
 */
public class SpecificInfo {
    
    public SpecificInfo(String title, String message, int messageType) {
        JOptionPane.showMessageDialog(null, message, title, messageType);
    }

    
}
