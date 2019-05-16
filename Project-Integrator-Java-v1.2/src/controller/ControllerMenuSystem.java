package controller;

import java.util.Date;
import model.Company;
import model.Systemview;
import model.Userlog;
import model.Userlogin;
import net.sf.jasperreports.engine.JRException;
import report.Report;
import view.ViewLogin;
import view.ViewMenuSystem;
import view.ViewRegisterGuestCheck;

public class ControllerMenuSystem extends ControllerMain {
    
    Userlogin userlogin;

    public void callRegisterGuestCheck() {
        new ViewRegisterGuestCheck();
        insertUserLog(new Userlog(0, new Company(1), new Systemview(9), userlogin, new Date(), "Troca de Tela"));
    }

    public void callMenuSystem() {
        new ViewMenuSystem();
        insertUserLog(new Userlog(0, new Company(1), new Systemview(4), userlogin, new Date(), "Troca de Tela"));
    }

    public void callReport(String reportFile) throws JRException {
        Report report = new Report(db);
        report.createReport(reportFile);
    }

    public void executeLogout() {
        new ViewLogin();
        insertUserLog(new Userlog(0, new Company(1), new Systemview(3), userlogin, new Date(), "Logout"));
    }

}