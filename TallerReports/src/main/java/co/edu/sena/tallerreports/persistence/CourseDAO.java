/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.tallerreports.persistence;

import co.edu.sena.tallerreports.model.Course;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Aprendiz
 */
public class CourseDAO implements ICourseDAO{

    @Override
    public List<Course> findAll() throws Exception {
        try {
            Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Course.findAll");
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Course find(Integer id) throws Exception {
        try {
            return EntityManagerHelper.getEntityManager().find(Course.class, id);
        } catch (RuntimeException e) {
            throw e;
        }
    }
    
}
