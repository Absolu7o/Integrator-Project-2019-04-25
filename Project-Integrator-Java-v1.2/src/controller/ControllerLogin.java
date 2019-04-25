package controller;

import static controller.ControllerMain.db;
import hibernate.ConnectHibernate;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import model.Systemview;
import model.Userlog;
import model.Userlogin;
import view.ViewMenuSystem;

public class ControllerLogin extends ControllerMain {

    public void executeLogin(String login, String password) {

        userlogin = new Userlogin();
        List<Userlogin> list;

        db = ConnectHibernate.getSessionFactory().getCurrentSession();
        db.beginTransaction();
        list = (List<Userlogin>) db.createQuery("from Userlogin where (login='" + login + "') and (password='" + password + "')").list();
        list.forEach((userLogin) -> {
            userlogin.setCode(userLogin.getCode());
            userlogin.setName(userLogin.getName());
            userlogin.setLogin(userLogin.getLogin());
            userlogin.setPassword(userLogin.getPassword());
            userlogin.setActive(userLogin.getActive());
            userlogin.setUserpermission(userLogin.getUserpermission());
        });
        db.getTransaction().commit();
        
        if (userlogin.getCode() > 0) {
            new ViewMenuSystem(userlogin.getUserpermission().getCashier(), userlogin.getUserpermission().getAttendant());
            insertUserLog(new Userlog(0, new Systemview(4), userlogin, new Date(), "Login"));
        } else {
            JOptionPane.showMessageDialog(null, "Login e/ou Senha est�o incorretos!");
        }

    }

}
