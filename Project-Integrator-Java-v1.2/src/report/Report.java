/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package report;

import org.hibernate.Session;

/**
 *
 * @author Brendon
 */
public class Report {

    private Session db;
    
    public Report(Session db) {
        this.db=db;
    }
    
    public void userLogAnalitc(){
        
    }
    
    public void userLogSynthetic(){
        
    }
}