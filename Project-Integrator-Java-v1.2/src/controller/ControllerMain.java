package controller;

import hibernate.ConnectHibernate;
import model.Userlog;
import model.Userlogin;
import org.hibernate.Session;
import view.ViewLogin;
import view.ViewMaster;

public abstract class ControllerMain {

    static Session db;
    static Userlogin userlogin = new Userlogin();
        
    public static void main(String[] args) {

        ViewMaster.setConstraints();
        new ViewLogin();
        
    }
    
    public void insertUserLog(Userlog userlog){
        db = ConnectHibernate.getSessionFactory().getCurrentSession();
        db.beginTransaction();
        db.save(userlog);
        db.getTransaction().commit();
    }

}
