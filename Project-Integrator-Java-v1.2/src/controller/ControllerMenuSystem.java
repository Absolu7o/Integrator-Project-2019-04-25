package controller;

import static controller.ControllerMain.userlogin;
import java.util.Date;
import model.Systemview;
import model.Userlog;
import view.ViewLogin;
import view.ViewMenuSystem;
import view.ViewRegisterGuestCheck;

public class ControllerMenuSystem extends ControllerMain {

    public void callRegisterGuestCheck() {
        new ViewRegisterGuestCheck();
        insertUserLog(new Userlog(0, new Systemview(9), userlogin, new Date(), "Troca de Tela"));
    }

    public void callMenuSystem() {
        new ViewMenuSystem();
        insertUserLog(new Userlog(0, new Systemview(4), userlogin, new Date(), "Troca de Tela"));
    }

    public void executeLogout() {
	new ViewLogin();
        insertUserLog(new Userlog(0, new Systemview(3), userlogin, new Date(), "Logout"));
    }

}
