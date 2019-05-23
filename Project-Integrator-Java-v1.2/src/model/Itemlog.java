package model;
// Generated 19/05/2019 14:54:07 by Hibernate Tools 4.3.1


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
 * Itemlog generated by hbm2java
 */
@Entity
@Table(name="itemlog"
    ,schema="dksystem"
)
public class Itemlog  implements java.io.Serializable {


     private int code;
     private Company company;
     private Item item;
     private Userlogin userlogin;
     private Date datetimeins;
     private String logtype;

    public Itemlog() {
    }

	
    public Itemlog(int code) {
        this.code = code;
    }
    public Itemlog(int code, Company company, Item item, Userlogin userlogin, Date datetimeins, String logtype) {
       this.code = code;
       this.company = company;
       this.item = item;
       this.userlogin = userlogin;
       this.datetimeins = datetimeins;
       this.logtype = logtype;
    }
   
     @Id 

    
    @Column(name="code", nullable=false)
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
    @JoinColumn(name="code_item")
    public Item getItem() {
        return this.item;
    }
    
    public void setItem(Item item) {
        this.item = item;
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


