package model;
// Generated 15/05/2019 21:27:16 by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Userlog generated by hbm2java
 */
@Entity
@Table(name="userlog"
    ,schema="gcsystem"
)
public class Userlog  implements java.io.Serializable {


     private int code;
     private Company company;
     private Systemview systemview;
     private Userlogin userlogin;
     private Date datetimeins;
     private String logtype;

    public Userlog() {
    }

	
    public Userlog(int code) {
        this.code = code;
    }
    public Userlog(int code, Company company, Systemview systemview, Userlogin userlogin, Date datetimeins, String logtype) {
       this.code = code;
       this.company = company;
       this.systemview = systemview;
       this.userlogin = userlogin;
       this.datetimeins = datetimeins;
       this.logtype = logtype;
    }
   
     @Id 

    
    @Column(name="code", unique=true, nullable=false)
    public int getCode() {
        return this.code;
    }
    
    public void setCode(int code) {
        this.code = code;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="code_company")
    public Company getCompany() {
        return this.company;
    }
    
    public void setCompany(Company company) {
        this.company = company;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="code_systemview")
    public Systemview getSystemview() {
        return this.systemview;
    }
    
    public void setSystemview(Systemview systemview) {
        this.systemview = systemview;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="code_userlogin")
    public Userlogin getUserlogin() {
        return this.userlogin;
    }
    
    public void setUserlogin(Userlogin userlogin) {
        this.userlogin = userlogin;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="datetimeins", length=29)
    public Date getDatetimeins() {
        return this.datetimeins;
    }
    
    public void setDatetimeins(Date datetimeins) {
        this.datetimeins = datetimeins;
    }

    
    @Column(name="logtype", length=20)
    public String getLogtype() {
        return this.logtype;
    }
    
    public void setLogtype(String logtype) {
        this.logtype = logtype;
    }




}


