package model;
// Generated 19/05/2019 14:54:07 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Usercompany generated by hbm2java
 */
@Entity
@Table(name="usercompany"
    ,schema="macrotech"
)
public class Usercompany  implements java.io.Serializable {


     private int code;
     private Company company;
     private Userlogin userlogin;

    public Usercompany() {
    }

	
    public Usercompany(int code) {
        this.code = code;
    }
    public Usercompany(int code, Company company, Userlogin userlogin) {
       this.code = code;
       this.company = company;
       this.userlogin = userlogin;
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
    @JoinColumn(name="code_userlogin")
    public Userlogin getUserlogin() {
        return this.userlogin;
    }
    
    public void setUserlogin(Userlogin userlogin) {
        this.userlogin = userlogin;
    }




}


