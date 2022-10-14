/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.tallerreports.persistence;

import co.edu.sena.tallerreports.model.Apprentice;
import co.edu.sena.tallerreports.model.LateArrival;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Aprendiz
 */
public interface ILateArrivalDAO {
    public void insert(LateArrival lateArrival) throws Exception;
    public void update(LateArrival lateArrival)throws Exception;
    public void delete(LateArrival lateArrival)throws  Exception;
    public List<LateArrival> find(Apprentice documentApprentice)throws Exception;
    public List<LateArrival> findAll() throws Exception;  
    public LateArrival find(Date dateArrival)throws Exception;
}
