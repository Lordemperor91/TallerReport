/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.tallerreports.controller;

import co.edu.sena.tallerreports.model.Course;
import co.edu.sena.tallerreports.persistence.DAOFactory;
import java.util.List;

/**
 *
 * @author Aprendiz
 */
public class CourseController {
    public List<Course> findAll() throws Exception
    {
        return DAOFactory.getCourseDAO().findAll();
    }
    public Course find(Integer id) throws Exception
    {
        if(id == 0)
        {
            throw new Exception("La ficha es obligatorio");
        }
          
        return DAOFactory.getCourseDAO().find(id);
    }
}
