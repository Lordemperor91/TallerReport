/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.tallerreports.utils;

import javax.swing.JOptionPane;

/**
 *Objetivo: clase de librerias para utileria para mensaje en pantalla  
 * Fecha: 09/10/2022
 * @author Gabriel Cardona
 */
public class MessageUtils {
    public static void showInfoMessage(String message){
        JOptionPane.showMessageDialog(null, message,"mensaje",JOptionPane.INFORMATION_MESSAGE);
        
    }
    public static void showWarnigMessage(String message){
        JOptionPane.showMessageDialog(null, message,"Advertencia",JOptionPane.WARNING_MESSAGE);
        
    }
    public static void showErrorMessage(String message){
        JOptionPane.showMessageDialog(null, message,"ERROR",JOptionPane.ERROR_MESSAGE);
        
    }
    
}
