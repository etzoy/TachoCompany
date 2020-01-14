/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import cleancompany.cleanCompany;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author LENOVO
 */
public class generarReportes {
    

    public void reporteClientes(cleanCompany principal) {
        

//        try {
//            JasperReport reporte = (JasperReport) JRLoader.loadObject("reporteClientes.jasper");
//            Map parametros = new HashMap();
//            JasperPrint print = JasperFillManager.fillReport(reporte, null, principal.javaPostgreSQLBasic.connectDatabase());
//            JasperViewer jv = new JasperViewer(print,false);
//            jv.setTitle("Reporte Clientes");
//            jv.setVisible(true);
//            
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error al mostrar el Reporte "+e);
//        }
    
		// descarga dentro del mismo proyecto
                try {
                    
//                    JasperPrint jasperPrint = JasperFillManager.fillReport(
//				"reporteClientes.jasper", null,
//				principal.javaPostgreSQLBasic.connectDatabase());
//		JRPdfExporter exp = new JRPdfExporter();
//		exp.setExporterInput(new SimpleExporterInput(jasperPrint));
//		exp.setExporterOutput(new SimpleOutputStreamExporterOutput("reporteClientes.pdf"));
//		SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
//		exp.setConfiguration(conf);
//		exp.exportReport();
 
		// se muestra en una ventana aparte para su descarga
		JasperPrint jasperPrintWindow = JasperFillManager.fillReport(
				"reporteClientes.jasper", null,
				principal.javaPostgreSQLBasic.connectDatabase());
		JasperViewer jasperViewer = new JasperViewer(jasperPrintWindow,false);
                jasperViewer.setTitle("Reporte Clientes");
		jasperViewer.setVisible(true);
                
                
            
        } catch (Exception e) {
            System.out.print("error "+e);
        }
		
    }
    public void reporteServicios(cleanCompany principal) {
        

//        try {
//            JasperReport reporte = (JasperReport) JRLoader.loadObject("reporteClientes.jasper");
//            Map parametros = new HashMap();
//            JasperPrint print = JasperFillManager.fillReport(reporte, null, principal.javaPostgreSQLBasic.connectDatabase());
//            JasperViewer jv = new JasperViewer(print,false);
//            jv.setTitle("Reporte Clientes");
//            jv.setVisible(true);
//            
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error al mostrar el Reporte "+e);
//        }
    
		// descarga dentro del mismo proyecto
                try {
                    
//                    JasperPrint jasperPrint = JasperFillManager.fillReport(
//				"reporteClientes.jasper", null,
//				principal.javaPostgreSQLBasic.connectDatabase());
//		JRPdfExporter exp = new JRPdfExporter();
//		exp.setExporterInput(new SimpleExporterInput(jasperPrint));
//		exp.setExporterOutput(new SimpleOutputStreamExporterOutput("reporteClientes.pdf"));
//		SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
//		exp.setConfiguration(conf);
//		exp.exportReport();
 
		// se muestra en una ventana aparte para su descarga
		JasperPrint jasperPrintWindow = JasperFillManager.fillReport(
				"reporteServicios.jasper", null,
				principal.javaPostgreSQLBasic.connectDatabase());
		JasperViewer jasperViewer = new JasperViewer(jasperPrintWindow,false);
                jasperViewer.setTitle("Reporte Servicios");
		jasperViewer.setVisible(true);
                
                
            
        } catch (Exception e) {
            System.out.print("error "+e);
        }
    }
                
    public void reporteAgenda(cleanCompany principal) {
        

//        try {
//            JasperReport reporte = (JasperReport) JRLoader.loadObject("reporteClientes.jasper");
//            Map parametros = new HashMap();
//            JasperPrint print = JasperFillManager.fillReport(reporte, null, principal.javaPostgreSQLBasic.connectDatabase());
//            JasperViewer jv = new JasperViewer(print,false);
//            jv.setTitle("Reporte Clientes");
//            jv.setVisible(true);
//            
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error al mostrar el Reporte "+e);
//        }
    
		// descarga dentro del mismo proyecto
                try {
                    
//                    JasperPrint jasperPrint = JasperFillManager.fillReport(
//				"reporteClientes.jasper", null,
//				principal.javaPostgreSQLBasic.connectDatabase());
//		JRPdfExporter exp = new JRPdfExporter();
//		exp.setExporterInput(new SimpleExporterInput(jasperPrint));
//		exp.setExporterOutput(new SimpleOutputStreamExporterOutput("reporteClientes.pdf"));
//		SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
//		exp.setConfiguration(conf);
//		exp.exportReport();
 
		// se muestra en una ventana aparte para su descarga
		JasperPrint jasperPrintWindow = JasperFillManager.fillReport(
				"reporteAgenda.jasper", null,
				principal.javaPostgreSQLBasic.connectDatabase());
		JasperViewer jasperViewer = new JasperViewer(jasperPrintWindow,false);
                jasperViewer.setTitle("Reporte Agenda");
		jasperViewer.setVisible(true);
                
                
            
        } catch (Exception e) {
            System.out.print("error "+e);
        }
		
    }
    

}
