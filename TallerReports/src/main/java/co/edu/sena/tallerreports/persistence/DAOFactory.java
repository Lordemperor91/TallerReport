/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.tallerreports.persistence;

/**
 *
 * @author Aprendiz
 */
public class DAOFactory {
    private static IApprenticeDAO apprenticeDAO = new ApprenticeDAO();
    private static ICourseDAO courseDAO = new CourseDAO();
    private static ILateArrivalDAO arrivalDAO = new LateArrivalDAO();

    public static IApprenticeDAO getApprenticeDAO() {
        return apprenticeDAO;
    }

    public static ICourseDAO getCourseDAO() {
        return courseDAO;
    }

    public static ILateArrivalDAO getArrivalDAO() {
        return arrivalDAO;
    }
    
    
}
