/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.tallerreports.controller;

import co.edu.sena.tallerreports.model.Apprentice;
import co.edu.sena.tallerreports.model.LateArrival;
import co.edu.sena.tallerreports.persistence.DAOFactory;
import co.edu.sena.tallerreports.persistence.EntityManagerHelper;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Aprendiz
 */
public class LateArrivalController {
     public void validate(LateArrival lateArrival) throws Exception{
        if (lateArrival == null) {
            throw new Exception("Es null sus datos");
        }
        if (lateArrival.getDocumentApprentice() == null){
            throw new Exception("Su documento es null");
        }
        if (lateArrival.getDateArrival() == null){
            throw new Exception("Es obligatoria la fecha");
        }
        if (lateArrival.getObservations() == null){
            throw new Exception("Es obligatoria la observación");
        }
    }
     
     public void insert(LateArrival lateArrival) throws Exception
    {
        validate(lateArrival);
        EntityManagerHelper.beginTransaction();
        DAOFactory.getArrivalDAO().insert(lateArrival);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }
     
     public List<LateArrival> findAll() throws Exception
    {
        return DAOFactory.getArrivalDAO().findAll();
    }
     
     public List<LateArrival> find(Apprentice document) throws Exception
    {
        return DAOFactory.getArrivalDAO().find(document);
    }

    public LateArrival find(Date dateArrival) throws Exception {
      
        return DAOFactory.getArrivalDAO().find(dateArrival);
    }
}
