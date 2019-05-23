package controller;

import static controller.ControllerMain.db;
import hibernate.ConnectHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Guestcheck;
import org.hibernate.HibernateException;

public class ControllerRegisterGuestCheck extends ControllerMain {

    public void insertGuestCheck(Guestcheck guestCheck) {

        Serializable serial;

        try {
            db = sessionFactory.getCurrentSession();
            db.beginTransaction();
            serial = db.save(guestCheck);
            db.getTransaction().commit();

            JOptionPane.showMessageDialog(null, "Comanda " + serial + " inserida com sucesso!");

        } catch (HibernateException hbm) {
            db.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, hbm.getMessage());
        }

    }

    public void updateGuestCheck(Guestcheck guestCheck) {

        try {
            db = sessionFactory.getCurrentSession();
            db.beginTransaction();
            db.update(guestCheck);
            db.getTransaction().commit();

            JOptionPane.showMessageDialog(null, "Comanda " + guestCheck.getCode() + " alterada com sucesso!");

        } catch (HibernateException hbm) {
            db.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, hbm.getMessage());
        }

    }

    public Guestcheck selectGuestCheck(int code) {

        Guestcheck guestCheck = new Guestcheck();
        List<Guestcheck> list;

        try {
            db = ConnectHibernate.getSessionFactory().getCurrentSession();
            db.beginTransaction();
            list = (List<Guestcheck>) db.createQuery("from Guestcheck where (code=" + code + ") and (code_company=" + 1 + ")").list();
            list.forEach((guestCk) -> {
                guestCheck.setCode(guestCk.getCode());
                guestCheck.setBarcode(guestCk.getBarcode());
                System.out.println(guestCk.getBarcode());
            });
            db.getTransaction().commit();

        } catch (HibernateException hbm) {
            db.getTransaction().rollback();
        }

        return guestCheck;
    }

    public List listAllGuestCheck() {
        List guestchecks = new ArrayList();
        List<Guestcheck> list;

        try {
            db = sessionFactory.getCurrentSession();
            db.beginTransaction();
            list = (List<Guestcheck>) db.createQuery(" from Guestcheck").list();
            list.forEach((guestcheck) -> {
                guestchecks.add(guestcheck);
            });
            db.getTransaction().commit();
        } catch (HibernateException hbm) {
            db.getTransaction().rollback();
        }

        return guestchecks;
    }
}
