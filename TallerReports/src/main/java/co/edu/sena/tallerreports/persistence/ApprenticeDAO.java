/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.tallerreports.persistence;

import co.edu.sena.tallerreports.model.Apprentice;
import java.util.List;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author Aprendiz
 */
public class ApprenticeDAO implements IApprenticeDAO{

    @Override
    public void insert(Apprentice apprentice) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(apprentice);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Apprentice find(Long document) throws Exception {
        try {
            return EntityManagerHelper.getEntityManager().find(Apprentice.class, document);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Apprentice> findAll() throws Exception {
        try {
            Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Apprentice.findAll");
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void update(Apprentice appretience) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(appretience);
            
        } catch (Exception e) {
        }JOptionPane.showMessageDialog(null, "Losiento no pudo ser actualizado");
    }

    @Override
    public void delete(Apprentice apprentice) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
