/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.tallerreports.reports;

import co.edu.sena.tallerreports.persistence.EntityManagerHelper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

/**
 *
 * @author JART
 */
public class ReportController {
     protected Connection conn = null;
    
    public ReportController(){
            try {
                Map<String, Object> properties = EntityManagerHelper.getEntityManager().getProperties();
                String driver = properties.get("javax.persistence.jdbc.driver").toString();
                String user = properties.get("javax.persistence.jdbc.user").toString();
                String password = properties.get("javax.persistence.jdbc.password").toString();
                String url = properties.get("javax.persistence.jdbc.url").toString();
                
                Class.forName(driver);
                conn = DriverManager.getConnection(url, user, password);
                Statement statement = conn.createStatement();
                System.out.println("Conexión establecida");
            } catch (ClassNotFoundException | SQLException e) {
                
            }
}
    
    public void  close(){
        try {
            conn.close();
        } catch (SQLException e) {
            
        }
    }




    
}
