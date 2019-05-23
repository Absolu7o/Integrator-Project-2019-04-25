package controller;

import static controller.ControllerMain.db;
import hibernate.ConnectHibernate;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import model.Company;
import model.Systemview;
import model.Userlog;
import model.Userlogin;
import org.hibernate.HibernateException;
import view.ViewMenuSystem;

public class ControllerLogin extends ControllerMain {

    public void executeLogin(String login, String password) {

        userlogin = new Userlogin();
        List<Userlogin> list;

        try {
            db = ConnectHibernate.getSessionFactory().getCurrentSession();
            db.beginTransaction();
            list = (List<Userlogin>) db.createQuery("from Userlogin where (login='" + login + "') and (password='" + password + "')").list();
            list.forEach((userLogin) -> {
                userlogin.setCode(userLogin.getCode());
                userlogin.setName(userLogin.getName());
                userlogin.setLogin(userLogin.getLogin());
                userlogin.setPassword(userLogin.getPassword());
                userlogin.setAvailable(userLogin.getAvailable());
                userlogin.setUserpermission(userLogin.getUserpermission());
            });
            db.getTransaction().commit();

        } catch (HibernateException hbm) {
            db.getTransaction().rollback();
        }

        if (userlogin.getCode() > 0) {
            if (userlogin.getAvailable() == true) {
                new ViewMenuSystem(userlogin.getUserpermission());
                insertUserLog(new Userlog(0, new Company(1), new Systemview(4), userlogin, new Date(), "Login"));
            } else {
                JOptionPane.showMessageDialog(null, "Usuário está Inativo!");
                insertUserLog(new Userlog(0, new Company(1), new Systemview(3), userlogin, new Date(), "Usuário Inativo"));
            }
        } else {
            JOptionPane.showMessageDialog(null, "Login e/ou Senha estão incorretos!");
        }

    }

}
