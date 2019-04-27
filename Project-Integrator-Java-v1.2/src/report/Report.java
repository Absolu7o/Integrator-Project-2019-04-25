/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package report;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.Session;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.engine.spi.SessionFactoryImplementor;

/**
 *
 * @author Brendon
 */
public class Report {

    private Connection conn;
    
    public Report(Session db) {
        SessionFactoryImplementor factory = (SessionFactoryImplementor) db.getSessionFactory();
        ConnectionProvider provider = factory.getConnectionProvider();
        try {
            this.conn = provider.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void createReport(String reportFile) throws JRException{
        InputStream report = Report.class.getResourceAsStream("/report/" + reportFile + ".jasper");
        JasperPrint print = JasperFillManager.fillReport(report, null, conn);
        JasperViewer.viewReport(print,false);
    }
}
