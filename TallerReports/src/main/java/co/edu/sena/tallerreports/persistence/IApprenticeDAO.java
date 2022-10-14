/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.tallerreports.persistence;

import co.edu.sena.tallerreports.model.Apprentice;
import java.util.List;

/**
 *
 * @author Aprendiz
 */
public interface IApprenticeDAO {
    public void insert(Apprentice apprentice) throws Exception;
    public void update (Apprentice appretience)throws  Exception;
    public void delete(Apprentice apprentice)throws  Exception;
    public Apprentice find(Long document) throws Exception;
    public List<Apprentice> findAll() throws Exception;
}
