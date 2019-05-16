package controller;

import java.util.ArrayList;
import java.util.List;
import model.Guestcheck;

public class ControllerRegisterGuestCheck extends ControllerMain {

	public List findResult(){
            List guestchecks = new ArrayList();
            List<Guestcheck> list;
            
            db = sessionFactory.getCurrentSession();
            db.beginTransaction();
            list = (List<Guestcheck>) db.createQuery(" from Guestcheck").list();
            list.forEach((guestcheck) -> {
                guestchecks.add(guestcheck);
            });
            db.getTransaction().commit();
            
            return guestchecks;
        }
        
}
