package controller;


import hibernate.ConnectHibernate;
import java.math.BigDecimal;
import model.Additional;
import model.Productcategory;
import model.Userlog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import view.ViewLogin;
import view.ViewMaster;
import view.ViewRegisterGuestCheck;

public abstract class ControllerMain {

    static SessionFactory sessionFactory = ConnectHibernate.getSessionFactory();
    static Session db;
    //static Userlogin userlogin = new Userlogin();

    public static void main(String[] args) {
        ViewMaster.setConstraints();
        //new ViewLogin();
       
    }

    public void insertUserLog(Userlog userlog) {
        db = sessionFactory.getCurrentSession();
        db.beginTransaction();
        db.save(userlog);
        db.getTransaction().commit();
    }

}
