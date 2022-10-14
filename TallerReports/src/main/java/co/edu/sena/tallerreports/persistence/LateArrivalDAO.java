/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.tallerreports.persistence;

import co.edu.sena.tallerreports.model.Apprentice;
import co.edu.sena.tallerreports.model.LateArrival;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author Aprendiz
 */
public class LateArrivalDAO implements ILateArrivalDAO{

    @Override
    public void insert(LateArrival lateArrival) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(lateArrival);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<LateArrival> findAll() throws Exception {
        try {
            Query query = EntityManagerHelper.getEntityManager().createNamedQuery("LateArrival.findAll");
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<LateArrival> find(Apprentice documetApprentice) throws Exception {
        try {
            Query query = EntityManagerHelper.getEntityManager()
                    .createNamedQuery("LateArrival.findByDocumentApprentice")
                    .setParameter("documentApprentice", documetApprentice);
            return query.getResultList();
            
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public LateArrival find(Date dateArrival) throws Exception {
        try {
            return EntityManagerHelper.getEntityManager().find(LateArrival.class, dateArrival);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void update(LateArrival lateArrival) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(lateArrival);
        } catch (Exception e) {
        }JOptionPane.showMessageDialog(null, "Losiento no se puedo actualizar");
    }

    @Override
    public void delete(LateArrival lateArrival) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(lateArrival);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Losiento no se puedo eliminar");
        }
    }
    
}
