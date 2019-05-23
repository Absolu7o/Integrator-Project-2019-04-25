package model;
// Generated 19/05/2019 14:54:07 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Userpermission generated by hbm2java
 */
@Entity
@Table(name="userpermission"
    ,schema="macrotech"
)
public class Userpermission  implements java.io.Serializable {


     private int code;
     private Userlogin userlogin;
     private Boolean manager;
     private Boolean cashier;
     private Boolean attendant;
     private Boolean stocker;

    public Userpermission() {
    }

	
    public Userpermission(Userlogin userlogin) {
        this.userlogin = userlogin;
    }
    public Userpermission(Userlogin userlogin, Boolean manager, Boolean cashier, Boolean attendant, Boolean stocker) {
       this.userlogin = userlogin;
       this.manager = manager;
       this.cashier = cashier;
       this.attendant = attendant;
       this.stocker = stocker;
    }
   
     @GenericGenerator(name="generator", strategy="foreign", parameters=@Parameter(name="property", value="userlogin"))@Id @GeneratedValue(generator="generator")

    
    @Column(name="code", nullable=false)
    public int getCode() {
        return this.code;
    }
    
    public void setCode(int code) {
        this.code = code;
    }

@OneToOne(fetch=FetchType.LAZY)@PrimaryKeyJoinColumn
    public Userlogin getUserlogin() {
        return this.userlogin;
    }
    
    public void setUserlogin(Userlogin userlogin) {
        this.userlogin = userlogin;
    }

    
    @Column(name="manager")
    public Boolean getManager() {
        return this.manager;
    }
    
    public void setManager(Boolean manager) {
        this.manager = manager;
    }

    
    @Column(name="cashier")
    public Boolean getCashier() {
        return this.cashier;
    }
    
    public void setCashier(Boolean cashier) {
        this.cashier = cashier;
    }

    
    @Column(name="attendant")
    public Boolean getAttendant() {
        return this.attendant;
    }
    
    public void setAttendant(Boolean attendant) {
        this.attendant = attendant;
    }

    
    @Column(name="stocker")
    public Boolean getStocker() {
        return this.stocker;
    }
    
    public void setStocker(Boolean stocker) {
        this.stocker = stocker;
    }




}


