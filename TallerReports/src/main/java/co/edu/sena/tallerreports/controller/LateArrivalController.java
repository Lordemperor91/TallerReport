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
import javax.swing.JOptionPane;

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
     
      public void delete(LateArrival lateArrival) throws Exception {
        if (lateArrival == null) {
            throw new Exception("La llegada no se encuentra registrada");
        }

        if (lateArrival.getId() == 0) {
            throw new Exception("El id es necesario");
        }

        LateArrival agedLateArrival = DAOFactory.getArrivalDAO().find(lateArrival.getId());
        if (agedLateArrival == null) {
            throw new Exception("No hay boservacion por eliminar");
        }

        EntityManagerHelper.beginTransaction();
        DAOFactory.getArrivalDAO().delete(agedLateArrival);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }
       public void update(Apprentice apprentice) throws Exception {

        Apprentice agedApprentice = DAOFactory.getApprenticeDAO().find(apprentice.getDocument());

        if (agedApprentice == null) {
            JOptionPane.showMessageDialog(null, "no se pudo actualizar ");
        }

        agedApprentice.setFullName(apprentice.getFullName());
        agedApprentice.setIdCourse(apprentice.getIdCourse());

        validate(apprentice);
        EntityManagerHelper.beginTransaction();
        DAOFactory.getApprenticeDAO().update(apprentice);
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

    private void validate(Apprentice apprentice) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
