/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.tallerreports.controller;

import co.edu.sena.tallerreports.model.Apprentice;
import co.edu.sena.tallerreports.persistence.DAOFactory;
import co.edu.sena.tallerreports.persistence.EntityManagerHelper;
import java.util.List;

/**
 *
 * @author Aprendiz
 */
public class ApprenticeController {
    
    public void validate(Apprentice apprentice) throws Exception{
        if (apprentice.getDocument() == null){
            throw new Exception("Su documento es null");
        }
        if (apprentice.getFullName() == null){
            throw new Exception("El nombre es null");
        }
        if (apprentice.getIdCourse() == null){
            throw new Exception("El numero de curso es null");
        }
    }
    
    public void insert(Apprentice apprentice) throws Exception
    {
        validate(apprentice);
        EntityManagerHelper.beginTransaction();
        DAOFactory.getApprenticeDAO().insert(apprentice);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }
    
    public Apprentice find(Long document) throws Exception
    {
        if(document == 0)
        {
            throw new Exception("El documento es obligatorio");
        }
          
        return DAOFactory.getApprenticeDAO().find(document);
    }
    
    public List<Apprentice> findAll() throws Exception
    {
        return DAOFactory.getApprenticeDAO().findAll();
    }
}
