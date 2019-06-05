package controller;

import hibernate.ConnectHibernate;
import model.Userlog;
import model.Userlogin;
import model.Userpermission;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import view.ViewLogin;
import view.ViewMaster;
import view.ViewMenuSystem;

public abstract class ControllerMain {

    static SessionFactory sessionFactory = ConnectHibernate.getSessionFactory();
    static Session db;
    static Userlogin userlogin = new Userlogin();

    public static void main(String[] args) {

        ViewMaster.setConstraints();
        //new ViewLogin();
        Userpermission userp = new Userpermission(new Userlogin(1), Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE);
        new ViewMenuSystem(userp);
       
    }

    public void insertUserLog(Userlog userlog) {

//        try {
//            db = sessionFactory.getCurrentSession();
//            db.beginTransaction();
//            db.save(userlog);
//            db.getTransaction().commit();
//            
//        } catch (HibernateException hbm) {
//            db.getTransaction().rollback();
//            //ViewMaster.closeApp();
//        }

    }

}
