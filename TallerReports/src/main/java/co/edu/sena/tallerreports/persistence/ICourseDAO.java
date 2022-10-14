/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.tallerreports.persistence;

import co.edu.sena.tallerreports.model.Course;
import java.util.List;

/**
 *
 * @author Aprendiz
 */
public interface ICourseDAO {
   public void update(Course course  )throws Exception;
   public void insert(Course course) throws  Exception;
   public void delete(Course  course) throws Exception;
    public Course find(Integer id) throws Exception;
    public List<Course> findAll() throws Exception; 
}
