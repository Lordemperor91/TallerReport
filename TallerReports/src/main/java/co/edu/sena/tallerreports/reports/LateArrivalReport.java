/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.tallerreports.reports;

import co.edu.sena.tallerreports.utils.MessageUtils;
import co.edu.sena.tallerreports.utils.Constants;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author JART
 */
public class LateArrivalReport extends ReportController {
    public LateArrivalReport(){
    super();    
    
    
    }
public void executeReportLateArrivalAll(){
        try {
            String file = getClass().getResource(Constants.REPORT_LATEARRIVALS).getFile();
            System.out.println("Cargando reporte desde: "+file);
            if(file == null){
                MessageUtils.showErrorMessage("No se encuentra el archivo JASPER");
                System.exit(2);
            }
            
            //reporte maestro
            JasperReport masterReport = null;
            try {
                masterReport = (JasperReport) JRLoader.loadObjectFromFile(file);
            } catch (JRException e) {
                MessageUtils.showErrorMessage("Error cargando reporte maestro" +e.getMessage());
                System.exit(3);
            }
            //llenar el reporte con la conexión a BD 
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, null, conn);
            
            //lanzar el viewer de jasper -> abre una ventana con el reporte generado
            JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);//boolean, tru->cierra todo
            jasperViewer.setTitle("Reporte de todas las faltas");
            jasperViewer.setVisible(true);
            
        } catch (JRException e) {
            MessageUtils.showErrorMessage(e.getMessage());
        }
    }



}
