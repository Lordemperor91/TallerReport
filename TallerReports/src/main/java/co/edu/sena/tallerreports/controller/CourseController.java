/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.tallerreports.controller;

import co.edu.sena.tallerreports.model.Course;
import co.edu.sena.tallerreports.persistence.DAOFactory;
import co.edu.sena.tallerreports.persistence.EntityManagerHelper;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Aprendiz
 */
public class CourseController {
    public List<Course> findAll() throws Exception
    {
        return DAOFactory.getCourseDAO().findAll();
    }
     public void validate(Course course) throws Exception {
        if (course == null) {
            throw new Exception("el curso es vacio");
        }
        if (course.getCareer() == null) {
            throw new Exception("el curso es vacio");
        }
        if (course.getId() == 0) {
            throw new Exception("La identificacion no tiene informacion");
        }

    }
     public void insert(Course course) throws Exception {
        validate(course);

         EntityManagerHelper.beginTransaction();
        DAOFactory.getCourseDAO().insert(course);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }
      public void update(Course course) throws Exception {

        Course oldCourse = DAOFactory.getCourseDAO().find(course.getId());

        if (oldCourse == null) {
            JOptionPane.showMessageDialog(null, "Losiento no fue posible actualizar ");
        }

        oldCourse.setCareer(course.getCareer());

        validate(course);
        EntityManagerHelper.beginTransaction();
        DAOFactory.getCourseDAO().update(course);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();

    }
       public void delete(Course course) throws Exception {
        /*merge*/

        Course oldApprentice = DAOFactory.getCourseDAO().find(course.getId());
        if (oldApprentice == null) {
            JOptionPane.showMessageDialog(null, "no fue posible eliminar ");
        }

        validate(course);
        EntityManagerHelper.beginTransaction();
        DAOFactory.getCourseDAO().delete(course);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();

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
